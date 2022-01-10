let index = {
	init: function(){
		$("#eReturnCompleteBtn").on("click", () => {
			this.returns();
		});
		
		$("#eRefundComplete").on("click", () => {
			this.refund();
		});
		
		$("#ePaymentOkBtn").on("click", () => {
			this.pOk();
		});
		
		$("#ePaymentCancelBtn").on("click", () => {
			this.pCancle();
		});
		
		$("#eShipStartBtn").on("click", () => {
			this.sStart();
		});
		
		$("#eMoveShipBegin").on("click", () => {
			this.sBegin();
		});
		
		$("#eShippedStandByBtn").on("click", () => {
			this.sStandBy();
		});
		
		$("#eShippedEndBtn").on("click", () => {
			this.sEnd();
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
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/returns",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert("실패");
		});
	},
	
	refund: function(){
		console.log("refund");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(4).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/refund",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert("실패");
		});
	},
	
	pOk: function(){
		console.log("pOk");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(3).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/pOk",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert("실패");
		});
	},
	
	pCancle: function(){
		console.log("pCancle");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(3).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/pCancle",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert(error);
		});
	},
	
	sStart: function(){
		console.log("sStart");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(2).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/sStart",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert(error);
		});
	},
	
	sBegin: function(){
		console.log("sBegin");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(2).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/sBegin",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert(error);
		});
	},
	
	sStandBy: function(){
		console.log("sStandBy");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(2).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/sStandBy",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert(error);
		});
	},
	
	sEnd: function(){
		console.log("sEnd");
		var checkbox = $("input[id=allChk]:checked");
		var row = checkbox.parent().parent();
		var colume = row.children();
		
		var ocode = colume.eq(2).text();
		var ocodeObj = new Object;
		ocodeObj.ocode = ocode;
		
		console.log("ocode : " + ocode);
		console.log(ocodeObj);
		
		$.ajax({
			type: "get",
			url: "/admin/api/sEnd",
			data: ocodeObj
		}).done(function(resp) {
			alert("성공");
			location.reload();
		}).fail(function(error) {
			alert(error);
		});
	}
	
}

index.init();

