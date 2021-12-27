let index = {
	init: function(){
		$("#eReturnCompleteBtn").on("click", () => {
			this.returns();
		});
	},
	
	returns: function(){
		console.log("returns");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(3).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log(ocodeObj);
		console.log("ocode : " + ocode);
		console.log(JSON.stringify(ocode));
		
		$.ajax({
			type: "get",
			url: "/admin/api/returns",
			data: ocodeObj,
		}).done(function(resp) {
			alert(resp);
		}).fail(function(error) {
			alert(error);
		});
	}
	
}

index.init();

