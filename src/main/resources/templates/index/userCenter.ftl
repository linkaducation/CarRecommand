<!DOCTYPE html>
<html>
<head>
    <script src="../../jquery.min.js"></script>
    <link href="../../bootstrap.min.css" rel="stylesheet">
    <script src="../../bootstrap.min.js"></script>
    <link href="../../style.css" rel="stylesheet">

<#--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body data-tab-id="448">
<nav class="top ">
    <div class="top_middle">

        <a href="/">
            车库首页
        </a>
    <#if user??>
        <span>${user.nickName}，欢迎来到Allen的车库</span>
        <span class="pull-right">
			<a href="/user/center">个人中心</a>
		</span>
    <#else >
        <span>喵，欢迎来到Allen的车库</span>
        <a href="/user/login">请登录</a>
        <a href="/user/register">免费注册</a>
    </#if>

    </div>
</nav>

<title>个人中心</title>


<div class="homepageDiv">
    <div class="homepageCategoryProducts">

    <#--热门车辆展示-->
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">热门汽车</span>
                <br>
                <#list hotCars as car>
                <#--核心div，展示商品-->
                    <div class="productItem">
                        <a href="detail/foreproduct/${car.id}"><img width="100px" src="${car.picturePath}"></a>
                        <a class="productItemDescLink" href="detail/foreproduct/${car.id}">
                                <span class="productItemDesc">
                                    ${car.brand}
                                </span>
                        </a>
                        <span class="productPrice">
                                ${car.minPrice}-${car.maxPrice}
                            </span>
                    </div>
                </#list>
                <div style="clear:both"></div>
            </div>
        </div>

    <#--小标题，分类-->
    <#list cars?keys as key>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle"><a href="/brand/${key}">${key}</a></span>
                <br>
                <#list cars[key] as car>
                <#--核心div，展示商品-->
                    <div class="productItem">
                        <a href="detail/foreproduct/${car.id}"><img width="100px" src="${car.picturePath}"></a>
                        <a class="productItemDescLink" href="detail/foreproduct/${car.id}">
                                <span class="productItemDesc">
                                    ${car.brand}
                                </span>
                        </a>
                        <span class="productPrice">
                                ${car.minPrice}-${car.maxPrice}
                            </span>
                    </div>
                </#list>
                <div style="clear:both"></div>
            </div>
        </div>
    </#list>
    </div>
</div>

<div id="footer"  class="footer" style="display: block;">
    <div id="footer_ensure" class="footer_ensure">
        <a href="/brand/nowhere">
            <img src="../../ensure.png">
        </a>
    </div>
    <div class="horizontal_line">
    </div>
    <div id="footer_desc" class="footer_desc">
        <div class="descColumn">
            <span class="descColumnTitle">购物指南</span>
            <a href="/brand/nowhere" >免费注册</a>
        </div>
        <div class="descColumn">
            <span class="descColumnTitle">车库保障</span>
            <a href="/brand/nowhere" >发票保障</a>
            <a href="/brand/nowhere" >售后规则</a>
            <a href="/brand/nowhere" >缺货赔付</a>
        </div>
        <div class="descColumn">
            <span class="descColumnTitle">支付方式</span>
            <a href="/brand/nowhere" >快捷支付</a>
            <a href="/brand/nowhere" >信用卡</a>
            <a href="/brand/nowhere" >货到付款</a>
        </div>
        <div class="descColumn">
            <span class="descColumnTitle">商家服务</span>
            <a href="/brand/nowhere" >商家入驻</a>
            <a href="/brand/nowhere" >商家中心</a>
            <a href="/brand/nowhere" >车库智库</a>
            <a href="/brand/nowhere" >车库规则</a>
            <a href="/brand/nowhere" >物流服务</a>
            <a href="/brand/nowhere" >喵言喵语</a>
            <a href="/brand/nowhere" >运营服务</a>
        </div>
        <div class="descColumn">
            <span class="descColumnTitle">手机车库</span>
            <a href="/brand/nowhere" ><img src="../../ma.png"></a>
        </div>
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

