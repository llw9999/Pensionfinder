/**
 * 예약 조회
 */
//삭제 버튼 클릭시
function removeCheck(path, rnum, pnum){
	if(!confirm('삭제 하시겠습니까?')) return;
	
	location.href=`${path}/reserve/reserveRemove?rnum=${rnum}&pnum=${pnum}`;
}