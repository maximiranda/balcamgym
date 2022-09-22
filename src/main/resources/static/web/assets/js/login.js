let urlParams = new URLSearchParams(window.location.search);
let confirm = urlParams.get("confirm");

const { createApp } = Vue

createApp({
    data() {
        return {
            firstName : "",
            lastName : "",
            email : "",
            password : "",
            age : 0,
            isOpen: false,
            isLoading : false,
            showAlert : false,
            birthDate : "",
            isOpen : false,
            error : false,
        }
    },
    created() {
        if(confirm == "true"){
            this.showAlert = true
        }else{
            this.showAlert = false
        }

        console.log(confirm)
    },
    methods: {
        logIn(){
            axios.post("/api/login", "email=" + this.email + "&password=" + this.password, {headers : {'Content-Type' : 'application/x-www-form-urlencoded'}})
            .then(response => {
                window.location.href = "/web/index.html"
            })
        },
        register(){
            this.isLoading = true
            axios.post("/api/clients", "firstName=" + this.firstName + "&lastName=" + this.lastName + "&email=" + this.email + "&password=" + this.password, {headers : {'Content-Type' : 'application/x-www-form-urlencoded'}}) 
            .then(response =>{
                this.isOpen=true
            }).catch(error => {
                this.error = error.response.data
            })
            },
    },
}).mount('#app')