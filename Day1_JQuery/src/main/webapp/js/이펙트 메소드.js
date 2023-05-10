/**
 * 
 */
 $(()=>{
	$('.menu>div').hide();
	
	$('div').hide().click(()=>$('div').hide().hide());
		function(){
			$(this).children('div').stop().slideDown();
		}
		,
		function(){
			$(this).children('div').stop().slideUp();
		}
		
	);
});