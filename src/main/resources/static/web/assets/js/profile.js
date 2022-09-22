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
            clients: [],
            clientId: [],
            subscriptionTrue: [],
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

        loadData() {
            axios.get("/api/clients")
            .then(response => {
                this.clients = response.data
                console.log(this.clients)
                this.clientId = this.clients.find(client => client.id == id)
                console.log(this.clientId)
                this.subscriptionTrue = this.clients.filter(client => client.clientSubscription == false)
                console.log(this.subscriptionTrue)
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
  
  
  $(function() {
      
      "use strict";
      
      //===== Prealoder
      
      $(window).on('load', function(event) {
          $('.preloader').delay(500).fadeOut(500);
      });
      
      
      //===== Sticky
  
      $(window).on('scroll', function (event) {
          var scroll = $(window).scrollTop();
          if (scroll < 20) {
              $(".navbar-area").removeClass("sticky");
          } else {
              $(".navbar-area").addClass("sticky");
          }
      });
      
      
      //===== Section Menu Active
  
      var scrollLink = $('.page-scroll');
      // Active link switching
      $(window).scroll(function () {
          var scrollbarLocation = $(this).scrollTop();
  
          scrollLink.each(function () {
  
              var sectionOffset = $(this.hash).offset().top - 73;
  
              if (sectionOffset <= scrollbarLocation) {
                  $(this).parent().addClass('active');
                  $(this).parent().siblings().removeClass('active');
              }
          });
      });
      
      //===== close navbar-collapse when a  clicked
  
      $(".navbar-nav a").on('click', function () {
          $(".navbar-collapse").removeClass("show");
      });
  
      $(".navbar-toggler").on('click', function () {
          $(this).toggleClass("active");
      });
  
      $(".navbar-nav a").on('click', function () {
          $(".navbar-toggler").removeClass('active');
      });
      
      
      //===== Counter Up
      
      $('.counter').counterUp({
          delay: 10,
          time: 3000
      });
      
      
      //===== Slick Project
      
      $('.team_active').slick({
          dots: false,
          infinite: true,
          speed: 800,
          slidesToShow: 5,
          slidesToScroll: 1,
          arrows: true,
          centerMode: true,
          centerPadding: '0',
          prevArrow: '<span class="prev"><i class="lni lni-chevron-left"></i></span>',
          nextArrow: '<span class="next"><i class="lni lni-chevron-right"></i></span>',
          responsive: [
              {
                breakpoint: 1400,
                settings: {
                  slidesToShow: 3,
                }
              },
              {
                breakpoint: 1200,
                settings: {
                  slidesToShow: 3,
                }
              },
              {
                breakpoint: 992,
                settings: {
                  slidesToShow: 3,
                }
              },
              {
                breakpoint: 768,
                settings: {
                  slidesToShow: 3,
                }
              },
              {
                breakpoint: 576,
                settings: {
                  slidesToShow: 1,
                }
              }
          ]
      });
      
      
      //===== Slick Testimonial
      
      $('.testimonial_active').slick({
          dots: true,
          infinite: true,
          speed: 800,
          slidesToShow: 1,
          slidesToScroll: 1,
          arrows: false,
          centerMode: true,
          centerPadding: '0',
      });
      
      
      //====== Magnific Popup
      
      $('.video-popup').magnificPopup({
          type: 'iframe'
          // other options
      });
      
      
      //===== Magnific Popup
      
      $('.image-popup').magnificPopup({
        type: 'image',
        gallery:{
          enabled:true
        }
      });
      
      
      //===== Back to top
      
      // Show or hide the sticky footer button
      $(window).on('scroll', function(event) {
          if($(this).scrollTop() > 600){
              $('.back-to-top').fadeIn(200)
          } else{
              $('.back-to-top').fadeOut(200)
          }
      });
      
      
      //Animate the scroll to yop
      $('.back-to-top').on('click', function(event) {
          event.preventDefault();
          
          $('html, body').animate({
              scrollTop: 0,
          }, 1500);
      });
      
      
      //===== 
      
  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
  });