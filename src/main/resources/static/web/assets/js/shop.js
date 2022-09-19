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
            
        }
    },
    created() {
        this.loadData()
    },
    methods: {
        deleteItemCart(product){
            if(product.quantity > 1){
                product.quantity --
            }else{
                this.cartProducts.splice(this.cartProducts.indexOf(product), 1)
            }
            console.log(this.cartProducts)
        },
        addCart(product){
            if(this.cartProducts.includes(product)){
                product.quantity ++
            }else{
                product.quantity = 1
                this.cartProducts.push(product)
            }
            console.log(this.cartProducts)
        },
        showCategories(category){
            this.checkedCategory = category
            if(category == "Suplements"){
                this.subcategories = this.suplements
            }else if(category == "Clothes"){
                this.subcategories = this.clothes
            }else if(category == "Equipment"){
                this.subcategories = []
            }
        },
        loadData() {
            fetch('https://jsonplaceholder.typicode.com/photos')
                .then(response => response.json())
                .then(json => {
                    this.products = json.filter(res => res.id < 50)
                    this.filteredProducts = this.products
                    console.log(this.products);
                })
        },
        selectFilter(){
            if(this.selectedCategory == "Suplements"){
                console.log("aca va el filtro de suplementos")
                this.filteredProducts = this.products.filter(product => product.category == "suplement")
            }else if(this.selectedCategory == "Equipment"){
                console.log("aca va el filtro de Equipment")

                this.filteredProducts = this.products.filter(product => product.category == "equipment")
            }else if(this.selectedCategory == "Clothes"){
                console.log("aca va el filtro de clothes")

                this.filteredProducts = this.products.filter(product => product.category == "cloth")
            }else if(this.selectedCategory == "all"){
                this.filteredProducts = this.products
            }
        },
        rangePriceFilter(inputRange){
            this.filteredProducts = this.products.filter(product => product.id <= inputRange && product.id >=inputRange)
        },
        searchFilter(){
            this.filteredProducts = this.products.filter(product => product.title.includes(this.searchFilterInput))
            console.log(this.filteredProducts)
            if(this.searchFilterInput == ""){
                this.filteredProducts = this.products
            }
        }
    },
}).mount('#app')