<script>
    var navBar = {
        init: function(data) {
            if($("#Jnav").length <=0){
                return false;
            }
            this.$nav = $("#Jnav");
            this.$JtagA = $("#Jtag a");
            this.$dPos = $(".dPos"); //所有的品牌锚点
            this.$iPos = $(".iPos"); //所有的车系锚点
            this.dPos = []; //品牌锚点高度
            this.iPos = []; //车系锚点高度
            // this.data = data; //锚点的data
            this.sElement = $("#JbrandElements")[0];
            this.conBool = true;
            this.dPosCss();
            this.scroll();
            this.addEvents();
            this.addCurClass();
            this.flag=1;
        },
        /**
         * 记录锚点的位置,用于scroll事件
         * 用来触发添加样式
         */
        dPosCss: function() {
            var _navH = this.$nav.height() + 20;
            //将所有的锚点都向上移
            this.$dPos.css("height", _navH).css("top", -150);
            this.$iPos.css("height", _navH).css("top", -150);
            // 存放锚点所在的位置
            for (var i = 0, l = this.$dPos.length; i < l; i++) {
                this.dPos.push(this.$dPos.eq(i).offset().top);
                this.iPos.push(this.$iPos.eq(i).offset().top);
            }
        },
        /*
        *监听滚动事件 触发动态添加样式
        */
        scroll: function() {
            var self = this;
            $(window).on("scroll.JnavScroll", function() {
                self.addCurClass();
            });
        },

        /*
        * 其他的事件
        */

        addEvents: function() {
            var self = this,
                    $WINDOW = $(window);

            //展开筛选时,重新获取一次id占位的高度
            $("#ctrlBtn").on("click", function() {
                self.dPos = [];
                self.iPos = [];
                self.dPosCss();
                $WINDOW.off(".JnavScroll");
                self.scroll();
            });

            // enter
            $("#Jnav").on("mouseenter", function() {
                if ($("#Jnav").hasClass("navFix")) {
                    $("#Jnav").css("height", "auto");
                }
            });
            $("#Jnav").on("mouseleave", function() {
                if ($("#Jnav").hasClass("navFix")) {
                    $("#Jnav").css("height", "36px");
                    // 离开的时候判断距离 给相应位置的加上cur
                    self.addCurClass();
                }
            });

            // show tag
            this.showTags(0);
            $("#Jtag a").each(function(i) {
                $(this).mouseover(function() {
                    $(this).addClass("cur").siblings().removeClass("cur");
                    self.showTags(i);
                    if ($("#Jnav").hasClass("navFix")) {
                        $("#Jnav").css("height", "auto");
                    }
                });
            });
        },
        // showTag 动态添加元素
        showTags: function(num) {
            /* var _oFragment = document.createDocumentFragment(),
               _sBrand = this.data[num],
               l = _sBrand.length;
             this.sElement.innerHTML = "";
             for (var i = 0; i < l; i++) {
               var aBrand = document.createElement("a");
               aBrand.href = "#" + _sBrand[i].id;
               aBrand.innerHTML = _sBrand[i].name;
               _oFragment.appendChild(aBrand);
             }
             this.sElement.appendChild(_oFragment);*/
            var dds = this.sElement.getElementsByTagName("dd");
            for (var i = 0; i < dds.length; i++) {
                dds[i].className = "hide";
            }
            dds[num].className = "";
            this.conBool = true;
            if (num == 0) {
                this.conBool = false;
            }
        },
        addCurClass: function() {
            var arr = this.dPos,
                    self = this;
            // 高度判断
            if ($("#Jnav").hasClass("navFix")&&self.flag===1) {
                // 判断有没有已选择条件,然后动态给top
                var JselectHeight=$("#JselectBanner").height();
                var top = $("#JselectBanner").length > 0 ? JselectHeight : 0;
                $("#Jnav").css("top", top + "px");
                // 如果有导航fix了 动态给个高度
                $("#Jnav").height(36);
                self.flag=0;
            }
            // 没有样式的时候高度变化回来
            if(!$("#Jnav").hasClass("navFix")){
                $("#Jnav").css("height", "auto");
                self.flag=1;
            }
            // scroll 给 锚点添加样式
            for (var i = 0; i < arr.length; i++) {
                var windowScroll = $(window).scrollTop();
                if (windowScroll > arr[i] - 50) {
                    self.$JtagA.removeClass("cur").eq(i + 1).addClass("cur");
                } else if (windowScroll < arr[0] - 50) {
                    self.$JtagA.removeClass("cur").eq(0).addClass("cur");
                }
            }
        }
    };
    navBar.init();
</script>
</body>
</html>