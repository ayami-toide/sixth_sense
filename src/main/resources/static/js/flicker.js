//study.html ここから//
$(function() {
    $(".tap1").click(function(){
        $(".meaning1").toggle();
    });
});
$(function() {
    $(".tap2").click(function(){
        $(".meaning2").toggle();
    });
});
$(function() {
    $(".tap3").click(function(){
        $(".meaning3").toggle();
    });
});
$(function() {
    $(".tap4").click(function(){
        $(".meaning4").toggle();
    });
});
$(function() {
    $(".tap5").click(function(){
        $(".meaning5").toggle();
    });
});

$(document).ready(function(){

    $(".buddy").on("swiperight",function(){
        $(this).addClass('rotate-left').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();

        $(this).append('<div class="status like">知っている!</div>');
        // if ( $(this).is(':last-child') ) {
        $('.buddy:nth-child(1)').removeClass ('rotate-left rotate-right').fadeIn(300);
        // } else {
        //     $(this).next().removeClass('rotate-left rotate-right').fadeIn(400);
        // }
    });

    $(".buddy").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない!</div>');

        // // if ( $(this).is(':last-child') ) {
        $('.buddy:nth-child(1)').removeClass ('rotate-left rotate-right').fadeIn(300);
        //     alert('OUPS');
        // // } else {
        //     $(this).next().removeClass('rotate-left rotate-right').fadeIn(400);
        // }
    });

});


//study.html ここまで//
