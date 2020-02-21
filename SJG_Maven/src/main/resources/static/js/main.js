

var main = {
		init : function() {
			var _this = this;
			
			$('.postRow').each(function(){
				var upperId = $(this).find(".upperId").val();
				var depth = $(this).find(".depth").val();
				var depthInt = parseInt(depth);
				postRepresenter = $(this).find(".prId .postRepresenter");
				if(upperId !== "") {
					var myId = $(this).find(".myId").val();
					if(depthInt >= 99){
						$(this).find(".btnComment").hide();
					}
					postRepresenter.html("ㄴ" + myId);
					postRepresenter.css("margin-left",((depthInt - 1) * 10) + "%");
				}
			});
			
			$('#btn-save').on('click', function(){
				_this.save();
			});
			
			$('#btn-saveFile').on('click', function(){
				_this.fileSaveTest();
			});
			
			$('.postRow .prfunc .btnComment').on('click', function(){
				$('#savePostsModal').modal();
				var prId = $(this).parents('.postRow').find('.myId').val();
				$('#upperid').val(prId);
			});
			
			$('.postRow .prfunc .btnScrap').on('click', function(){
				var prId = $(this).parents('.postRow').find('.myId').val();
				var prAuthor = $('#authorID').val();
				_this.scrap(prId, prAuthor);
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
		},
		fileSaveTest : function() {
			var data = {
				sourceFile : $('#fileUpload').val()
			};
			var frm = document.getElementById('postsForm');

			var data = new FormData(frm);
			$.ajax({
				type: 'POST',
				enctype: 'multipart/form-data',
				url: '/upload',
				data: data,
				processData: false,
				cache: false,
				contentType: false,
	            timeout: 600000,
			}).done(function(){
				alert('파일이 등록되었습니다.');
				location.reload();
			}).fail(function(error){
				alert(error);
			});			
		},
		scrap : function(postId, author) {
			var data = {
				postId: postId,
				scrapAuthor: author
			};
			
			$.ajax({
				type: 'POST',
				url: '/scraps',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function(){
				alert('스크랩 되었습니다.');
				location.reload();
			}).fail(function(error){
				alert(error);
			});			
		}
}

main.init();