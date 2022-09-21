const { createApp } = Vue

createApp({
    data() {
        return {
            firstName : "",
            lastName : "",
            email : "",
            password : "",
            age : 0,
        }
    },
    created() {

    },
    methods: {
        logIn(){
            axios.post("/api/login", "email=" + this.email + "&password=" + this.password, {headers : {'Content-Type' : 'application/x-www-form-urlencoded'}})
            .then(response => {
                window.location.href = "/web/index.html"
            })
        },
        register(){
            axios.post("/api/clients", "firstName=" + this.firstName + "&lastName=" + this.lastName + "&email=" + this.email + "&password=" + this.password, {headers : {'Content-Type' : 'application/x-www-form-urlencoded'}}) 
            .then(response =>{
                alert("puto")
            })
            },
    },
}).mount('#app')