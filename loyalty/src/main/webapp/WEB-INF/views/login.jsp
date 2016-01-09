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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${context}/resources/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${context}/resources/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${context}/resources/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="${context}/resources/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${context}/resources/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body onload='document.loginForm.username.focus();'>

    <div class="container">

      <form class="form-signin"  name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
        <h2 class="form-signin-heading">กรุณา กรอกข้อมูล ผู้ใช้ และ รหัส</h2>
        
         <c:if test="${not empty param.login_error}">
		     <label for="inputEmail" class="sr-only">
				เข้าใช้งานไม่สำเร็จ กรุณาลองอีกครั่ง.<br/>
				เหตุผล : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
			 </label>
		</c:if>
        
        <label for="inputEmail" class="sr-only">ชื่อ ผู้ใช้</label>
        <input type="text" id="j_username" name='j_username' class="form-control" placeholder="j_username" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name='j_password' class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"  name="_spring_security_remember_me"> ไม่ต้องถามฉันอีกในหนึงอาทิตย์
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${context}/resources/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
	
	
