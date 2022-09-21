
let urlParams = new URLSearchParams(window.location.search);
let id = urlParams.get("id");
const { createApp } = Vue

createApp({
    data() {
        return {
            products: [],
            filteredProducts : [],
            productsBg: ["../web/assets/images/produc-bg-01.png", "../web/assets/images/produc-bg-02-01.png"],
            categories: ["Suplements", "Equipment", "Clothes"],
            suplements: ["Proteins", "Creatines", "BCAA"],
            clothes: ["Men", "Women"],
            checkedCategory : "",
            subcategories: [],
            inputRange : 0,
            searchFilterInput : "",
            isOpen : false,
            cartProducts : [],
            moneyFormat : new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }),
            featureds : [],
            noStock : false,
            addCartAllert : false,
            productId:[],
            product: [],
        }
    },
    created() {
        this.loadData()
        const localStorageData = JSON.parse(localStorage.getItem("productsInCart"))
        if(localStorageData == null){
            this.cartProducts = []
        }else{
            this.cartProducts = localStorageData
        }
    },
    methods: {
        deleteItemCart(product){
            if(product.quantity > 1){
                product.quantity --
                product.stock ++
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            }else{
                product.stock ++
                this.cartProducts.splice(this.cartProducts.indexOf(product), 1)
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            }
        },
        cleanCart(){
            this.cartProducts = []
            localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
        },
        noStockAllert(){
            this.addCartAllert = false
            this.noStock = true
            setTimeout(() => {
                this.noStock = false
            }, 5000)
        },
        addCart(product){
            this.addCartAllert = true
            this.noStock = false
            setTimeout(()=>{
                this.addCartAllert = false
            }, 3000)
            if(this.cartProducts.includes(product)){
                product.quantity ++
                product.stock--
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
                if(product.stock < 0 ){
                    this.noStockAllert()
                }
            }else{
                product.quantity = 1
                product.stock --
                this.cartProducts.push(product)
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            }
        },
        loadData() {
            axios.get("/api/products")
            .then(response => {
                this.products = response.data
                console.log(this.products)
                //show products with stock < 5
                this.filteredProducts = this.products.filter(product => product.stock < 5)
                //this.filteredProducts = this.products
                this.productId = this.products.find((products) => products.id == id)
                console.log(this.productId)
                this.productName = this.productId.product.name
                console.log(this.product)
            }).catch(error => error)
        },
        selectFilter(category){
            this.checkedCategory = category
            if(category == "Suplements"){
                this.subcategories = this.suplements
                this.filteredProducts = this.products.filter(product => product.productCategory == "SUPPLEMENTS")
            }else if(category == "Clothes"){
                this.subcategories = this.clothes
                this.filteredProducts = this.products.filter(product => product.productCategory == "CLOTHES")
            }else if(category == "Equipment"){
                this.subcategories = []
                this.filteredProducts = this.products.filter(product => product.productCategory == "EQUIPMENT")
            }
        },
        rangePriceFilter(inputRange){
            this.filteredProducts = this.products.filter(product => product.price <= inputRange)
        },
        searchFilter(){
            this.filteredProducts = this.products.filter(product => product.name.toLowerCase().includes(this.searchFilterInput))
            console.log(this.filteredProducts)
            if(this.searchFilterInput == ""){
                this.filteredProducts = this.products
            }
        }
        
    },
}).mount('#app')

