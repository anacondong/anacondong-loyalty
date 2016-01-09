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
    <link rel="shortcut icon" href="${context}/resources/assets/ico/favicon.ico">

    <title>Tooltip Viewport Example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${context}/resources/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${context}/resources/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="tooltip-viewport.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="${context}/resources/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${context}/resources/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <button type="button" class="btn btn-default pull-right tooltip-bottom" title="This should be shifted to the left">Shift Left</button>
    <button type="button" class="btn btn-default tooltip-bottom" title="This should be shifted to the right">Shift Right</button>
    <button type="button" class="btn btn-default tooltip-right" title="This should be shifted down">Shift Down</button>

    <button type="button" class="btn btn-default tooltip-right btn-bottom" title="This should be shifted up">Shift Up</button>

    <div class="container-viewport">
      <button type="button" class="btn btn-default tooltip-viewport-bottom" title="This should be shifted to the left">Shift Left</button>
      <button type="button" class="btn btn-default tooltip-viewport-right" title="This should be shifted down">Shift Down</button>

      <button type="button" class="btn btn-default pull-right tooltip-viewport-bottom" title="This should be shifted to the right">Shift Right</button>

      <button type="button" class="btn btn-default tooltip-viewport-right btn-bottom" title="This should be shifted up">Shift Up</button>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${context}/resources/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${context}/resources/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="${context}/resources/dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${context}/resources/assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="tooltip-viewport.js"></script>
  </body>
</html>
