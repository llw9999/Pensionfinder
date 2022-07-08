/**
 * 게시물 상세 조회
 */
 //삭제버튼 클릭시
function removeCheck(path, rnum, pnum){
	if(!confirm('삭제 하시겠습니까?')) return ;

	location.href=`${path}/reply/replyRemove?rnum=${rnum}&pnum=${pnum}`;
}

//로딩이 완료된 후
window.addEventListener('load', ()=>{
	const path = $('#contextpath').val();
	
	//도움
	document.getElementById('helpcnt').addEventListener('click',()=>{
		const rnum = $('#rnum').text();
		console.log(rnum);
		
		$.ajax({
			url : `${path}/reply/help/${rnum}`,
			type : 'put',
			dataType : 'text',
			success : function(text){
				console.log('리턴값:', text);
				$('#help').html(text);
			},
			error : function(err){
				console.log(err);
			}
		});
	});
	
	//도움되지 않음
	document.getElementById('uselesscnt').addEventListener('click',()=>{
		const rnum = document.getElementById('rnum').innerText;
		
		fetch(`${path}/reply/useless/${rnum}`, {
			method : 'put'
		})
		.then(res=> res.text())
		.then(text=>{
			console.log(text);
			document.getElementById('useless').innerText=text;
		})
		.catch(err=>console.log(err));
	});
	
});