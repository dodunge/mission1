<%@ page import="com.vo.BookmarkVO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: dodun
  Date: 2023-07-06
  Time: 오후 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BookmarkVO> bookmarkVOs = (List<BookmarkVO>) request.getAttribute("bookmarkVOs");
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
<form id="BookmarkForm" name="BookmarkForm">
    <div class="wifi-table-container">
        <table>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>와이파이명</th>
            <th>등록일자</th>
            <th>비고</th>
            <%
                if(bookmarkVOs.size() > 0) {
                    for(BookmarkVO bookmarkVO : bookmarkVOs) {
            %>
            <tr class="wifi-detail">
                <td><%=bookmarkVO.getId()%></td>
                <td><%=bookmarkVO.getBookmarkName()%></td>
                <td><%=bookmarkVO.getWifiName()%></td>
                <td><%=bookmarkVO.getInsertDate()%></td>
                <td style="text-align: center">
                    <a href="#" onclick="goBookmarkDelete(
                            '<%=bookmarkVO.getId()%>',
                            '<%=bookmarkVO.getBookmarkName()%>',
                            '<%=bookmarkVO.getWifiName()%>',
                            '<%=bookmarkVO.getInsertDate()%>')">삭제</a>
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
