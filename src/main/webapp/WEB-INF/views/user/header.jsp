<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>답인사</title>

<!-- favicon -->
<link rel="shortcut icon" href="user/images/01.header/logo.png">

<!-- css -->
<link rel="stylesheet" type="text/css" href="user/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="user/css/materialdesignicons.min.css" />
<link rel="stylesheet" type="text/css"
	href="user/css/jquery.mCustomScrollbar.min.css" />

<link rel="stylesheet" type="text/css" href="user/css/01.m_default.css" />
<link rel="stylesheet" type="text/css" href="user/css/02.m_header.css" />
<link rel="stylesheet" type="text/css" href="user/css/03.m_layout.css" />
<link rel="stylesheet" type="text/css"
	href="user/css/04.m_side_menu.css" />
<link rel="stylesheet" type="text/css" href="user/css/05.m_footer.css" />
<link rel="stylesheet" type="text/css" href="user/css/06.m_etc.css" />
<link rel="stylesheet" type="text/css" href="user/css/07.m_media.css" />



</head>

<body class="app" data-target="#nino-navbar" data-spy="scroll">


	<!-- 사이드 바-->
	<div class="side-bar menu" id="side-bar">

		<!--사이드 헤더-->
		<div class="sign-processor">
			<!-- 아이콘-->
			<div class="sign-icon">
				<i class="mdi mdi-account-circle"></i>
				<div class="sign-icon-2">
					<i class="mdi mdi-close" id="close"></i> <i
						class="mdi mdi-account-check" id="manager"></i>
				</div>

				<!-- 로그인/회원가입 -->
				<div class="sign-login">
					<!-- 첫번째 줄-->
					<a href="loginForm" class="sign-login-link">로그인 하기 ></a>
					<!-- 두번째 줄-->
					<div class="sign-join">
						<span class="sign-join-guide">아직 회원이 아니신가요?</span> <a
							href="joinFrm" class="sign-join-link">회원가입</a>
					</div>
				</div>
			</div>
		</div>

		<!-- 검색바-->
		<div class="search">
			<input type="text" class="search-text" placeholder="Search...">
			<button class="search-btn" type="submit">검색</button>
		</div>


		<!--카테고리 부분-->
		<!--대분류-->
		<div class="category-menu">
			<ul class="tab-menu-list">
				<li class="tab-menu-selector" id="s-category">카테고리</li>
				<li class="tab-menu-selector" id="s-community">커뮤니티</li>
			</ul>


			<!--카테고리 중분류-->
			<div class="category-m-menu" id="category">

				<!--중분류(메인 카테고리)-->
				<ul class="m-menu-list">
					<li class="menu_selector"><span class="menu_selector-wrapper"
						id="1"> 답례품 </span></li>
					<li class="menu_selector"><span class="menu_selector-wrapper"
						id="2"> 답레품 교환권 </span></li>
					<li class="menu_selector"><span class="menu_selector-wrapper">
							드레스/한복 </span></li>
					<li class="menu_selector"><span class="menu_selector-wrapper">
							헤어/메이크업 </span></li>
					<li class="menu_selector"><span class="menu_selector-wrapper">
							스튜디오 </span></li>
					<li class="menu_selector"><span class="menu_selector-wrapper">
							청첩장 </span></li>
					<li><a href="/categories" class="m-menu-all"> 카테고리 전체보기 <i
							class="mdi mdi-chevron-right"></i>
					</a></li>
				</ul>

				<!-- 소분류 -->
				<div class="s-menu-list">
					<a href="#" class="menu-link menu-link-all"> 답례품 전체보기 > </a>

					<div class="menu-line"></div>

					<a href="#" class="menu-link"> 돌 </a> <a href="#" class="menu-link">
						환갑/고희 </a><a href="#" class="menu-link"> 결혼 </a><a href="#"
						class="menu-link"> 전사 </a><a href="#" class="menu-link">
						2p/3p세트 타올 </a><a href="#" class="menu-link"> 원피스/페브릭 타올 </a><a
						href="#" class="menu-link"> 주방타올/발매트 </a> </a><a href="#"
						class="menu-link"> 케잌타올 </a>
				</div>


				<!-- 소분류2 -->
				<div class="s-menu-list-2">
					<a href="#" class="menu-link menu-link-all"> 답례품 교환권 전체보기 > </a>

					<div class="menu-line"></div>

					<a href="#" class="menu-link"> 커피 </a> <a href="#"
						class="menu-link"> 케이크 </a> <a href="#" class="menu-link"> 책 </a>
				</div>
			</div>

			<!--커뮤니티 중분류-->
			<div class="community-m-menu" id="community">

				<ul class="cm-menu-list">
					<li class="cmenu_selector"><a href="#"> 공지사항 <i
							class="mdi mdi-chevron-right"></i>
					</a></li>
					<li class="cmenu_selector"><a href="#"> 상품 사용후기 <i
							class="mdi mdi-chevron-right"></i>
					</a></li>
					<li class="cmenu_selector"><a href="#"> 상품 Q&A <i
							class="mdi mdi-chevron-right"></i>
					</a></li>
					<li class="cmenu_selector"><a href="#"> 이벤트 <i
							class="mdi mdi-chevron-right"></i>
					</a></li>
				</ul>

			</div>



		</div>
		<!--대분류-->

		<!-- 최근 본 상품 -->
		<div class="recently-product">
			<header>
				<h3>최근 본 상품</h3>
			</header>
			<div class="mini-posts">
				<a href="#"><img src="images/01.header/e(1).png" alt="" /></a> <a
					href="#"><img
					src="images/04.story/breakfast-gd3c429453_640.jpg" alt="" /></a> <a
					href="#"><img src="images/01.header/e(2).png" alt="" /></a> <a
					href="#"><img src="images/01.header/e(2).png" alt="" /></a>
			</div>
		</div>

		<!--고객센터 -->
		<div class="customer">
			<header>
				<h3>center</h3>
			</header>
			<div class="center">
				<ul>
					<li class="email"><a href="mailto:llap0420@naver.com">
							llap0420@naver.com</a></li>
					<li class="phone"><a href="tel:010-3455-6985">
							010-3455-6985</a></li>
					<li class="home">서울특별시 강서구 공항대로 212 (마곡동) <br /> 문영퀸즈파크11차 A동
						730호
					</li>
				</ul>
			</div>
			<div class="service">
				<ul>
					<li class="fa-envelope-o"><a href="tel:010-3455-6985"> <i
							class="mdi mdi-phone-in-talk"></i> 고객센터
					</a></li>
					<li class="fa-envelope-o"><a
						href="http://suynthe.cafe24.com/board/consult/list.html"> <i
							class="mdi mdi-bulletin-board"></i> 1:1 문의
					</a></li>
				</ul>
			</div>
		</div>

	</div>

	<!-- 헤더 -->
	<header id="nino-header">
		<div id="nino-headerInner">

			<!-- 헤더 - 네비게이션 -->
			<nav id="nino-navbar" class="navbar navbar-default" role="navigation">
				<div class="container">
					<!-- 로고(이미지,글씨) -->
					<div class="navbar-header">
						<!-- 로고 -->
						<a class="navbar-brand" href="#"> <img class="main-logo-img"
							src="user/images/01.header/logo.png" alt="web-logo"> <span
							class="nino-subHeading main-logo">DABYINSA</span>
						</a>
					</div>

					<!-- 메뉴바 옆 카테고리 -->
					<div class="nino-menuItem pull-right">
						<!-- 누르면 해당 메뉴가 있는 곳으로 이동함 -->
						<div class="collapse navbar-collapse pull-left"
							id="nino-navbar-collapse">

							<ul class="nav navbar-nav">
								<li><a href="#new-items">NEW ITEMS</a></li>
								<li><a href="#nino-latestBlog">BEST ITEMS</a></li>
								<li><a href="#nino-portfolio">STORY</a></li>
							</ul>
						</div>
						<!-- 장바구니 마이페이지-->
						<ul class="nino-iconsGroup nav navbar-nav">
							<!-- 사이드 메뉴 버튼 -->
							<li><a href="#"><i class="mdi mdi-heart-outline"></i></a></li>
							<li><a href="#"><i
									class="mdi mdi-cart-outline nino-icon"></i></a></li>
							<li><a href="#"><i class="mdi mdi-account"></i></a></li>
							<button id="sbtn" class="sbtn">
								<i class="mdi mdi-menu"></i>
							</button>
						</ul>


					</div>
					<!-- 메뉴바 옆 카테고리 -->


				</div>
				<!-- /.container-fluid -->
			</nav>

		</div>

	</header>
	<!--/#header-->






	<section>

		<!-- javascript -->
		<script src="js/side_index.js"></script>
		<script type="text/javascript" src="user/js/jquery.min.js"></script>
		<script type="text/javascript" src="user/js/isotope.pkgd.min.js"></script>
		<script type="text/javascript" src="user/js/jquery.prettyPhoto.js"></script>
		<script type="text/javascript" src="user/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="user/js/jquery.hoverdir.js"></script>
		<script type="text/javascript" src="user/js/modernizr.custom.97074.js"></script>
		<script type="text/javascript"
			src="user/js/jquery.mCustomScrollbar.concat.min.js"></script>
		<script type="text/javascript" src="user/js/unslider-min.js"></script>
		<script type="text/javascript" src="user/js/template.js"></script>
		<script type="text/javascript" src="user/js/sidemenu.js"></script>


	</section>

	</div>
	</div>
</body>

</html>