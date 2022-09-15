const { createApp } = Vue

createApp({
    data() {
        return {
            products: [],
            filteredProducts : [],
            productsBg: ["../images/products-bg-01.png", "../images/products-bg-02-01.png", "../images/products-bg-test-01.png"],
            categories: ["Suplements", "Equipment", "Clothes"],
            suplements: ["Proteins", "Creatines", "BCAA"],
            clothes: ["Men", "Women"],
            selectedCategory: "",
            activeCategory: false,
            subcategories: [],
            inputRange : 0,
            searchFilterInput : "",
        }
    },
    created() {
        this.loadData()
    },
    methods: {
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