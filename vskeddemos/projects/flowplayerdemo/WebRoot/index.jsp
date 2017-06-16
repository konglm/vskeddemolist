<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>flowplayerdemo </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
<div>
<a href="${basePath }index1.jsp">use this</a><br>
<a href="${basePath }index2.jsp">use this2</a><br>
   <video controls width="624" height="260" id="myVideo1">
<source type="video/mp4" src="${basePath }videolist/test1.mp4">
   </video>
</div>
<div id="curTime" onclick="ts();"></div>
    <script src="${basePath }js/flowplayer/deps/jquery.min.js"></script>
    <script src="${basePath }js/flowplayer/lib/flowplayer.js"></script>
    <script>
    function ts(){
    	console.log(document.getElementById('myVideo1').currentTime)
    	$('#curTime').html(document.getElementById('myVideo1').currentTime);
    }
    ts();
    </script>
  </body>
</html>
