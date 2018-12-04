function SendMsg(role)
{
    var text = document.getElementById("text");
    if (text.value == "" || text.value == null)
    {
        alert("Empty input, please retry")
    }
    else
    {
        send("message:"+linkName+","+role+","+SendMsgDispose(text.value));
        AddMsg('default', SendMsgDispose(text.value));
        text.value = "";
    }
}

function SendMsgDispose(detail)
{
    detail = detail.replace("\n", "<br>").replace(" ", "&nbsp;")
    return detail;
}

function AddMsg(user,content)
{
    var str = CreadMsg(user, content);
    var msgs = document.getElementById("msgs");
    msgs.innerHTML = msgs.innerHTML + str;
    $("#show")[0].scrollTop = 1000000;
}


function CreadMsg(user, content)
{
    var str = "";
    if(user == 'default')
    {
        str = "<div class=\"msg guest\"><div class=\"msg-right\" worker=\"\"><div class=\"msg-host photo\" style=\"background-image: url('https://www.v5kf.com/files/icons/201610/14761555537.png');\"></div><div class=\"msg-ball\" >" + content +"</div></div></div>"
    }
    else if(user == 'system'){
        str = '<div class="pnl-list" style="text-align: center;color: grey;">'+content+'</div>'
    }
    else
    {
        str = "<div class=\"msg robot\"><div class=\"msg-left\" worker=\""+user+"\"><div class=\"msg-host photo\" style=\"background-image: url('https://www.v5kf.com/files/icons/201610/14761555537.png');\"></div><div class=\"msg-ball\">" + content + "</div></div></div>";
    }
    return str;
}
