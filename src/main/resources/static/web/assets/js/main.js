let urlParams = new URLSearchParams(window.location.search);
                let id = urlParams.get("id");
const app = Vue.createApp({
  data() {
    return {
      workouts: [],
      coachName: [],
      name: '',
      fromDate: [],
      fromTime: '',
      clients: "",
      clientId: [],
      isOpen: false,
      moneyFormat: new Intl.NumberFormat("en-US", {style: "currency", currency: "USD",}),
      subtotal: 0,
      taxEstimate: 0.21,
      cardNumber: "",
      cardHolder: "",
      cardExp: "",
      cardCvv: "",
      showAlertDanger : false,
      showSuccessAlert : false,
    };
  },

  created() {
    axios
      .get("/api/workouts")
      .then((response) => {
        this.workouts = response.data;
        console.log(this.workouts);
        this.fromDates = this.workouts.map((workout) => workout.fromDate.substring(0, 3));
        console.log(this.fromDates);
      })
      .catch(function (error) {

      });
      axios.get("/api/clients/current")
            .then(response => {
                
                this.clients = response.data
                console.log(this.clients)
                this.clientId = this.clients.find(clients => clients.id == id)
                console.log(this.clientId)
            }).catch(error => error)
  },

  methods: {
    limitText(text) {
      return text.substring(0, 3);
    },

    alertContact(){
       Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Your message has been sent. We will answer you ASAP!',
      showConfirmButton: false,
      timer: 1500
    });
    setTimeout(()=> window.location.href= "/web/contact.html", 2000)
     } ,
    logOut() {
      axios
        .post("/api/logout")
        .then((response) => console.log("signed out!!!"));
    },
    subscriptionPayment(){
      axios.post("/api/subscriptions", "id=49" + "&paymentAuthorization=true", {headers: {"Content-Type":"application/x-www-form-urlencoded"}})
      .then(response => {})
      .catch(error =>{})
    },
    openModal(number){

      this.subtotal= number
      this.isOpen=true
    },
    selectWorkout(id){
      console.log(id)
      axios.post("/api/workouts","id=" +id,  {headers: {"Content-Type":"application/x-www-form-urlencoded"}})
      .then(r=>{
        this.showSuccessAlert = true;
        setTimeout(()=>{
          this.showSuccessAlert = false;
        }, 3000)
      })
      .catch(e=>{
        this.showAlertDanger = true
        setTimeout(()=>{
          this.showAlertDanger = false
        }, 3000)
      })
    }
  }

}).mount("#app");


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