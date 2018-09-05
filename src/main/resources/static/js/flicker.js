//study.html ここから//
$(function() {
    $(".tap").click(function(){
        $(".mean").toggle();
    });
});

$(document).ready(function(){

    $(".buddy").on("swiperight",function(){
        $(this).addClass("rotate-left").delay(700).fadeOut(1);
        $(".buddy").find(".status").remove();

        $(this).append('<div class="status like">Like!</div>');
        if ( $(this).is(':first-child') ) {
            $('.rotate-right').removeClass ('rotate-right').fadeIn(300);
        }

    });

    $(".buddy").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない!</div>');

        $('.rotate-left').remove();

        if ( $(this).is(':first-child') ) {
        $('.rotate-right').removeClass('rotate-right').fadeIn(300);
         }
    });

});


//study.html ここまで//
