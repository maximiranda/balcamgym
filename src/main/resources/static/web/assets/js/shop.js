let urlParams = new URLSearchParams(window.location.search);
let id = urlParams.get("id");
const { createApp } = Vue;

createApp({
  data() {
    return {
      clients: [],
      clientId: [],
      clientLogged: [],
      products: [],
      filteredProducts: [],
      productsBg: [
        "../web/assets/images/produc-bg-01.png",
        "../web/assets/images/produc-bg-02-01.png",
      ],
      categories: ["Suplements", "Equipment", "Clothes"],
      suplements: ["Proteins", "Creatines", "BCAA"],
      clothes: ["Men", "Women"],
      checkedCategory: "",
      subcategories: [],
      inputRange: 0,
      searchFilterInput: "",
      isOpen: false,
      cartProducts: [],
      moneyFormat: new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
      }),
      featureds: [],
      noStock: false,
      addCartAllert: false,
      subtotal: 0,
      shippingEstimate: 7,
      taxEstimate: 0.21,
      isLoading : false,
      success : false,
    };
  },
  created() {
    this.loadData();

    const localStorageData = JSON.parse(localStorage.getItem("productsInCart"));
    const priceProduct = JSON.parse(localStorage.getItem("subtotal"));
    const shippingEstimate = JSON.parse(
      localStorage.getItem("shippingEstimate")
    );

    if (priceProduct == null) {
      this.subtotal = 0;
    } else {
      this.subtotal = priceProduct;
    }

    if (localStorageData == null) {
      this.cartProducts = [];
    } else {
      this.cartProducts = localStorageData;
    }

    if (shippingEstimate == null) {
      this.shippingEstimate = 7;
    } else {
      this.shippingEstimate = shippingEstimate;
    }
  },
  methods: {
    makePayment() {
      // axios.post("https://hubbersbank.herokuapp.com/api/transactions/payment", {
      //     cardNumber: "5223 2602 9373 6997",
      //     cardCvv: "125",
      //     amount: "1",
      //     thruDate: "2027-09-20",
      //     cardHolder: "Melba Laflor",
      //     accountNumber: "VIN001",
      //     description: "pago balcamgym",
      //   })
      //   .then((r) => {});
    },
    deleteItem(product) {
      product.stockAux = product.stock;
      this.cartProducts.splice(this.cartProducts.indexOf(product), 1);

      this.subtotal = 0;
      this.cartProducts.forEach((product) => {
        this.subtotal += product.price * product.quantity;
      });

      this.shippingEstimate = 7;
      this.shippingEstimate =
        this.shippingEstimate * 1.2 ** this.cartProducts.length;

      localStorage.setItem(
        "shippingEstimate",
        JSON.stringify(this.shippingEstimate)
      );
      localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts));
      localStorage.setItem("subtotal", JSON.stringify(this.subtotal));
    },
    reduceQuantity(product) {
      if (product.quantity > 1) {
        product.quantity--;
        product.stockAux++;
        localStorage.setItem(
          "productsInCart",
          JSON.stringify(this.cartProducts)
        );
      } else {
        product.stockAux++;
        this.deleteItem(product);
      }

      this.subtotal = 0;
      this.cartProducts.forEach((product) => {
        this.subtotal += product.price * product.quantity;
      });

      localStorage.setItem("subtotal", JSON.stringify(this.subtotal));
    },
    cleanCart() {
      this.subtotal = 0;
      this.cartProducts = [];
      this.shippingEstimate = 7;

      localStorage.setItem(
        "shippingEstimate",
        JSON.stringify(this.shippingEstimate)
      );
      localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts));
      localStorage.setItem("subtotal", JSON.stringify(this.subtotal));
    },
    noStockAllert() {
      this.addCartAllert = false;
      this.noStock = true;
      setTimeout(() => {
        this.noStock = false;
      }, 5000);
    },
    addCart(product) {
      this.addCartAllert = true;
      this.noStock = false;
      setTimeout(() => {
        this.addCartAllert = false;
      }, 3000);

      if (this.cartProducts.includes(product)) {
        product.quantity++;
        product.stockAux--;
        localStorage.setItem(
          "productsInCart",
          JSON.stringify(this.cartProducts)
        );
        if (product.stockAux < 0) {
          this.noStockAllert();
        }
      } else {
        product.stockAux = product.stock;
        product.quantity = 1;
        product.stockAux--;
        this.cartProducts.push(product);
        localStorage.setItem(
          "productsInCart",
          JSON.stringify(this.cartProducts)
        );
      }

      this.shippingEstimate = 7;
      this.shippingEstimate =
        this.shippingEstimate * 1.2 ** this.cartProducts.length;

      localStorage.setItem(
        "shippingEstimate",
        JSON.stringify(this.shippingEstimate)
      );

      this.subtotal = 0;
      this.cartProducts.forEach((product) => {
        this.subtotal += product.price * product.quantity;
      });
      localStorage.setItem("subtotal", JSON.stringify(this.subtotal));
      console.log(this.cartProducts, this.subtotal);
    },
    loadData() {
      axios
        .get("/api/products")
        .then((response) => {
          this.products = response.data;
          console.log(this.products);
          this.filteredProducts = this.products;
        })
        .catch((error) => error);

      axios
        .get("/api/clients/current")
        .then((response) => {
          this.clients = response.data;
          console.log(this.clients);
          this.clientId = this.clients.find((clients) => clients.id == urlName);
          console.log(this.clientId);
        })
        .catch((error) => error);
    },
    selectFilter(category) {
      this.checkedCategory = category;
      if (category == "Suplements") {
        this.subcategories = this.suplements;
        this.filteredProducts = this.products.filter(
          (product) => product.productCategory == "SUPPLEMENTS"
        );
      } else if (category == "Clothes") {
        this.subcategories = this.clothes;
        this.filteredProducts = this.products.filter(
          (product) => product.productCategory == "CLOTHES"
        );
      } else if (category == "Equipment") {
        this.subcategories = [];
        this.filteredProducts = this.products.filter(
          (product) => product.productCategory == "EQUIPMENT"
        );
      }
    },
    rangePriceFilter(inputRange) {
      this.filteredProducts = this.products.filter(
        (product) => product.price <= inputRange
      );
    },
    searchFilter() {
      this.filteredProducts = this.products.filter((product) =>
        product.name.toLowerCase().includes(this.searchFilterInput)
      );
      console.log(this.filteredProducts);
      if (this.searchFilterInput == "") {
        this.filteredProducts = this.products;
      }
    },
  },
}).mount("#app");
