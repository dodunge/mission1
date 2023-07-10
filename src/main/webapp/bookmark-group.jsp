<%@ page import="com.vo.BookmarkGroupVO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: dodun
  Date: 2023-07-06
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BookmarkGroupVO> bookmarkGroupVOs = (List<BookmarkGroupVO>) request.getAttribute("bookmarkGroupVOs");
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
<script type="text/javascript"  src="./static/js/header.js"></script>
<body>
<header id="header" class="fixed-top">
    <script>loadHTML("header.jsp");</script>
</header>
<br>
<form id="BookmarkGroupForm" name="BookmarkGroupForm">
    <div class="wifi-table-container">
        <input type="button" value="북마크 그룹 이름 추가" onclick="goBookmarkGroupAdd(); return false;">
        <table>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>순서</th>
            <th>등록일자</th>
            <th>수정일자</th>
            <th>비고</th>
            <%
                if(bookmarkGroupVOs.size() > 0) {
                    for(BookmarkGroupVO bookmarkGroupVO : bookmarkGroupVOs) {
            %>
            <tr class="wifi-detail">
                <td><%=bookmarkGroupVO.getId()%></td>
                <td><%=bookmarkGroupVO.getBookmarkName()%></td>
                <td><%=bookmarkGroupVO.getBookmarkOrder()%></td>
                <td><%=bookmarkGroupVO.getInsertDate()%></td>
                <%
                    if(bookmarkGroupVO.getUpdateDate() != null) {
                %>
                <td><%=bookmarkGroupVO.getUpdateDate() %></td>
                <%} else {%>
                <td></td>
                <% } %>
                <td style="text-align: center">
                    <a href="#" onclick="goBookmarkGroupEdit(
                            '<%=bookmarkGroupVO.getId()%>',
                            '<%=bookmarkGroupVO.getBookmarkName()%>',
                            '<%=bookmarkGroupVO.getBookmarkOrder()%>', '1')">수정</a>
                    <a href="#" onclick="goBookmarkGroupEdit(
                            '<%=bookmarkGroupVO.getId()%>',
                            '<%=bookmarkGroupVO.getBookmarkName()%>',
                            '<%=bookmarkGroupVO.getBookmarkOrder()%>', '2')">삭제</a>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr class="data-not-exit">
                <td colspan="6">정보가 존재하지 않습니다.</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</form>
</body>
<script type="text/javascript"  src="./static/js/bookmark-group.js"></script>
</html>
