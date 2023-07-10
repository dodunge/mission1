<%@ page import="com.vo.HistoryVO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: dodun
  Date: 2023-06-21
  Time: 오후 6:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    List<HistoryVO> historyVOs = (List<HistoryVO>) request.getAttribute("historyVOs");
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
<form id="historyForm" name="historyForm" method="get">
    <div class="wifi-table-container">
        <table border="1">
            <th>ID</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>조회일자</th>
            <th>비고</th>
            <%
                if(historyVOs.size() != 0) {
                    for(HistoryVO historyVO : historyVOs) {
            %>
            <tr class="data-exit">
                <td><%=historyVO.getId() %></td>
                <td><%=historyVO.getHistoryX() %></td>
                <td><%=historyVO.getHistoryY() %></td>
                <td><%=historyVO.getHistoryDate() %></td>
                <td class="history-delete"><input type="button" value="삭제" onclick="historyDelete(<%=historyVO.getId() %>)"></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr class="data-not-exit">
                <td colspan="5">아직 위치 히스토리 조회 기록이 없습니다.</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</form>
</body>
<script type="text/javascript"  src="./static/js/history.js"></script>
</html>
