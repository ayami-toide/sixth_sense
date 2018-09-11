//study.html ここから//
$(function() {
    $(".tap").click(function(){
        $(".mean").toggle();
    });
});

$(document).ready(function(){

    $(".flick1").on("swiperight",function(){
        $(this).addClass("rotate-left").delay(700).fadeOut(1);
        $(".buddy").find(".status").remove();

        $(this).append('<div class="status like">Like!</div>');
        if ( $(this).is(':first-child') ) {
            setTimeout(function () {
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 1000);
        }
    });

    $(".flick1").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない!</div>');

        $('.rotate-left').remove();

        if ( $(this).is(':first-child') ) {
            $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            setTimeout(function () {
                $('.buddy').find('.status').remove();
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 900);
        }
    });

    $(".flick2").on("swiperight",function(){
        $(this).addClass("rotate-left").delay(700).fadeOut(1);
        $(".buddy").find(".status").remove();

        $(this).append('<div class="status like">Like!</div>');
        if ( $(this).is(':first-child') ) {
            setTimeout(function () {
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 1000);
        }
    });

    $(".flick2").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない!</div>');

        $('.rotate-left').remove();

        if ( $(this).is(':first-child') ) {
            $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            setTimeout(function () {
                $('.buddy').find('.status').remove();
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 900);
        }
    });

    $(".flick3").on("swiperight",function(){
        $(this).addClass("rotate-left").delay(700).fadeOut(1);
        $(".buddy").find(".status").remove();

        $(this).append('<div class="status like">Like!</div>');
        if ( $(this).is(':first-child') ) {
            setTimeout(function () {
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 1000);
        }
    });

    $(".flick3").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない!</div>');

        $('.rotate-left').remove();

        if ( $(this).is(':first-child') ) {
            $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            setTimeout(function () {
                $('.buddy').find('.status').remove();
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 900);
        }
    });

    $(".flick4").on("swiperight",function(){
        $(this).addClass("rotate-left").delay(700).fadeOut(1);
        $(".buddy").find(".status").remove();

        $(this).append('<div class="status like">Like!</div>');
        if ( $(this).is(':first-child') ) {
            setTimeout(function () {
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 1000);
        }
    });

    $(".flick4").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない!</div>');

        $('.rotate-left').remove();

        if ( $(this).is(':first-child') ) {
            $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            setTimeout(function () {
                $('.buddy').find('.status').remove();
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 900);
        }
    });

});


//study.html ここまで//


