<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Header</title>
</head>
<body>
<form id="headerForm" name="headerForm" method="get">
    <h1>와이파이 정보 구하기</h1>
    <div>
        <a href="/index.jsp">홈</a> |
        <a href="javascript:historyForm()">위치 히스토리 목록</a> |
        <a href="javascript:wifiForm();">Open API 와이파이 가져오기</a> |
        <a href="/BookmarkServlet">북마크 보기</a> |
        <a href="/BookmarkGroupServlet">북마크 그룹 관리</a>
    </div>
</form>
</body>
</html>