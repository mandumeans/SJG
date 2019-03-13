

var main = {
		init : function() {
			var _this = this;
			
			$('.postRow').each(function(){
				upperId = $(this).find(".upperId").val();
				if(upperId !== "") {
					$(this).find(".btnComment").hide();
					$(this).find(".prId").html("ㄴ");
					$(this).find(".prId").css("text-align","center");
				}
			});
			
			$('#btn-save').on('click', function(){
				_this.save();
			});
			
			$('.postRow .prfunc .btnComment').on('click', function(){
				$('#savePostsModal').modal();
				var prId = $(this).parents('.postRow').find('.myId').val();
				$('#upperid').val(prId);
			});
		},
		save : function() {
			var data = {
					title: $('#title').val(),
					author: $('#author').val(),
					content: $('#content').val(),
					upperId: $('#upperid').val()
			};
			
			$.ajax({
				type: 'POST',
				url: '/posts',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function(){
				alert('글이 등록되었습니다.');
				location.reload();
			}).fail(function(error){
				alert(error);
			});
		}
}

main.init();