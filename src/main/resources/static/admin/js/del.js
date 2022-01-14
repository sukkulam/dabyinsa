let index = {
		init: function(){
			$("#plCancelBtn").on("click", () => {
			this.plCancle();
		});
	
	},

	plCancle: function(){
		console.log("plCancle");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var pid = colume.eq(3).text();
		var ocodeObj = new Object;
		ocodeObj.pid = pid;
		
		console.log("pid : " + pid);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/plCancle",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert(error);
		});
	},
}


index.init();

