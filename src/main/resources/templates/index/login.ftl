
<!DOCTYPE html>
<html>
<head>
	<script src="../../jquery.min.js"></script>
	<link href="../../bootstrap.min.css" rel="stylesheet">
	<script src="../../bootstrap.min.js"></script>
	<link href="../../style.css" rel="stylesheet">
	<script src="../../md5.js"></script>
<script>
function formatMoney(num){
	num = num.toString().replace(/\$|\,/g,'');  
	if(isNaN(num))  
	    num = "0";  
	sign = (num == (num = Math.abs(num)));  
	num = Math.floor(num*100+0.50000000001);  
	cents = num%100;  
	num = Math.floor(num/100).toString();  
	if(cents<10)  
	cents = "0" + cents;  
	for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)  
	num = num.substring(0,num.length-(4*i+3))+','+  
	num.substring(num.length-(4*i+3));  
	return (((sign)?'':'-') + num + '.' + cents);  
}
function checkEmpty(id, name){
	var value = $("#"+id).val();
	if(value.length==0){
		
		$("#"+id)[0].focus();
		return false;
	}
	return true;
}
	$("a.productDetailTopReviewLink").click(function(){
		$("div.productReviewDiv").show();
		$("div.productDetailDiv").hide();
	});
	$("a.productReviewTopPartSelectedLink").click(function(){
		$("div.productReviewDiv").hide();
		$("div.productDetailDiv").show();		
	});
	
	$("span.leaveMessageTextareaSpan").hide();
	$("img.leaveMessageImg").click(function(){
		
		$(this).hide();
		$("span.leaveMessageTextareaSpan").show();
		$("div.orderItemSumDiv").css("height","100px");
	});

});
</script>	
</head>
<body>
<nav class="top ">
    <div class="top_middle">
        <a href="/">
            车库首页
        </a>
        <span>喵，欢迎来车库</span>
        <a href="login">请登录</a>
        <a href="register">免费注册</a>
    </div>
</nav>

<title>登陆</title>

<script>
$(function(){
    $("#userName").blur(function(){
        var phone = $("#userName").val();
        if(0==phone.length||!(/^1[34578]\d{9}$/.test(phone))){ 
            $("span.errorMessage").html("请输入正确的手机号");
            $("div.loginErrorMessageDiv").show();		
        } else {
            $("span.errorMessage").html("");
            $("div.loginErrorMessageDiv").hide();
        }
    });
    $("#password").blur(function(){
        var password = $("#password").val();
        if (8>password.length || password.length>16) {
            $("span.errorMessage").html("请输入正确的密码(8-16位)");
            $("div.loginErrorMessageDiv").show();
        } else {
            $("span.errorMessage").html("");
            $("div.loginErrorMessageDiv").hide();
        }
    });
})
</script>


<div id="loginDiv" style="position: relative">

	<img id="loginBackgroundImg" class="loginBackgroundImg" src="../../bg.jpg">
	
	<div>
		<div id="loginSmallDiv" class="loginSmallDiv">
			<div class="loginErrorMessageDiv">
				<div class="alert alert-danger" >
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
				  	<span class="errorMessage"></span>
				</div>
			</div>
				
			<div class="login_acount_text">账户登录</div>
			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-user"></span>
				</span>
				<input id="userName" name="userName" placeholder="手机" type="text">			
			</div>
			
			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
				<input id="password" name="password" type="password" placeholder="密码" type="text">
			</div>

			
			<div>
				<a href="register" class="pull-right">免费注册</a>
			</div>
			<br>
			<div style="margin-top:20px">
				<button class="btn btn-block redButton" onclick="submit()">登录</button>
			</div>
		</div>	
	</div>

	<script>
		function submit() {
            var phone = $("#userName").val();
            var pwd = $("#password").val();
            var password = $.md5(pwd);
            var loginUrl;
            if (!(/^1[34578]\d{9}$/.test(phone)) || 8 > pwd.length || pwd.length > 16) {
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            } else {
                var redirctUri = getUrlParam("redirect");
                if (0 === redirctUri.length) {
                    locationHref = "/";
                } else {
                    locationHref = redirctUri;
                }
                $.ajax({
                    url: "/dologin",
                    type: "POST",
                    data: {"userName": phone, "password": password},
                    dataType: "json",
                    success: function (result) {
                        if (result) {
                            window.location.href = locationHref
                        } else {
                            $("span.errorMessage").html("帐号或密码错误");
                            $("div.loginErrorMessageDiv").show();
                        }
                    }
                });
            }
        }

        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r !== null) return unescape(r[2]); return ""; //返回参数值
        }
	</script>

</div>	
<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
	<div class="modal-dialog deleteConfirmModalDiv">
       <div class="modal-content">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">确认删除？</h4>
          </div>
          <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
            <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
          </div>
        </div>
      </div>
	</div>
</div>

<div id="footer"  class="footer" style="display: block;">
    <div class="horizontal_line">
    </div>

    <div style="clear:both"></div>
    <div id="copyright" class="copyright">
        <div class="coptyrightMiddle">
            <div class="white_link" >
                <a href="/brand/nowhere" style="padding-left:0px" >关于车库</a>
                <a href="/brand/nowhere" > 帮助中心</a>
                <a href="/brand/nowhere" >开放平台</a>
                <a href="/brand/nowhere" >  诚聘英才</a>
                <a href="/brand/nowhere" >联系我们</a>
                <a href="/brand/nowhere" >网站合作</a>
                <a href="/brand/nowhere" >法律声明</a>
                <a href="/brand/nowhere" >知识产权</a>
                <a href="/brand/nowhere" >  廉正举报	</a>
            </div>
            <div class="white_link" >
            </div>

            <div class="license">
                <span>增值电信业务经营许可证： 浙B2-20110446</span>
                <span>网络文化经营许可证：浙网文[2015]0295-065号</span>
                <span>互联网医疗保健信息服务 审核同意书 浙卫网审【2014】6号 </span>
                <span>互联网药品信息服务资质证书编号：浙-（经营性）-2012-0005</span>
                <div class="copyRightYear">&copy; 2003-2016 KAOLA.COM 版权所有</div>
                <div>
                    <img src="/copyRight1.jpg">
                    <img src="/copyRight2.jpg">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>