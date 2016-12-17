<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<!doctype html>
<html style="width:100%;height:100%">
<head>
  <meta charset="utf-8">
  <title>plp</title>
  <meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
    <script src="./js/jquery-1.11.1.min.js"></script>
    <script>
        $(function() {
            $("#submitBtn").click(function () {
                var content=$("#textInput").val();
                console.log("content--->"+content)
                $.ajax({
                    type: "post",
                    url: "${pagecontext.request.contextpath}/plp/check.do",
                    //url: "http://localhost:8090/check.do",
                    data: {
                        content: content
                    },
                    success:function(res){
                        console.log("data--->"+res.success)
                        $("#msg").text(res.msg);//将按钮可用
                    }
                })
            })
        });
    </script>
</head>
<body style="width:100%;height:100%;min-width:1000px">
<p>输入内容:</p> <input type="text" id="textInput">
<p id="msg"></p>
<button id="submitBtn">提交</button>
</body>
</html>
