function loadHTML(file)
{
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function ()
    {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
                var allText = rawFile.responseText;
                document.write(allText);
            }
        }
    }
    rawFile.send(null);
}
function wifiForm() {
    var form = document.getElementById('headerForm');
    form.action = '/WifiServlet';
    form.submit();
}
function historyForm() {
    var form = document.getElementById('headerForm');
    form.action = '/HistoryGetServlet';
    form.submit();
}