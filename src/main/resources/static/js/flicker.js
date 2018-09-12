//study.html ここから//
$(function() {
    $(".tap").click(function(){
        $(".mean").toggle();
    });
});

$(function() {
    $(".wall").click(function() {
        $(this).remove();
    });
})

$(document).ready(function(){

    $(".buddy").on("swiperight",function(){
        $(this).addClass("rotate-left").delay(700).fadeOut(1);
        $(".buddy").find(".status").remove();

        $(this).append('<div class="status like">知ってる！</div>');
        if ( $(this).is(':first-child') ) {
            // setTimeout(function () {
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            // }, 1000);
        }
    });

    $(".buddy").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない!</div>');

        $('.rotate-left').remove();

        if ( $(this).is(':first-child') ) {
            // $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            setTimeout(function () {
                $('.buddy').find('.status').remove();
                $('.rotate-right').removeClass('rotate-right').fadeIn(0);
            }, 500);
        }
    });


});

// $(function() {
//     $(".show-modal").click(function () {
//         $(this).removeClass("hide");
//         $(this).addClass("show");
//     });
// });


//study.html ここまで//


