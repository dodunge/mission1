<%@ page import="com.vo.BookmarkVO" %><%--
  Created by IntelliJ IDEA.
  User: dodun
  Date: 2023-07-06
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    BookmarkVO bookmarkVO = (BookmarkVO) request.getAttribute("bookmarkVO");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>와이파이 정보 구하기</title>
</head>
<link rel="stylesheet" href="./static/css/common.css">
<link rel="stylesheet" href="./static/css/bookmark.css">
<script type="text/javascript"  src="./static/js/header.js"></script>
<body>
<header id="header" class="fixed-top">
    <script>loadHTML("header.jsp");</script>
</header>
<br>
<form id="bookmarkGroupDeleteForm" name="bookmarkGroupDeleteForm" method="get" action="/BookmarkDeleteServlet">
    <div class="wifi-table-container">
        <table>
            <tr><input type="hidden" name="bookmarkId" id="bookmarkId" value="<%=bookmarkVO.getId()%>"></tr>
            <tr>
                <th>북마크 이름</th>
                <td><%=bookmarkVO.getBookmarkName()%></td>
            </tr>
            <tr>
                <th>와이파이명</th>
                <td><%=bookmarkVO.getWifiName()%></td>
            </tr>
            <tr>
                <th>등록일자</th>
                <td><%=bookmarkVO.getInsertDate()%></td>
            </tr>
            <tr>
                <td class="add-button" colspan="2">
                    <a href="/BookmarkServlet">돌아가기</a>
                    <input type="button" value="삭제" onclick="bookmarkDelete()">
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
<script type="text/javascript"  src="./static/js/bookmark-group.js"></script>
</html>
