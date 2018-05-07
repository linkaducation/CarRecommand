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
            <a href="/user/logout">退出登录</a>
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

        <#if characters??>
            <div class="eachHomepageCategoryProducts">
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">我最关注的点</span>
                    <br>
                    <br>
                    <p>
                        <#list characters as ch>
                            <button type="button" class="btn btn-primary btn-lg">${ch}</button>
                        </#list>
                    </p>
                    <div style="clear:both"></div>
                </div>
            </div>
        </#if>


        <#if advantage??>
            <br>
            <div class="eachHomepageCategoryProducts">
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">我最在意的汽车优点</span>
                    <br>
                    <br>
                    <p>
                        <#list advantage as ch>
                            <button type="button" class="btn btn-primary btn-lg">${ch}</button>
                        </#list>
                    </p>
                    <div style="clear:both"></div>
                </div>
            </div>
        </#if>

        <#if disadvantage??>
            <br>
            <div class="eachHomepageCategoryProducts">
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">我最能忍受的缺点</span>
                    <br>
                    <br>
                    <p>
                        <#list disadvantage as ch>
                            <button type="button" class="btn btn-primary btn-lg">${ch}</button>
                        </#list>
                    </p>
                    <div style="clear:both"></div>
                </div>
            </div>
        </#if>

        <#if mostViewsBrand??>
            <br>
            <div class="eachHomepageCategoryProducts">
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">浏览次数最多的汽车品牌</span>
                    <br>
                    <br>
                    <p>
                        <#list mostViewsBrand as ch>
                            <button type="button" class="btn btn-primary btn-lg">${ch}</button>
                        </#list>
                    </p>
                    <div style="clear:both"></div>
                </div>
            </div>
        </#if>

        <#if brands??>
            <br>
            <div class="eachHomepageCategoryProducts">
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">最近浏览的汽车品牌</span>
                    <br>
                    <br>
                    <p>
                        <#list brands as ch>
                            <button type="button" class="btn btn-primary btn-lg">${ch}</button>
                        </#list>
                    </p>
                    <div style="clear:both"></div>
                </div>
            </div>
        </#if>

        <#if mostViewCars??>
            <br>
            <div class="eachHomepageCategoryProducts">
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">浏览次数最多的车辆</span>
                    <br>
                    <br>
                    <#list mostViewCars as car>
                        <div class="productItem">
                            <a href="/detail/foreproduct/${car.id}"><img width="100px" src="${car.picturePath}"></a>
                            <a class="productItemDescLink" href="/detail/foreproduct/${car.id}">
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
        </#if>

        <#if latestCars??>
            <br>
            <div class="eachHomepageCategoryProducts">
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">最近的浏览记录</span>
                    <br>
                    <br>
                    <#list latestCars as car>
                        <div class="productItem">
                            <a href="/detail/foreproduct/${car.id}"><img width="100px" src="${car.picturePath}"></a>
                            <a class="productItemDescLink" href="/detail/foreproduct/${car.id}">
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
        </#if>

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

<script>
    var navBar = {
        init: function(data) {
            if($("#Jnav").length <=0){
                return false;
            }
            this.$nav = $("#Jnav");
            this.$JtagA = $("#Jtag a");
            this.$dPos = $(".dPos");
            this.$iPos = $(".iPos");
            this.dPos = [];
            this.iPos = [];
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
        scroll: function() {
            var self = this;
            $(window).on("scroll.JnavScroll", function() {
                self.addCurClass();
            });
        },

        addEvents: function() {
            var self = this,
                    $WINDOW = $(window);

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
                    self.addCurClass();
                }
            });

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
        showTags: function(num) {
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
            if ($("#Jnav").hasClass("navFix")&&self.flag===1) {
                var JselectHeight=$("#JselectBanner").height();
                var top = $("#JselectBanner").length > 0 ? JselectHeight : 0;
                $("#Jnav").css("top", top + "px");
                $("#Jnav").height(36);
                self.flag=0;
            }
            if(!$("#Jnav").hasClass("navFix")){
                $("#Jnav").css("height", "auto");
                self.flag=1;
            }
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