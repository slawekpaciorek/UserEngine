$(document).ready(function(){

    $('.buttonHolder').find("button").hide();

    $(".buttonHolder").on("mouseenter", function(){

        $(this).find("button").fadeIn();

    });

    $(".buttonHolder").on("mouseleave", function(){

        $(this).find("button").fadeOut();

    });

    if(window.location.pathname == "/add-user"){
        $("#user").find("button:last-of-type").hide();
    }
    else{
        $("#user").find("button:first-of-type").hide();
    }

});