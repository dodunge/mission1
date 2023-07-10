function goBookmarkGroupAdd() {
    location.href="/bookmark-group-add.jsp";
}
function goBookmarkGroupEdit(id, bookmarkName, bookmarkOrder, mod) {
    var form = document.getElementById('BookmarkGroupForm');
    form.setAttribute("method", "post");
    form.setAttribute("action", "/BookmarkGroupEditServlet"); //요청 보낼 주소

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "id");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "bookmarkName");
    hiddenField.setAttribute("value", bookmarkName);
    form.appendChild(hiddenField);

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "bookmarkOrder");
    hiddenField.setAttribute("value", bookmarkOrder);
    form.appendChild(hiddenField);

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "editMod");
    hiddenField.setAttribute("value", mod);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}
function bookmarkGroupAdd() {
    var form = document.getElementById("bookmarkGroupForm");
    alert('북마크 그룹 정보를 추가하였습니다.');
    form.submit();
}
function bookmarkGroupEdit() {
    var form = document.getElementById("bookmarkGroupEditForm");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/BookmarkGroupModifyServlet"); //요청 보낼 주소
    alert('북마크 그룹 정보를 수정하였습니다.');
    form.submit();
}
function bookmarkGroupDelete() {
    var form = document.getElementById("bookmarkGroupDeleteForm");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/BookmarkGroupDeleteServlet"); //요청 보낼 주소
    alert('북마크 그룹 정보를 삭제하였습니다.');
    form.submit();
}
function goBookmarkGroup() {
    location.href="/BookmarkGroupServlet";
}
function bookmarkAdd() {
    var bookmark  = document.getElementById("bookmark");
    var value = (bookmark.options[bookmark.selectedIndex].value);

    var form = document.getElementById('wifiDetailForm');
    form.setAttribute("method", "post");
    form.setAttribute("action", "/BookmarkServlet"); //요청 보낼 주소

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "bookmarkName");
    hiddenField.setAttribute("value", value);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    alert('북마크 정보를 추가하였습니다');
    form.submit();
}
function goBookmarkDelete(id, bookmarkName, wifiName, insertDate) {
    var form = document.getElementById('BookmarkForm');
    form.setAttribute("method", "post");
    form.setAttribute("action", "/BookmarkDeleteServlet");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "bookmarkId");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "bookmarkName");
    hiddenField.setAttribute("value", bookmarkName);
    form.appendChild(hiddenField);

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "wifiName");
    hiddenField.setAttribute("value", wifiName);
    form.appendChild(hiddenField);

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "insertDate");
    hiddenField.setAttribute("value", insertDate);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();

}
function bookmarkDelete() {
    var form = document.getElementById('bookmarkGroupDeleteForm');
    alert('북마크 정보를 삭제하였습니다.');
    form.submit();
}