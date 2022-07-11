/**
 * 
 */
 function removeCheck(path, memail){
	
	location.href=`${path}/joinmember/remove?memail=${memail}`;
}

function premoveCheck(path, pemail){
	
	location.href=`${path}/joinpension/remove?pemail=${pemail}`;
}