<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${context}/resources/favicon.ico">

    <title>Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${context}/resources/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${context}/resources/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="${context}/resources/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${context}/resources/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="${context}/resources/css/custom/carousel.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">ซื่อร้านอาหาร</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li ><a href="./">หน้าแรก</a></li>
                
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">รายการประเภทอาหาร<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">เนื้อ</a></li>
                    <li><a href="#">หมู</a></li>
                    <li><a href="#">ไก่</a></li>
                    <li><a href="#">ปู</a></li>
                    <li><a href="#">ปลา</a></li>
                  </ul>
                </li>
                <li class="active"><a href="aboutus">เกียวกับเรา</a></li>
                <li><a href="contactus">คิดต่อเรา</a></li>
                
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

	<br/><br/>
    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">


      <br/><br />
	<div class="panel panel-danger">
        <div class="panel-heading">
          <h3 class="panel-title center-block">เกียวกับเรา</h3>
        </div>
        <div class="panel-body">
          
			      <div class="row featurette">
			        <div class="col-md-7">
			          <h2 class="featurette-heading">เมนูที่ 1<span class="text-muted">ราคา 25 บาท</span></h2>
			          <p class="lead">พร้อมเสิร์ฟความอิ่มอร่อย ส่งตรงถึงบ้านคุณ โดยแต่ละเมนูให้พลังงาน ~350 Kcal ปรุงจากวัตถุดิบคุณภาพดี ใหม่ สด สะอาด ไม่ใช้น้ำมัน ผงชูรส น้ำตาล สารกันบูด สารเคมีต่างๆ โซเดี่ยมต่ำ ไขมันน้อย ทานแบบอิ่มอร่อยทุกมื้อ ก็มีหุ่นสวย เป๊ะ พร้อมสุขภาพดี ห่างไกลโรคได้แล้วค่ะ</p>
			        </div>
			        <div class="col-md-5">
			          <img class="featurette-image img-responsive center-block" src="${context}/resources/img/sub1.jpg" alt="Generic placeholder image">
			        </div>
			      </div>
			
			      <hr class="featurette-divider">
			
			      <div class="row featurette">
			        <div class="col-md-7 col-md-push-5">
			          <h2 class="featurette-heading">เมนูที่ 2<span class="text-muted">ราคา 25 บาท</span></h2>
			          <p class="lead">พร้อมเสิร์ฟความอิ่มอร่อย ส่งตรงถึงบ้านคุณ โดยแต่ละเมนูให้พลังงาน ~350 Kcal ปรุงจากวัตถุดิบคุณภาพดี ใหม่ สด สะอาด ไม่ใช้น้ำมัน ผงชูรส น้ำตาล สารกันบูด สารเคมีต่างๆ โซเดี่ยมต่ำ ไขมันน้อย ทานแบบอิ่มอร่อยทุกมื้อ ก็มีหุ่นสวย เป๊ะ พร้อมสุขภาพดี ห่างไกลโรคได้แล้วค่ะ</p>
			        </div>
			        <div class="col-md-5 col-md-pull-7">
			          <img class="featurette-image img-responsive center-block"  src="${context}/resources/img/sub1.jpg" alt="Generic placeholder image">
			        </div>
			      </div>

		 </div>
		</div>

      <!-- /END THE FEATURETTES -->


      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">กลับขึ้นข้างบน</a></p>
        <p>&copy; 2015 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${context}/resources/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${context}/resources/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="${context}/resources/dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${context}/resources/assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${context}/resources/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
