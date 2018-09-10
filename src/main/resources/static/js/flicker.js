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

        $(this).append('<div class="status like">知ってる！</div>');

        if ( $(this).is(':first-child') ) {
            setTimeout(function () {
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 1000);
        }

        // var data = {word: document.getElementById("flick_word").textContent};
        //
        // $.ajax ({
        //     url: "/sense/study1",
        //     type: "POST",
        //     data : JSON.stringify(data),
        //     contentType: 'application/JSON',
        //     dataType : 'JSON',
        //     success: function() {
        //         console.log("success");
        //     }
        // });

    });

    $(".buddy").on("swipeleft",function(){
        $(this).addClass('rotate-right').delay(700).fadeOut(1);
        $('.buddy').find('.status').remove();
        $(this).append('<div class="status dislike">知らない！</div>');

        $('.rotate-left').remove();

        if ( $(this).is(':first-child') ) {
            setTimeout(function () {
                $('.buddy').find('.status').remove();
                $('.rotate-right').removeClass('rotate-right').fadeIn(300);
            }, 900);
        }
    });

});


//study.html ここまで//