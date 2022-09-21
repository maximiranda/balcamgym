new Vue({
    el: "#app",
    data() {
        return {
            currentCardBackground: Math.floor(Math.random() * 25 + 1), // just for fun :D
            cardName: "",
            cardNumber: "",
            cardMonth: "",
            cardYear: "",
            cardCvv: "",
            minCardYear: new Date().getFullYear(),
            amexCardMask: "#### ###### #####",
            otherCardMask: "#### #### #### ####",
            cardNumberTemp: "",
            isCardFlipped: false,
            focusElementStyle: null,
            isInputFocused: false,
            modal: false,
            //------------------------------------------------
            client : {},
            products: [],
            filteredProducts: [],
            productsBg: ["../web/assets/images/produc-bg-01.png", "../web/assets/images/produc-bg-02-01.png"],
            categories: ["Suplements", "Equipment", "Clothes"],
            suplements: ["Proteins", "Creatines", "BCAA"],
            clothes: ["Men", "Women"],
            checkedCategory: "",
            subcategories: [],
            inputRange: 0,
            searchFilterInput: "",
            isOpen: false,
            cartProducts: [],
            moneyFormat: new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }),
            featureds: [],
            noStock: false,
            addCartAllert: false,
            purchaseAlertSucces : false,
            purchaseAlertError : false,
            subtotal: 0,
            shippingEstimate: 7,
            taxEstimate: 0.21,
        };
    },
    created() {
        this.loadData()

        const localStorageData = JSON.parse(localStorage.getItem("productsInCart"))
        const priceProduct = JSON.parse(localStorage.getItem("subtotal"))
        const shippingEstimate = JSON.parse(localStorage.getItem("shippingEstimate"))

        if (priceProduct == null) {
            this.subtotal = 0
        } else {
            this.subtotal = priceProduct
        }

        if (localStorageData == null) {
            this.cartProducts = []
        } else {
            this.cartProducts = localStorageData
        }

        if (shippingEstimate == null) {
            this.shippingEstimate = 7
        } else {
            this.shippingEstimate = shippingEstimate
        }
    },
    mounted() {
        this.cardNumberTemp = this.otherCardMask;
        document.getElementById("cardNumber").focus();
    },
    computed: {
        getCardType() {
            let number = this.cardNumber;
            let re = new RegExp("^4");
            if (number.match(re) != null) return "visa";

            re = new RegExp("^(34|37)");
            if (number.match(re) != null) return "amex";

            re = new RegExp("^5[1-5]");
            if (number.match(re) != null) return "mastercard";

            re = new RegExp("^6011");
            if (number.match(re) != null) return "discover";

            re = new RegExp('^9792')
            if (number.match(re) != null) return 'troy'

            return "visa"; // default type
        },
        generateCardNumberMask() {
            return this.getCardType === "amex" ? this.amexCardMask : this.otherCardMask;
        },
        minCardMonth() {
            if (this.cardYear === this.minCardYear) return new Date().getMonth() + 1;
            return 1;
        }
    },
    watch: {
        cardYear() {
            if (this.cardMonth < this.minCardMonth) {
                this.cardMonth = "";
            }
        }
    },
    methods: {
        loadData() {
            axios.get("/api/products")
                .then(response => {
                    this.products = response.data
                    console.log(this.products)
                    this.filteredProducts = this.products
                }).catch(error => error)
            axios.get("/api/clients/current")
            .then(res =>{
                this.client = res.data
                console.log(this.client)
            })
        },
        outClick(e) {
            const modal = document.querySelector("#modal")
            console.log(modal)
            const isCLick = modal.contains(e.target)
            console.log(isCLick)
            
            if (!isCLick){
                this.modal = false
            }
        },
        makePayment() {
            if(!(this.cardName == "" || this.cardCvv == "" || this.cardYear == "" || this.cardMonth == "" || this.cardNumber == "")){
                axios.post('https://maxbank-homebanking.herokuapp.com/api/pays', {
                    "cardNumber": this.cardNumber,
                    "cardCvv": this.cardCvv,
                    "amount": this.subtotal * (1 + this.taxEstimate) + this.shippingEstimate,
                    "cardExp": this.cardYear + "-" + this.cardMonth + "-01",
                    "cardHolder": this.cardName,
                    "description": "Balcam's Gym payout"
                }).then(r => {
                    const ids = this.cartProducts.map(product => product.id).toString()
                    axios.post("/api/purchase", "paymentAuthorization=true" + "&ids=" + ids, {headers: {"Content-Type":"application/x-www-form-urlencoded"}})
                    .then(r => {
                        this.purchaseAlertSucces = true
                        setTimeout( () => {
                            this.purchaseAlertSucces = false})
                        }, 5000)
                    })
                .catch(r => {
                    console.log(r)
                    this.purchaseAlertError = true
                    setTimeout( () => {
                        this.purchaseAlertError = false})
                    }, 3000)
            }else{
                this.purchaseAlertError = "There is an empty field, try again!"
            }
        },
        deleteItem(product) {
            product.stockAux = product.stock
            this.cartProducts.splice(this.cartProducts.indexOf(product), 1)

            this.subtotal = 0
            this.cartProducts.forEach(product => {
                this.subtotal += product.price * product.quantity
            })

            this.shippingEstimate = 7
            this.shippingEstimate = this.shippingEstimate * (1.2 ** this.cartProducts.length)

            localStorage.setItem("shippingEstimate", JSON.stringify(this.shippingEstimate))
            localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            localStorage.setItem("subtotal", JSON.stringify(this.subtotal))
        }
        ,
        reduceQuantity(product) {
            if (product.quantity > 1) {
                product.quantity--
                product.stockAux++
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            } else {
                product.stockAux++
                this.deleteItem(product)
            }

            this.subtotal = 0
            this.cartProducts.forEach(product => {
                this.subtotal += product.price * product.quantity
            })

            localStorage.setItem("subtotal", JSON.stringify(this.subtotal))
        },
        cleanCart() {
            this.subtotal = 0
            this.cartProducts = []
            this.shippingEstimate = 7

            localStorage.setItem("shippingEstimate", JSON.stringify(this.shippingEstimate))
            localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            localStorage.setItem("subtotal", JSON.stringify(this.subtotal))
        },
        noStockAllert() {
            this.addCartAllert = false
            this.noStock = true
            setTimeout(() => {
                this.noStock = false
            }, 5000)
        },
        addCart(product) {
            this.addCartAllert = true
            this.noStock = false
            setTimeout(() => {
                this.addCartAllert = false
            }, 3000)

            if (this.cartProducts.includes(product)) {
                product.quantity++
                product.stockAux--
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
                if (product.stockAux < 0) {
                    this.noStockAllert()
                }
            } else {
                product.stockAux = product.stock
                product.quantity = 1
                product.stockAux--
                this.cartProducts.push(product)
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            }

            this.shippingEstimate = 7
            this.shippingEstimate = this.shippingEstimate * (1.2 ** this.cartProducts.length)

            localStorage.setItem("shippingEstimate", JSON.stringify(this.shippingEstimate))


            this.subtotal = 0
            this.cartProducts.forEach(product => {
                this.subtotal += product.price * product.quantity
            })
            localStorage.setItem("subtotal", JSON.stringify(this.subtotal))
            console.log(this.cartProducts, this.subtotal)
        },
        selectFilter(category) {
            this.checkedCategory = category
            if (category == "Suplements") {
                this.subcategories = this.suplements
                this.filteredProducts = this.products.filter(product => product.productCategory == "SUPPLEMENTS")
            } else if (category == "Clothes") {
                this.subcategories = this.clothes
                this.filteredProducts = this.products.filter(product => product.productCategory == "CLOTHES")
            } else if (category == "Equipment") {
                this.subcategories = []
                this.filteredProducts = this.products.filter(product => product.productCategory == "EQUIPMENT")
            }
        },
        rangePriceFilter(inputRange) {
            this.filteredProducts = this.products.filter(product => product.price <= inputRange)
        },
        searchFilter() {
            this.filteredProducts = this.products.filter(product => product.name.toLowerCase().includes(this.searchFilterInput))
            console.log(this.filteredProducts)
            if (this.searchFilterInput == "") {
                this.filteredProducts = this.products
            }
        },
        flipCard(status) {
            this.isCardFlipped = status;
        },
        focusInput(e) {
            this.isInputFocused = true;
            let targetRef = e.target.dataset.ref;
            let target = this.$refs[targetRef];
            this.focusElementStyle = {
                width: `${target.offsetWidth}px`,
                height: `${target.offsetHeight}px`,
                transform: `translateX(${target.offsetLeft}px) translateY(${target.offsetTop}px)`
            }
        },
        blurInput() {
            let vm = this;
            setTimeout(() => {
                if (!vm.isInputFocused) {
                    vm.focusElementStyle = null;
                }
            }, 300);
            vm.isInputFocused = false;
        }
    }
});