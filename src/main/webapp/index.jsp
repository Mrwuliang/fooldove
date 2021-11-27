<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorPage.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.4.1/css/bootstrap.css">
    <link rel="stylesheet" href=${pageContext.request.contextPath}+"/WEB-INF/css/css.css">
        <script src="webjars/jquery/3.5.1/dist/jquery.min.js"></script>
    <link href="webjars/bootstrap/3.4.1/js/bootstrap.js">
    <script>
        $(function (){
                $("#exampleInputName2").blur(function (){
                    let val = $.trim($("#exampleInputName2").val());
                    if (val.length!=0){
                        $.post("inputText",{"inputText":$(this).val()},function (data){
                            if (data == "1"){
                                $("#exampleInputName2").css({borderColor:"#ef4136"});
                                $("#p1").css({color:"#ef4136"}).html("不可使用！");
                            }else {
                                $("#exampleInputName2").css({borderColor:"#45b97c"});
                                $("#p1").css({color:"#45b97c"}).html("可以使用");
                            }
                        });
                    }
                })
            $.post("province",{},function (data){
                $(data).each(function (){
                    var option = "<option id='"+this.id+"'>"+this.name+"</option>";
                    $("#province").append(option);
                });
            });
        })
    </script>
</head>
<body>
    <div class="container">
        <div style="width: 400px;height: auto;margin: 0 auto;margin-top: 100px;" class="join">
            <form>
                <div style="margin-bottom: 20px;" class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">User</label>
                    <input type="username" class="form-control" id="exampleInputName2" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text hint"></div>
                </div>
                <div id="p1"></div>
                <div style="margin-bottom: 20px;" class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div style="margin-bottom: 20px;" class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword2">
                </div>
                <div style="margin-bottom: 20px;" class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1">
                </div>
                <select id="province" style="margin-top: 20px;" class="form-select" aria-label="Default select example">
                    <option>--请选择省份--</option>
                </select>
                <button style="margin-top: 20px; float: right;" type="submit" class="btn btn-primary">提交</button>
            </form>
        </div>
    </div>
</body>
</html>
