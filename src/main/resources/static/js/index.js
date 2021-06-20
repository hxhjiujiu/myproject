$(function(){
	//获取
	$("#firstA").click(function(){
		var i=0;
		var i=i+1;
		var span1=$(this).children("span")[1];
		console.log(i);
		if(i%2==0){
			$(span1).removeClass("glyphicon glyphicon-menu-down");
			$(span1).toggleClass("glyphicon glyphicon-menu-left");
		}else{
			
			$(span1).removeClass("glyphicon glyphicon-menu-left");
			$(span1).toggleClass("glyphicon glyphicon-menu-down");
		}
		 
		
			
		
		
		
	});
	
});