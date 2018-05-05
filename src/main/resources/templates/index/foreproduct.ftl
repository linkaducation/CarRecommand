<!DOCTYPE html>
<html>
<head>
    <script src="../../jquery.min.js"></script>
    <link href="../../bootstrap.min.css" rel="stylesheet">
    <script src="../../bootstrap.min.js"></script>
    <link href="../../style.css" rel="stylesheet">
    <script src="../../exporting.js"></script>
    <script src="../../highcharts.js"></script>
    <script src="../../highcharts-zh_CN.js"></script>
    <script src="../../oldie.js"></script>
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

<title>车辆详情</title>

<script>
    function choose(obj) {
        var thisObj=$(obj);
        var price = thisObj.attr("price");
        $(".promotionPrice").html(price);
        var id = thisObj.attr("id").replace(",", "");
        $(".productParamterList").addClass("hide");
        $("div[data-id='" + id + "']").removeClass("hide");
        $("div[advan-id='" + id + "']").removeClass("hide");
    }

</script>

    <div class="productPageDiv">
        <div class="imgAndInfo">
            <div class="imgInimgAndInfo">
                <img src="${car.picturePath}" class="bigImg">
                <div class="smallImageDiv">
                    <img src="${car.picturePath}" bigimageurl="${car.picturePath}" class="smallImage">
                </div>
                <div class="img4load hidden"><img src="${car.picturePath}"></div>
            </div>
            <div class="infoInimgAndInfo">
                <div class="productTitle">
                    ${car.brand}
                </div>
                <div class="productPrice">
                    <div class="productPriceDiv">
                        <div class="promotionDiv">
                            <span class="promotionPriceDesc">官方指导价 </span>
                            <span class="promotionPriceYuan">¥</span>
                            <span class="promotionPrice">
						        ${car.minPrice}-${car.maxPrice}
					        </span>
                        </div>
                    </div>
                </div>
                </div>
                <div class="infoInimgAndInfo">
                    <span class="serviceCommitmentDesc">版本</span>
                    <br>
                    <select class="serviceCommitmentLink" onchange="choose(this.options[selectedIndex])">
                        <option class="brandVersion">
                        请选择车型
                        </option>
                        <#list childrent as child>
                            <option class="brandVersion" price="${child.price}" id="${child.id}">
                                ${child.brand}
                            </option>
                        </#list>
			        </select>
                </div>
            </div>
            <div style="clear:both"></div>
        </div>
        <script>
            $(function(){
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
        <div class="productDetailDiv" style="display: block;">
            <div class="productDetailTopPart">
                <a href="#nowhere" class="productDetailTopPartSelectedLink selected">车辆保值率</a>
                <a href="#nowhere" class="productDetailTopReviewLink">配置信息</a>
            </div>
            <div class="productParamterPart">
                <div id="container" style="min-width:400px;height:400px"></div>
                <script>
                    <#if premiumRate??>
                        var chart = Highcharts.chart('container', {
                            chart: {
                                type: 'line'
                            },
                            title: {
                                text: '保值率'
                            },
                            subtitle: {
                                text: ''
                            },
                            xAxis: {
                                categories: ['一年', '二年', '三年', '四年', '五年', '六年', '七年', '八年', '九年',
                                    '十年', '十一年', '十二年', '十三年', '十四年', '十五年', '十六年', '十七年', '十八年', '十九年']
                            },
                            yAxis: {
                                title: {
                                    text: '保值率 (%)'
                                }
                            },
                            plotOptions: {
                                line: {
                                    dataLabels: {
                                        enabled: true          // 开启数据标签
                                    },
                                    enableMouseTracking: true // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                                }
                            },
                            series: [{
                                name: '${car.brand}',
                                data: [${premiumRate}]
                            }],
                        });
                    </#if>
                </script>
            </div>
        </div>
        <div class="productReviewDiv" style="display: none;">
            <div class="productDetailTopPart">
                <a href="#nowhere" class="productReviewTopPartSelectedLink">车辆保值率</a>
                <a href="#nowhere" class="selected">配置信息</a>
            </div>



            <div class="productParamterPart">
                <div class="productParamter">基本参数(选择车辆型号查看)：</div>

                <#list basicConfigs?keys as key>
                    <#if defaultId == key>
                        <div class="productParamterList" data-id="${key}">
                            <#list basicConfigs[key] as child>
                                   ${child}
                            </#list>
                        </div>
                    <#else>
                        <div class="productParamterList hide" data-id="${key}">
                            <#list basicConfigs[key] as child>
                                   ${child}
                            </#list>
                        </div>
                    </#if>
                </#list>
                <div style="clear:both"></div>

                <br><br><br>
                    <#if advantages??>
                        <div class="productParamter">亮点配置(选择车辆型号查看)：</div>
                        <#list advantages?keys as key>
                            <#if defaultId == key>
                                <div class="productParamterList" advan-id="${key}">
                                    <#list advantages[key] as name>
                                        <span>${name}:  是 </span>
                                    </#list>
                                </div>
                            <#else>
                                <div class="productParamterList hide" advan-id="${key}">
                                    <#list advantages[key] as name>
                                        <span>${name}:  是 </span>
                                    </#list>
                                </div>
                            </#if>
                        </#list>
                    </#if>
                <div style="clear:both"></div>
            </div>
        </div>
    </div>

    <div class="homepageDiv">
        <div class="homepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
            <#if simCars??>
                <div class="eachHomepageCategoryProducts">
                    <div class="left-mark"></div>
                    <span class="categoryTitle">相似车辆推荐</span>
                    <br>
                        <#list simCars as car>
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
            </#if>
            </div>
        </div>
    </div>

    <div id="footer"  class="footer" style="display: block;">
        <div id="footer_ensure" class="footer_ensure">
            <a href="#nowhere">
                <img src="../../ensure.png">
            </a>
        </div>
        <div class="horizontal_line">
        </div>
        <div id="footer_desc" class="footer_desc">
            <div class="descColumn">
                <span class="descColumnTitle">购物指南</span>
                <a href="#nowhere" >免费注册</a>
            </div>
            <div class="descColumn">
                <span class="descColumnTitle">车库保障</span>
                <a href="#nowhere" >发票保障</a>
                <a href="#nowhere" >售后规则</a>
                <a href="#nowhere" >缺货赔付</a>
            </div>
            <div class="descColumn">
                <span class="descColumnTitle">支付方式</span>
                <a href="#nowhere" >快捷支付</a>
                <a href="#nowhere" >信用卡</a>
                <a href="#nowhere" >货到付款</a>
            </div>
            <div class="descColumn">
                <span class="descColumnTitle">商家服务</span>
                <a href="#nowhere" >商家入驻</a>
                <a href="#nowhere" >商家中心</a>
                <a href="#nowhere" >车库智库</a>
                <a href="#nowhere" >车库规则</a>
                <a href="#nowhere" >物流服务</a>
                <a href="#nowhere" >喵言喵语</a>
                <a href="#nowhere" >运营服务</a>
            </div>
            <div class="descColumn">
                <span class="descColumnTitle">手机车库</span>
                <a href="#nowhere" ><img src="../../ma.png"></a>
            </div>
        </div>
        <div style="clear:both"></div>
        <div id="copyright" class="copyright">
            <div class="coptyrightMiddle">
                <div class="white_link" >
                    <a href="#nowhere" style="padding-left:0px" >关于车库</a>
                    <a href="#nowhere" > 帮助中心</a>
                    <a href="#nowhere" >开放平台</a>
                    <a href="#nowhere" >  诚聘英才</a>
                    <a href="#nowhere" >联系我们</a>
                    <a href="#nowhere" >网站合作</a>
                    <a href="#nowhere" >法律声明</a>
                    <a href="#nowhere" >知识产权</a>
                    <a href="#nowhere" >  廉正举报	</a>
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