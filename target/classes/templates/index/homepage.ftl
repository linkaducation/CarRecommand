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

        <a href="/homepage">
            车库首页
        </a>
    <#if user??>
        <span>${user.nickName}，欢迎来到Allen的车库</span>
    <#else >
        <span>喵，欢迎来到Allen的车库</span>
        <a href="/user/login">请登录</a>
        <a href="/user/register">免费注册</a>
    </#if>

    </div>
</nav>

<title>Allen的车库</title>


<div class="homepageDiv">
    <div class="homepageCategoryProducts">

        <div class="header-nav-b" id="Jnav" style="height: auto;">
            <dl>
                <dt>字母：</dt>
                <dd class="zm" id="Jtag">
                    <a href="javascript:void(0);" class="cur">推荐</a>
                    <a href="#A" class="">A</a>
                    <a href="#B" class="">B</a>
                    <a href="#C" class="">C</a>
                    <a href="#D" class="">D</a>
                    <a href="#/F" class="">F</a>
                    <a href="#/G" class="">G</a>
                    <a href="#/H">H</a>
                    <a href="#/I">I</a>
                    <a href="#/J">J</a>
                    <a href="#/K">K</a>
                    <a href="#/L">L</a>
                    <a href="#/M">M</a>
                    <a href="#/N">N</a>
                    <a href="#/O">O</a>
                    <a href="#/P">P</a>
                    <a href="#/Q">Q</a>
                    <a href="#/R">R</a>
                    <a href="#/S">S</a>
                    <a href="#/T">T</a>
                    <a href="#/W">W</a>
                    <a href="#/X">X</a>
                    <a href="#/Y">Y</a>
                    <a href="#/Z">Z</a>
                </dd>
            </dl>
            <dl id="JbrandElements">
                <dt>品牌：</dt>
                <dd class="">


                    <a href="/brand/大众">大众</a>


                    <a href="/brand/丰田">丰田</a>


                    <a href="/brand/福特">福特</a>


                    <a href="/brand/现代">现代</a>


                    <a href="/brand/本田">本田</a>


                    <a href="/brand/日产">日产</a>


                    <a href="/brand/别克">别克</a>


                    <a href="/brand/奥迪">奥迪</a>


                    <a href="/brand/宝马">宝马</a>


                    <a href="/brand/奔驰">奔驰</a>


                    <a href="/brand/雪佛兰">雪佛兰</a>


                    <a href="/brand/起亚">起亚</a>


                    <a href="/brand/标致">标致</a>


                    <a href="/brand/长安">长安</a>


                    <a href="/brand/哈弗">哈弗</a>


                    <a href="/brand/比亚迪">比亚迪</a>


                    <a href="/brand/Jeep">Jeep</a>


                    <a href="/brand/马自达">马自达</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/奥迪">奥迪</a>
                    <a href="/brand/阿尔法·罗密欧">阿尔法·罗密欧</a>
                    <a href="/brand/阿斯顿·马丁">阿斯顿·马丁</a>
                    <a href="/brand/ARCFOX">ARCFOX</a>
                    <a href="/brand/ALPINA">ALPINA</a>
                    <a href="/brand/艾康尼克">艾康尼克</a>
                    <a href="/brand/AC Schnitzer">AC Schnitzer</a>
                    <a href="/brand/Arash">Arash</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/本田">本田</a>
                    <a href="/brand/奔驰">奔驰</a>
                    <a href="/brand/宝马">宝马</a>
                    <a href="/brand/别克">别克</a>
                    <a href="/brand/宝骏">宝骏</a>
                    <a href="/brand/保时捷">保时捷</a>
                    <a href="/brand/比亚迪">比亚迪</a>
                    <a href="/brand/标致">标致</a>
                    <a href="/brand/布加迪">布加迪</a>
                    <a href="/brand/宝沃">宝沃</a>
                    <a href="/brand/北京">北京</a>
                    <a href="/brand/奔腾">奔腾</a>
                    <a href="/brand/宾利">宾利</a>
                    <a href="/brand/北汽制造">北汽制造</a>
                    <a href="/brand/北汽新能源">北汽新能源</a>
                    <a href="/brand/北汽幻速">北汽幻速</a>
                    <a href="/brand/比速汽车">比速汽车</a>
                    <a href="/brand/北汽绅宝">北汽绅宝</a>
                    <a href="/brand/北汽道达">北汽道达</a>
                    <a href="/brand/北汽威旺">北汽威旺</a>
                    <a href="/brand/巴博斯">巴博斯</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/长安">长安</a>
                    <a href="/brand/长安欧尚">长安欧尚</a>
                    <a href="/brand/昌河">昌河</a>
                    <a href="/brand/长城">长城</a>
                    <a href="/brand/长安轻型车">长安轻型车</a>
                    <a href="/brand/成功">成功</a>
                    <a href="/brand/长江EV">长江EV</a>
                    <a href="/brand/CUPRA">CUPRA</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/大众">大众</a>
                    <a href="/brand/东风风神">东风风神</a>
                    <a href="/brand/DS">DS</a>
                    <a href="/brand/东风启辰">东风启辰</a>
                    <a href="/brand/东南">东南</a>
                    <a href="/brand/东风风行">东风风行</a>
                    <a href="/brand/东风风光">东风风光</a>
                    <a href="/brand/道奇">道奇</a>
                    <a href="/brand/东风小康">东风小康</a>
                    <a href="/brand/东风风度">东风风度</a>
                    <a href="/brand/东风">东风</a>
                    <a href="/brand/电咖">电咖</a>
                    <a href="/brand/大迪">大迪</a>
                    <a href="/brand/Dacia">Dacia</a>
                    <a href="/brand/大发">大发</a>
                    <a href="/brand/东风风诺">东风风诺</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/福特">福特</a>
                    <a href="/brand/丰田">丰田</a>
                    <a href="/brand/法拉利">法拉利</a>
                    <a href="/brand/Faraday Future">Faraday Future</a>
                    <a href="/brand/福田">福田</a>
                    <a href="/brand/菲亚特">菲亚特</a>
                    <a href="/brand/福迪">福迪</a>
                    <a href="/brand/福汽启腾">福汽启腾</a>
                    <a href="/brand/Fisker">Fisker</a>
                    <a href="/brand/FM Auto">FM Auto</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/广汽传祺">广汽传祺</a>
                    <a href="/brand/观致">观致</a>
                    <a href="/brand/广汽新能源">广汽新能源</a>
                    <a href="/brand/GMC">GMC</a>
                    <a href="/brand/国金汽车">国金汽车</a>
                    <a href="/brand/广汽吉奥">广汽吉奥</a>
                    <a href="/brand/光冈">光冈</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/哈弗">哈弗</a>
                    <a href="/brand/红旗">红旗</a>
                    <a href="/brand/汉腾">汉腾</a>
                    <a href="/brand/海马郑州">海马郑州</a>
                    <a href="/brand/海马">海马</a>
                    <a href="/brand/悍马">悍马</a>
                    <a href="/brand/海马新能源">海马新能源</a>
                    <a href="/brand/华颂">华颂</a>
                    <a href="/brand/华泰">华泰</a>
                    <a href="/brand/黄海">黄海</a>
                    <a href="/brand/海格">海格</a>
                    <a href="/brand/哈飞">哈飞</a>
                    <a href="/brand/华泰新能源">华泰新能源</a>
                    <a href="/brand/华普">华普</a>
                    <a href="/brand/华骐">华骐</a>
                    <a href="/brand/恒天">恒天</a>
                    <a href="/brand/Hennessey">Hennessey</a>
                    <a href="/brand/合众汽车">合众汽车</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/ITALDESIGN">ITALDESIGN</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/吉利汽车">吉利汽车</a>
                    <a href="/brand/Jeep">Jeep</a>
                    <a href="/brand/捷豹">捷豹</a>
                    <a href="/brand/江铃集团新能源">江铃集团新能源</a>
                    <a href="/brand/江淮">江淮</a>
                    <a href="/brand/江铃">江铃</a>
                    <a href="/brand/金杯">金杯</a>
                    <a href="/brand/君马汽车">君马汽车</a>
                    <a href="/brand/九龙">九龙</a>
                    <a href="/brand/金龙汽车">金龙汽车</a>
                    <a href="/brand/金旅">金旅</a>
                    <a href="/brand/江铃集团轻汽">江铃集团轻汽</a>
                    <a href="/brand/捷途">捷途</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/凯迪拉克">凯迪拉克</a>
                    <a href="/brand/克莱斯勒">克莱斯勒</a>
                    <a href="/brand/科尼赛克">科尼赛克</a>
                    <a href="/brand/卡威汽车">卡威汽车</a>
                    <a href="/brand/开瑞">开瑞</a>
                    <a href="/brand/凯翼">凯翼</a>
                    <a href="/brand/康迪">康迪</a>
                    <a href="/brand/卡升">卡升</a>
                    <a href="/brand/KTM">KTM</a>
                    <a href="/brand/凯马">凯马</a>
                    <a href="/brand/科瑞斯的">科瑞斯的</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/领克">领克</a>
                    <a href="/brand/雷克萨斯">雷克萨斯</a>
                    <a href="/brand/林肯">林肯</a>
                    <a href="/brand/铃木">铃木</a>
                    <a href="/brand/路虎">路虎</a>
                    <a href="/brand/雷诺">雷诺</a>
                    <a href="/brand/劳斯莱斯">劳斯莱斯</a>
                    <a href="/brand/兰博基尼">兰博基尼</a>
                    <a href="/brand/猎豹汽车">猎豹汽车</a>
                    <a href="/brand/陆风">陆风</a>
                    <a href="/brand/路特斯">路特斯</a>
                    <a href="/brand/力帆">力帆</a>
                    <a href="/brand/雷丁">雷丁</a>
                    <a href="/brand/理念">理念</a>
                    <a href="/brand/莲花">莲花</a>
                    <a href="/brand/朗世">朗世</a>
                    <a href="/brand/零跑">零跑</a>
                    <a href="/brand/拉共达">拉共达</a>
                    <a href="/brand/领志">领志</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/马自达">马自达</a>
                    <a href="/brand/MG名爵">MG名爵</a>
                    <a href="/brand/MINI">MINI</a>
                    <a href="/brand/玛莎拉蒂">玛莎拉蒂</a>
                    <a href="/brand/迈巴赫">迈巴赫</a>
                    <a href="/brand/迈凯伦">迈凯伦</a>
                    <a href="/brand/摩根">摩根</a>
                    <a href="/brand/明君华凯">明君华凯</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/纳智捷">纳智捷</a>
                    <a href="/brand/南京金龙">南京金龙</a>
                    <a href="/brand/nanoFLOWCELL">nanoFLOWCELL</a>
                    <a href="/brand/Noble">Noble</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/讴歌">讴歌</a>
                    <a href="/brand/欧睿">欧睿</a>
                    <a href="/brand/欧宝">欧宝</a>
                    <a href="/brand/欧朗">欧朗</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/帕加尼">帕加尼</a>
                    <a href="/brand/Polestar">Polestar</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/奇瑞">奇瑞</a>
                    <a href="/brand/起亚">起亚</a>
                    <a href="/brand/祺智">祺智</a>
                    <a href="/brand/庆铃汽车">庆铃汽车</a>
                    <a href="/brand/前途">前途</a>
                    <a href="/brand/奇点汽车">奇点汽车</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/日产">日产</a>
                    <a href="/brand/荣威">荣威</a>
                    <a href="/brand/瑞麒">瑞麒</a>
                    <a href="/brand/Rossion">Rossion</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/斯柯达">斯柯达</a>
                    <a href="/brand/三菱">三菱</a>
                    <a href="/brand/斯巴鲁">斯巴鲁</a>
                    <a href="/brand/上汽大通MAXUS">上汽大通MAXUS</a>
                    <a href="/brand/smart">smart</a>
                    <a href="/brand/SWM斯威汽车">SWM斯威汽车</a>
                    <a href="/brand/双龙">双龙</a>
                    <a href="/brand/斯达泰克">斯达泰克</a>
                    <a href="/brand/赛麟">赛麟</a>
                    <a href="/brand/思铭">思铭</a>
                    <a href="/brand/世爵">世爵</a>
                    <a href="/brand/萨博">萨博</a>
                    <a href="/brand/双环">双环</a>
                    <a href="/brand/陕西通家">陕西通家</a>
                    <a href="/brand/SF MOTORS">SF MOTORS</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/特斯拉">特斯拉</a>
                    <a href="/brand/腾势">腾势</a>
                    <a href="/brand/泰卡特">泰卡特</a>
                    <a href="/brand/泰克鲁斯·腾风">泰克鲁斯·腾风</a>
                    <a href="/brand/塔塔">塔塔</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/沃尔沃">沃尔沃</a>
                    <a href="/brand/WEY">WEY</a>
                    <a href="/brand/五菱">五菱</a>
                    <a href="/brand/蔚来">蔚来</a>
                    <a href="/brand/五十铃">五十铃</a>
                    <a href="/brand/威兹曼">威兹曼</a>
                    <a href="/brand/威麟">威麟</a>
                    <a href="/brand/沃克斯豪尔">沃克斯豪尔</a>
                    <a href="/brand/W Motors">W Motors</a>
                    <a href="/brand/威马汽车">威马汽车</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/现代">现代</a>
                    <a href="/brand/雪佛兰">雪佛兰</a>
                    <a href="/brand/雪铁龙">雪铁龙</a>
                    <a href="/brand/新凯">新凯</a>
                    <a href="/brand/西雅特">西雅特</a>
                    <a href="/brand/星驰">星驰</a>
                    <a href="/brand/小鹏汽车">小鹏汽车</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/英菲尼迪">英菲尼迪</a>
                    <a href="/brand/一汽">一汽</a>
                    <a href="/brand/依维柯">依维柯</a>
                    <a href="/brand/野马汽车">野马汽车</a>
                    <a href="/brand/御捷">御捷</a>
                    <a href="/brand/驭胜">驭胜</a>
                    <a href="/brand/云度新能源">云度新能源</a>
                    <a href="/brand/英致">英致</a>
                    <a href="/brand/裕路">裕路</a>
                    <a href="/brand/云雀汽车">云雀汽车</a>
                    <a href="/brand/永源">永源</a>
                    <a href="/brand/游侠">游侠</a>
                </dd>
                <dd class="hide">
                    <a href="/brand/众泰">众泰</a>
                    <a href="/brand/中华">中华</a>
                    <a href="/brand/中欧">中欧</a>
                    <a href="/brand/知豆">知豆</a>
                    <a href="/brand/之诺">之诺</a>
                    <a href="/brand/中兴">中兴</a>
                    <a href="/brand/中顺">中顺</a>
                    <a href="/brand/Zenvo">Zenvo</a>
                    <a href="/brand/正道汽车">正道汽车</a>
                </dd>
            </dl>
        </div>

        <br> <br> <br> <br> <br> <br> <br>

        <div class="eachHomepageCategoryProducts">
            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                按条件查询
            </button>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                请输入条件
                                <span style="font-size: 10px">（默认为无要求）</span>
                            </h4>
                        </div>
                        <form action="/search" method="post">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">油耗：</span>
                                <input class="form-control" style="width:100px" name="fuelConsumption" type="range" min="0.0" max="5.0" value="0">
                                <span class="input-group-addon">操控：</span>
                                <input class="form-control" style="width:100px" name="control" type="range" min="0.0" max="5.0" value="0">
                                <span class="input-group-addon">动力：</span>
                                <input class="form-control" style="width:100px" name="power" type="range" min="0.0" max="5.0" value="0">
                            </div>
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">配置：</span>
                                <input class="form-control" style="width:100px" name="configure" type="range" min="0.0" max="5.0" value="0">
                                <span class="input-group-addon">舒适：</span>
                                <input class="form-control" style="width:100px" name="comfortable" type="range" min="0.0" max="5.0" value="0">
                                <span class="input-group-addon">空间：</span>
                                <input class="form-control" style="width:100px" name="space" type="range" min="0.0" max="5.0" value="0">
                            </div>
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">外观：</span>
                                <input class="form-control" style="width:100px" name="appearance" type="range" min="0.0" max="5.0" value="0">
                                <span class="input-group-addon">内饰：</span>
                                <input class="form-control" style="width:100px" name="interior" type="range" min="0.0" max="5.0" value="0">
                                <span class="input-group-addon">性价比：</span>
                                <input class="form-control" style="width:83px" name="costPerformance" type="range" min="0.0" max="5.0" value="0">
                            </div>
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">定位：</span>
                                <select class="form-control" style="width:100px" name="type">
                                    <option>选择</option>
                                    <option value="0">微型车</option>
                                    <option value="1">紧凑型车</option>
                                    <option value="2">小型车</option>
                                    <option value="3">中型车</option>
                                    <option value="4">中大型车</option>
                                    <option value="5">大型车</option>
                                    <option value="6">紧凑型SUV</option>
                                    <option value="7">小型SUV</option>
                                    <option value="8">中型SUV</option>
                                    <option value="9">中大型SUV</option>
                                    <option value="10">大型SUV</option>
                                    <option value="11">面包车</option>
                                    <option value="12">MPV</option>
                                    <option value="13">跑车</option>
                                </select>
                                <span class="input-group-addon">最低价：</span>
                                <input class="form-control" style="width:83px" name="minPrice" type="number" value="0">
                                <span class="input-group-addon">最高价：</span>
                                <input class="form-control" style="width:83px" name="maxPrice" type="number" value="0">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <input type="submit" class="btn btn-primary">
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
        </div>

        <#--热门车辆展示-->
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">热门</span>
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