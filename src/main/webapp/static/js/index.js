function goWifiDetail(id, distance, mng_no, borough, name, address,
                      address_detail, floor, type, agency, service, net_type,
                      install_year, in_out_door, connect_env, lat, lnt, date) {

    var form = document.createElement('form');
    form.setAttribute("id", "form");
    form.setAttribute("method", "Post");
    form.setAttribute("action", "/WifiDetailServlet"); //요청 보낼 주소

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "id");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "distance");
    hiddenField.setAttribute("value", distance);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "mng_no");
    hiddenField.setAttribute("value", mng_no);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "borough");
    hiddenField.setAttribute("value", borough);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "name");
    hiddenField.setAttribute("value", name);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "address");
    hiddenField.setAttribute("value", address);
    form.appendChild(hiddenField);
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "addressDetail");
    hiddenField.setAttribute("value", address_detail);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "floor");
    hiddenField.setAttribute("value", floor);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "type");
    hiddenField.setAttribute("value", type);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "agency");
    hiddenField.setAttribute("value", agency);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "service");
    hiddenField.setAttribute("value", service);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "netType");
    hiddenField.setAttribute("value", net_type);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "installYear");
    hiddenField.setAttribute("value", install_year);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "inOutDoor");
    hiddenField.setAttribute("value", in_out_door);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "connectEnv");
    hiddenField.setAttribute("value", connect_env);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "lat");
    hiddenField.setAttribute("value", lat);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "lnt");
    hiddenField.setAttribute("value", lnt);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "date");
    hiddenField.setAttribute("value", date);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
    document.getElementById("form").remove();
}