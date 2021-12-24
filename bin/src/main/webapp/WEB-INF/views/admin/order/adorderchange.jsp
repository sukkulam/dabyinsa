<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>교환</title>
<link rel="stylesheet" type="text/css"
	href="//img.echosting.cafe24.com/css/ec/mode/easiest/common.css"
	media="all" charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="//img.echosting.cafe24.com/calendars/duetds/css/default.css" />
<link rel="stylesheet" type="text/css"
	href="//img.echosting.cafe24.com/calendars/duetds/css/themes/ec-date-picker.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#eBtnInit").click(function() {
			$("#script_reset").each(function() {
				this.reset();
			});
		});

	});
</script>
</head>
<body>

	<form name="frm" action="order_change.php" method='post' id="script_reset">
		<!-- content -->
		<div id="content">
			<!-- 참고 : Frame 구분 시 컨텐츠 시작 -->
			<div class="headingArea">
				<div class="mTitle">
					<h1>교환</h1>
					<span class="cManual eSmartMode" code="OD.OW.EM"></span>
				</div>
			</div>

			<div class="optionArea " id="QA_deposit1">

				<div class="mOption">
					<table border="1" summary="">
						<caption>주문 검색</caption>
						<colgroup>
							<col style="width: 170px;" />
							<col style="width: auto;" />
							<col style="width: 170px;" />
							<col style="width: auto;" />
						</colgroup>
						<tbody>

							<tr>
								<th scope="row">검색어
									<div class="cTip" code="OR.SM.CE.CM.40"></div>
								</th>
								<td colspan="3">
									<div id="mainSearch">
										<div>
											<select class="fSelect" name=MSK[] style="width: 163px;">
												<option value="choice">-검색항목선택-</option>
												<option value="order_id" selected>주문번호</option>
												<option value="ord_item_code">품목별 주문번호</option>
												<option value="invoice_no">운송장번호</option>
												<option value="line1">-----------------</option>
												<option value="o_name">주문자명</option>
												<option value="member_id">주문자 아이디</option>
												<option value="member_email">회원 이메일</option>
												<option value="o_email">주문서 이메일</option>
												<option value="o_phone2">주문자 휴대전화</option>
												<option value="o_phone1">주문자 일반전화</option>
											</select> <input type="text" class="fText sBaseSearchBox" name=MSV[]
												id="sBaseSearchBox" style="width: 400px;" />
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">상품
									<div class="cTip" code="OR.SM.AO.50"></div>
								</th>
								<td colspan="3"><select class="fSelect"
									id="eProductSearchType" name="product_search_type"
									style="width: 110px;">
										<option value="product_name" selected="selected">상품명</option>
										<option value="product_code">상품코드</option>
										<option value="item_code">품목코드</option>
										<option value="product_tag">상품태그</option>
										<option value="manufacturer_name">제조사</option>
										<option value="supplier_name">공급사</option>
								</select> <input type="text" id="eOrderProductText"
									name="order_product_text" class="fText" style="width: 490px;"
									value="" /> <input type="hidden" name="order_product_no"
									id="eOrderProductNo" value=""> <input type="hidden"
									name="find_option" value="product_no"></td>
							</tr>

						</tbody>
					</table>
				</div>
				
				<div class="mButton gCenter">
					<a href="#none" id="search_button" class="btnSearch"><span>검색</span></a>
					<a href="#none" id="eBtnInit" class="btnSearch reset"><span>초기화</span></a>
					<div id="ordProgress" class="mLoading">
						<p>처리중입니다. 잠시만 기다려 주세요.</p>
						<img
							src="//img.echosting.cafe24.com/ec/mode/influencer/common/ico_loading.gif"
							alt="" />
					</div>
				</div>

				<input type="hidden" name="main_search" id="main_search" value="">
			</div>

			<!--No delete -->
			<div id="ordOption1" class="mLayer gMedium"></div>
			<div id="ordOption2" class="mLayer gMedium"></div>
			<div id="ordOption3" class="mLayer gMedium"></div>
			<div id="layerOrderPath" class="mLayer gSmall"
				style="opacity: 1; top: 590px; left: 532px; margin-left: 0px; display: none;">
			</div>
			<div id="layerCompany" class="mLayer gSmall"
				style="display: none; opacity: 1;"></div>
			<div id="layerMethod" class="mLayer gSmall"
				style="display: none; opacity: 1;"></div>
			<!--No delete -->

			<div class="section" id="QA_returnExchange2">
				<div class="mState typeHeader">
					<div class="gLeft">
						<p class="total">
							[검색결과 <strong>0</strong>건]
						</p>
					</div>
				</div>
				<div class="mCtrl typeSetting setting">
					<div class="gLeft"></div>
				</div>
				<div class="mBoard typeOrder gScroll gCellSingle typeList">
					<table id="searchResultList" border="1" summary=""
						class="eChkBody tablesorter">
						<caption>교환 관리 목록</caption>
						<thead>
							<tr>
								<th scope="col" style="width: 24px; display: none;"><input
									type="checkbox" id="allChk" /></th>
								<th scope="col" style="width: 50px; display: none;">No</th>
								<th scope="col" style="width: 120px;">교환신청일<br>(교환접수일)
								</th>
								<th scope="col" style="width: 140px;">품목별 주문번호/<br />교환번호
								</th>
								<th scope="col" style="width: 95px;">주문자
									<div class="cTip eSmartMode" code="OD.OW.EM.140"></div>
								</th>
								<th scope="col" style="width: 220px;">상품명/옵션</th>
								<th scope="col" class="w40" style="">수량</th>
								<th scope="col" style="width: 90px;">주문상태</th>
								<th scope="col" style="width: 70px;">교환처리</th>
								<th scope="col" style="width: 35px;">메모</th>
							</tr>
						</thead>
						<tbody class="empty">
							<tr>
								<td colspan="8">검색된 주문내역이 없습니다.</td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="mCtrl typeFooter">
				</div>
				<div class="mPaginate">1</div>
			</div>
		</div>
	</form>
</body>
</html>