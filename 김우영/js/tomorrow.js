

$(() => {

    $('.wy_navIN li').hover(function (){

        $(this).addClass('wy_mimosaShadow');
        // $(this).css('background-color','hotpink');
    },function(){
        $(this).removeClass('wy_mimosaShadow');
    })

    $('#wy_icon1 input').focus(function(){

        $('#wy_search').css('border','1px solid #ffca4b');
        
    })
    $('#wy_icon1 input').blur(function(){
        $('#wy_search').css('border','1px solid rgb(243, 228, 193)')
    })


    $('.wy_card').hover(function(){
        $(this).find('img').css('transform','scale(1.05)');
    },function(){
        $(this).find('img').css('transform','scale(1.00)');


    }
    );


})