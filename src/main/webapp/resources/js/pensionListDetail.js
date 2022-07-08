/**
 * 게시물 상세 조회
 */
 //삭제버튼 클릭시
function removeCheck(path, pnum){
	if(!confirm('삭제 하시겠습니까?')) return ;

	location.href=path+'/board/remove?pnum='+pnum;
}

//로딩이 완료된 후
window.addEventListener('load',()=>{
	const path = $('#contextpath').val();
	
	//좋아요
	document.getElementById('likescnt').addEventListener('click',()=>{
		const pnum = $('#pnum').val();
		console.log(pnum);
		
		$.ajax({
			url : `${path}/board/likes/${pnum}`,
			type : 'put',
			dataType : 'text',
			success : function(text){
				console.log('리턴값:', text);
				$('#likes').html(text);
			},
			error : function(err){
				console.log(err);
			}
		});
	});
	
	//싫어요
	document.getElementById('dislikescnt').addEventListener('click', ()=>{
		const pnum = $('#pnum').val();
		
		fetch(`${path}/board/dislikes/${pnum}`, {
			method : 'put'
		})
		.then(res=> res.text())
		.then(text=>{
			console.log(text);
			document.getElementById('dislikes').innerText=text;
		})
		.catch(err=>console.log(err));
	});
	
});
