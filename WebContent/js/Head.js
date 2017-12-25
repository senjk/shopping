$(document).ready(function(){
	setInterval("time()",1000);
	$("#first").mouseover(function(){
		$(this).children().show()
		/*$(this).css({"border":"1px solid lightgrey","border-bottom":"none","background-color":"white"});*/
		$("#first ul").css({"border":"1px solid lightgrey","border-top":"none","background-color":"white"});
	});
	$("#first").mouseout(function(){
		$(this).children(":last-child").hide();
		$(this).css({"border":"none"});
	});
	
});

function time(){
var today= new Date();
var year=today.getFullYear();
var mon=today.getMonth()+1;
var day=today.getDate();
var h=today.getHours();
var m=today.getMinutes();
document.getElementById("time").innerHTML=year+"年"+mon+"月"+day+"日"+h+"点"+m+"分";

}
