

var main = {
		init : function() {
			var _this = this;
			
			$('.postRow').each(function(){
				var upperId = $(this).find(".upperId").val();
				var depth = $(this).find(".depth").val();
				var depthInt = parseInt(depth);
				postRepresenter = $(this).find(".prId .postRepresenter");
				if(upperId !== "") {
					if(depthInt >= 99){
						$(this).find(".btnComment").hide();
					}
					postRepresenter.html("ㄴ");
					postRepresenter.css("margin-left",((depthInt - 1) * 10) + "%");
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