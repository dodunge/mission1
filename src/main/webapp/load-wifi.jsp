<%--
  Created by IntelliJ IDEA.
  User: dodun
  Date: 2023-06-21
  Time: 오후 6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>와이파이 정보 구하기</title>
</head>
<style>
    div {
        text-align: center;
    }
    h1 {
        margin-bottom: 20px;
    }
</style>
<body>
<div>
    <h1><%=request.getAttribute("wifiCnt") %>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
    <a href="/index.jsp">홈으로 가기</a>
</div>
</body>
</html>
