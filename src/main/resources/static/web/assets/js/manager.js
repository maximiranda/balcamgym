const { createApp } = Vue

createApp({
    data() {
        return {
            products: [],
            categories: ["Supplements", "Equipment", "Clothes"],
            searchFilterInput: "",
            moneyFormat: new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }),
            name: "",
            category: "",
            price: 0.00,
            stock: 0,
            description: "",
            file: ""
        }
    },
    created() {
        this.loadData()
    },
    methods: {
        onChangeFile(event) {
            this.file = event.target.files || event.dataTransfer.files
        },
        addNewProduct() {
            axios.post("/api/products", { "file" : this.file[0], "name" : this.name, "stock" : this.stock, "description" : this.description, "price" : this.price, "category" : this.category } , { headers: {'Content-Type': 'multipart/form-data'} })
                .then(response => {
                    console.log(response)
                    alert("listo capo producto agregado", response)
                })
        },
        loadData() {
            axios.get("/api/products")
                .then(response => {
                    this.products = response.data
                    console.log(this.products)
                    this.filteredProducts = this.products
                }).catch(error => error)
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
        searchFilter() {
            this.filteredProducts = this.products.filter(product => product.name.toLowerCase().includes(this.searchFilterInput))
            console.log(this.filteredProducts)
            if (this.searchFilterInput == "") {
                this.filteredProducts = this.products
            }
        }
    },
}).mount('#app')