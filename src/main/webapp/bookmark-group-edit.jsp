<%@ page import="com.vo.BookmarkGroupVO" %>
<%--
  Created by IntelliJ IDEA.
  User: dodun
  Date: 2023-07-06
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    BookmarkGroupVO bookmarkGroupVO = (BookmarkGroupVO) request.getAttribute("bookmarkGroupVO");
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
<form id="bookmarkGroupEditForm" name="bookmarkGroupEditForm">
    <div class="wifi-table-container">
        <table>
            <tr><input type="hidden" name="bookmarkGroupId" id="bookmarkGroupId" value="<%=bookmarkGroupVO.getId()%>"></tr>
            <tr>
                <th><label for="bookmarkName">북마크 이름</label></th>
                <td><input type="text" name="bookmarkName" id="bookmarkName" value="<%=bookmarkGroupVO.getBookmarkName()%>"></td>
            </tr>
            <tr>
                <th><label for="bookmarkOrder">순서</label></th>
                <td><input type="text" name="bookmarkOrder" id="bookmarkOrder" value="<%=bookmarkGroupVO.getBookmarkOrder()%>"></td>
            </tr>
            <tr>
                <td class="add-button" colspan="2">
                    <a href="#" onclick="goBookmarkGroup()">돌아가기</a>
                    <input type="button" value="수정" onclick="bookmarkGroupEdit()">
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
<script type="text/javascript"  src="./static/js/bookmark-group.js"></script>
</html>
