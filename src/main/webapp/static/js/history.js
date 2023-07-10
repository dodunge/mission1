function historyDelete(id) {
    var form = document.getElementById('historyForm');
    form.setAttribute("action", "/HistoryDeleteServlet"); //요청 보낼 주소

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "id");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
    document.getElementById("form").remove();
}