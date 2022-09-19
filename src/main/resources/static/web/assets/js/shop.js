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
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            }else{
                this.cartProducts.splice(this.cartProducts.indexOf(product), 1)
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            }
        },
        addCart(product){
            if(this.cartProducts.includes(product)){
                product.quantity ++
                product.stock--
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
                if(product.stock < 1 ){
                    alert("no se puede mas capo")
                }
            }else{
                product.quantity = 1
                this.cartProducts.push(product)
                localStorage.setItem("productsInCart", JSON.stringify(this.cartProducts))
            }
            console.log(this.cartProducts)
        },
        loadData() {
            axios.get("/api/products")
            .then(response => {
                this.products = response.data
                console.log(this.products)
                this.filteredProducts = this.products
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