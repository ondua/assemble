<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/5712e214cc.js"
   crossorigin="anonymous"></script>
<link rel="stylesheet"
   href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
   href="//http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/index/main.css">
<link rel="stylesheet" type="text/css" href="/resources/css/myPage/myPage.css">

<link rel="stylesheet" type="text/css" href="/resources/css/thema/thema.css">
<link rel="stylesheet" type="text/css" href="/resources/css/login&join/join.css">
<link rel="stylesheet" type="text/css" href="/resources/css/insert/webtooninsert.css">
<script type="text/javascript" src="/resources/js/index/jquery.1.12.4.js"></script>
<script type="text/javascript"
   src="/resources/plugins/bxslider/js/jquery.bxslider.js"></script>
<link rel="stylesheet" type="text/css"
   href="/resources/plugins/web-fonts-with-css/css/all.css" />
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script>
   $(document).ready(function() {

      $('#box1').click(function() {
         $('html, body').animate({
            scrollTop : '0'
         }, 500);
      });
      $('#box2').click(function() {
         $('html, body').animate({
            scrollTop : '400'
         }, 500);
      });
      $('#box3').click(function() {
         $('html, body').animate({
            scrollTop : '1000'
         }, 500);
      });
      $('#box4').click(function() {
         $('html, body').animate({
            scrollTop : '1000'
         }, 500);
      });

   });
</script>

</head>
<body>

   <div class="wrap">
   	 <c:if test="${empty id}"><%--로그인 전 화면 --%>
   
      <header>
         <div class="header-div">
            <h2>
               <a href="#"><img src="./images/index/logo.png" width="150"
               height="65" alt="웹툰리뷰"></a>
            </h2>
            <div class="selector-menu">
               <a href="tagpage/tag.jsp"><i class="fa-solid fa-play"></i><span>태그검색</span></a> 
               <a href="thema/thema.jsp"><i class="fa-solid fa-play"></i><span>테마검색</span></a> 
               <a href="FAQ/FAQ.jsp"><i class="fa-solid fa-play"></i><span>FAQ</span></a> 
               <a href="board/freeboard.jsp"><i class="fa-solid fa-play"></i><span>사사게</span></a>
            </div>

            <div class="login-join">
               <a href="users_login" class="login">로그인  </a>  |  <a href="join" class="join">  회원가입</a>
            </div>
            <div style="clear: both;"></div>

         </div>
      </header>
      <div style="clear: both;"></div>
      </c:if>
      
      <c:if test="${!empty id}"><%--로그인 이후 화면 --%>
      
      <header>
			<div class="header-div">
				<h2>
					<a href="main"><img src="./images/index/logo.png" width="150"
					height="65" alt="웹툰리뷰"></a>
				</h2>
				<div class="selector-menu">
					<a href="tagpage/tag.jsp"><i class="fa-solid fa-play"></i><span>태그검색</span></a> 
					<a href="thema/thema.jsp"><i class="fa-solid fa-play"></i><span>테마검색</span></a> 
					<a href="FAQ/FAQ.jsp"><i class="fa-solid fa-play"></i><span>FAQ</span></a> 
					<a href="board/freeboard.jsp"><i class="fa-solid fa-play"></i><span>사사게</span></a>
				</div>
				

				<form method="post" action="users_logout">
					<div class="login-join">
						<input type="button" class="login" value="${id}"
							onclick="location='myPage';" />  |  
						<input type="submit" class="join" value="로그아웃" />
				</div>
				</form>
	
				<div style="clear: both;"></div>
			</div>
		</header>
		<div style="clear: both;"></div>
		</c:if>
		
		</div>
      </body>
      </html>
      