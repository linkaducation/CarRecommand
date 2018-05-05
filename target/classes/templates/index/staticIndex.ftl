
<!DOCTYPE html>
<html>
<head>
    <script src="../../jquery.min.js"></script>
    <link href="../../bootstrap.min.css" rel="stylesheet">
    <script src="../../bootstrap.min.js"></script>
    <link href="../../style.css" rel="stylesheet">
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
                    <a href="javascript:void(0);" class="">推荐</a>
                    <a href="#A" class="cur">A</a>
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
                <dd class="hide">


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
                <dd class="">
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

        <br> <br> <br><br> <br> <br><br> <br> <br><br>

        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">宝马</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/35,202"><img width="100px" src="/cars/ef43853d9a8e4c0a9c638f139b556717.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,202">
                                <span class="productItemDesc">
                                宝马1系
                                </span>
                    </a>
                    <span class="productPrice">
                                204,800-319,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,213"><img width="100px" src="/cars/eb6904fb206d4ee0be0f43334a37aee7.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,213">
                                <span class="productItemDesc">
                                宝马2系旅行车
                                </span>
                    </a>
                    <span class="productPrice">
                                236,900-331,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,219"><img width="100px" src="/cars/84428ddd3e5c43659dcf755894b80def.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,219">
                                <span class="productItemDesc">
                                宝马3系
                                </span>
                    </a>
                    <span class="productPrice">
                                288,000-486,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,242"><img width="100px" src="/cars/e6de40dff23a43ada2237eaf3790fe53.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,242">
                                <span class="productItemDesc">
                                宝马5系
                                </span>
                    </a>
                    <span class="productPrice">
                                439,900-665,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,260"><img width="100px" src="/cars/d3555de652754d449cd37bc3b561cb3c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,260">
                                <span class="productItemDesc">
                                宝马5系新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                498,900-698,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,263"><img width="100px" src="/cars/f3eb0144ec99490a941529352725affe.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,263">
                                <span class="productItemDesc">
                                宝马X1
                                </span>
                    </a>
                    <span class="productPrice">
                                286,000-439,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,270"><img width="100px" src="/cars/f3eb0144ec99490a941529352725affe.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,270">
                                <span class="productItemDesc">
                                宝马X1新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                398,000-398,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,273"><img width="100px" src="/cars/ef43853d9a8e4c0a9c638f139b556717.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,273">
                                <span class="productItemDesc">
                                宝马1系(进口)
                                </span>
                    </a>
                    <span class="productPrice">
                                256,000-469,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,285"><img width="100px" src="/cars/eb6904fb206d4ee0be0f43334a37aee7.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,285">
                                <span class="productItemDesc">
                                宝马2系
                                </span>
                    </a>
                    <span class="productPrice">
                                276,000-538,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,301"><img width="100px" src="/cars/84428ddd3e5c43659dcf755894b80def.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,301">
                                <span class="productItemDesc">
                                宝马3系(进口)
                                </span>
                    </a>
                    <span class="productPrice">
                                399,600-684,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">福特</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/38,485"><img width="100px" src="/cars/26e1a9f56cfc422f8d28b91b66ac3a48.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,485">
                                <span class="productItemDesc">
                                福克斯
                                </span>
                    </a>
                    <span class="productPrice">
                                115,800-165,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,502"><img width="100px" src="/cars/c752093464344125aa0649feab8b4d46.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,502">
                                <span class="productItemDesc">
                                福睿斯
                                </span>
                    </a>
                    <span class="productPrice">
                                96,800-122,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,509"><img width="100px" src="/cars/9cd98656a5974d858f94134857349a1d.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,509">
                                <span class="productItemDesc">
                                蒙迪欧
                                </span>
                    </a>
                    <span class="productPrice">
                                179,800-279,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,519"><img width="100px" src="/cars/9cd98656a5974d858f94134857349a1d.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,519">
                                <span class="productItemDesc">
                                蒙迪欧新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                259,800-337,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,525"><img width="100px" src="/cars/e6dc5108b4304b5d9051d93f16564c49.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,525">
                                <span class="productItemDesc">
                                金牛座
                                </span>
                    </a>
                    <span class="productPrice">
                                234,800-369,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,537"><img width="100px" src="/cars/04ca7335b24f493eac36ce3a97f689db.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,537">
                                <span class="productItemDesc">
                                翼搏
                                </span>
                    </a>
                    <span class="productPrice">
                                79,800-155,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,550"><img width="100px" src="/cars/a3dfee7258094c349a8359c28828b588.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,550">
                                <span class="productItemDesc">
                                翼虎
                                </span>
                    </a>
                    <span class="productPrice">
                                169,800-259,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,567"><img width="100px" src="/cars/d13439fb6dc7426986b45c0a58d7e3bc.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,567">
                                <span class="productItemDesc">
                                锐界
                                </span>
                    </a>
                    <span class="productPrice">
                                229,800-449,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,591"><img width="100px" src="/cars/3a8a889c6cf14cb2b5dacd5d19793f1a.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,591">
                                <span class="productItemDesc">
                                撼路者
                                </span>
                    </a>
                    <span class="productPrice">
                                265,800-360,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,678"><img width="100px" src="/cars/b7466ced097940459a1567c2ca25a823.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,678">
                                <span class="productItemDesc">
                                福克斯(进口)
                                </span>
                    </a>
                    <span class="productPrice">
                                259,800-399,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">本田</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/34,760"><img width="100px" src="/cars/dde09f915f9748b0b1dcf4fdf2401ffe.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,760">
                                <span class="productItemDesc">
                                凌派
                                </span>
                    </a>
                    <span class="productPrice">
                                109,800-149,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,770"><img width="100px" src="/cars/7f17aececf96404192ac526727b1038d.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,770">
                                <span class="productItemDesc">
                                锋范
                                </span>
                    </a>
                    <span class="productPrice">
                                79,800-119,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,798"><img width="100px" src="/cars/98f7e5e1cee842a4a5781c52f68991fb.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,798">
                                <span class="productItemDesc">
                                冠道
                                </span>
                    </a>
                    <span class="productPrice">
                                220,000-329,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,824"><img width="100px" src="/cars/82289a1baa0f47a58e1c38ec07d860ff.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,824">
                                <span class="productItemDesc">
                                奥德赛
                                </span>
                    </a>
                    <span class="productPrice">
                                229,800-354,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,845"><img width="100px" src="/cars/f064b7708a134521984973b340fc668b.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,845">
                                <span class="productItemDesc">
                                思铂睿
                                </span>
                    </a>
                    <span class="productPrice">
                                179,899-267,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,850"><img width="100px" src="/cars/7f87a801deb54be6a4760071d2a35009.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,850">
                                <span class="productItemDesc">
                                思铂睿锐·混动
                                </span>
                    </a>
                    <span class="productPrice">
                                249,899-265,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,853"><img width="100px" src="/cars/fdb494dece2f405f8cad95c5e07e9664.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,853">
                                <span class="productItemDesc">
                                杰德
                                </span>
                    </a>
                    <span class="productPrice">
                                129,900-179,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,866"><img width="100px" src="/cars/0df8fad7c6c2455a8a8495484789f94c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,866">
                                <span class="productItemDesc">
                                本田CR-V锐·混动
                                </span>
                    </a>
                    <span class="productPrice">
                                219,800-259,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,870"><img width="100px" src="/cars/582fbe9afd3f4f6b82ed292ad4e8e70c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,870">
                                <span class="productItemDesc">
                                本田UR-V
                                </span>
                    </a>
                    <span class="productPrice">
                                246,800-329,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,882"><img width="100px" src="/cars/35d3c579e12f4b62b564b6beebef5764.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,882">
                                <span class="productItemDesc">
                                艾力绅
                                </span>
                    </a>
                    <span class="productPrice">
                                249,800-309,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">丰田</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/38,271"><img width="100px" src="/cars/b9d93d717f224ab8a63707e784c38398.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,271">
                                <span class="productItemDesc">
                                YARiS L 致享
                                </span>
                    </a>
                    <span class="productPrice">
                                69,800-106,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,292"><img width="100px" src="/cars/216cf4058f374ce68768bb16f5832194.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,292">
                                <span class="productItemDesc">
                                凯美瑞
                                </span>
                    </a>
                    <span class="productPrice">
                                179,800-259,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,300"><img width="100px" src="/cars/82dbe8f69a05452fa25db712660e235d.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,300">
                                <span class="productItemDesc">
                                凯美瑞双擎
                                </span>
                    </a>
                    <span class="productPrice">
                                239,800-279,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,303"><img width="100px" src="/cars/2dcb0fe15fdb4ebe8c6eb0898e0fa4f6.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,303">
                                <span class="productItemDesc">
                                雷凌
                                </span>
                    </a>
                    <span class="productPrice">
                                109,800-161,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,312"><img width="100px" src="/cars/625267e3327c40db9fd77c82536d5e90.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,312">
                                <span class="productItemDesc">
                                雷凌双擎
                                </span>
                    </a>
                    <span class="productPrice">
                                139,800-159,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,371"><img width="100px" src="/cars/7f32fb5e03c8437aab59c7c60a219760.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,371">
                                <span class="productItemDesc">
                                威驰FS
                                </span>
                    </a>
                    <span class="productPrice">
                                69,800-109,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,384"><img width="100px" src="/cars/32c0ec755a55411eb46a988d70a63a11.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,384">
                                <span class="productItemDesc">
                                皇冠
                                </span>
                    </a>
                    <span class="productPrice">
                                254,800-391,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,406"><img width="100px" src="/cars/ed3f5493c9384ac7a58dab4c468e60d7.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,406">
                                <span class="productItemDesc">
                                RAV4荣放
                                </span>
                    </a>
                    <span class="productPrice">
                                179,800-269,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,458"><img width="100px" src="/cars/53eba63fc8a945f481f56bf91b9461e8.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,458">
                                <span class="productItemDesc">
                                埃尔法Alphard
                                </span>
                    </a>
                    <span class="productPrice">
                                759,000-864,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/38,467"><img width="100px" src="/cars/44e68a5966394050a41dc2032de22ffb.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/38,467">
                                <span class="productItemDesc">
                                普瑞维亚
                                </span>
                    </a>
                    <span class="productPrice">
                                389,799-610,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">别克</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/35,456"><img width="100px" src="/cars/bd20076782bd42e4a20935d3a7a3c978.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,456">
                                <span class="productItemDesc">
                                君威
                                </span>
                    </a>
                    <span class="productPrice">
                                175,799-269,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,465"><img width="100px" src="/cars/594686f9c3a7411f9f6109ca73d42cad.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,465">
                                <span class="productItemDesc">
                                君威新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                229,800-239,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,468"><img width="100px" src="/cars/e367ce2ee6244f469b0d4de407ac725a.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,468">
                                <span class="productItemDesc">
                                君越
                                </span>
                    </a>
                    <span class="productPrice">
                                229,800-339,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,482"><img width="100px" src="/cars/d9f7025a7407402d857a5c22680902fb.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,482">
                                <span class="productItemDesc">
                                君越新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                275,800-305,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,487"><img width="100px" src="/cars/76cf2d414cde4712820673f417da4e4b.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,487">
                                <span class="productItemDesc">
                                威朗
                                </span>
                    </a>
                    <span class="productPrice">
                                135,900-205,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,530"><img width="100px" src="/cars/5e91b892b8fa49969de7c93566cfb042.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,530">
                                <span class="productItemDesc">
                                昂科威
                                </span>
                    </a>
                    <span class="productPrice">
                                209,899-349,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,548"><img width="100px" src="/cars/71733b6946fb49faae8271e3b265caf4.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,548">
                                <span class="productItemDesc">
                                昂科拉
                                </span>
                    </a>
                    <span class="productPrice">
                                139,900-189,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,563"><img width="100px" src="/cars/6514bfa9f62d4ceda2fe5951109389b3.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,563">
                                <span class="productItemDesc">
                                别克GL8
                                </span>
                    </a>
                    <span class="productPrice">
                                229,899-449,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,572"><img width="100px" src="/cars/7000114b856b462c9f049fb12939f139.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,572">
                                <span class="productItemDesc">
                                昂科雷
                                </span>
                    </a>
                    <span class="productPrice">
                                509,000-649,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">奥迪</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/34,541"><img width="100px" src="/cars/e4fa858c9dd144399bb285d5755ed7d1.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,541">
                                <span class="productItemDesc">
                                奥迪A3
                                </span>
                    </a>
                    <span class="productPrice">
                                188,000-258,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,584"><img width="100px" src="/cars/2e06b32814364f26a0de09043b205311.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,584">
                                <span class="productItemDesc">
                                奥迪Q3
                                </span>
                    </a>
                    <span class="productPrice">
                                234,200-342,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,603"><img width="100px" src="/cars/508b98fd66bd41889dad9f36c5786ce8.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,603">
                                <span class="productItemDesc">
                                奥迪Q5
                                </span>
                    </a>
                    <span class="productPrice">
                                399,600-519,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,609"><img width="100px" src="/cars/0d4069d4b2c64181a8da002a03531dd3.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,609">
                                <span class="productItemDesc">
                                奥迪A1
                                </span>
                    </a>
                    <span class="productPrice">
                                204,800-234,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,612"><img width="100px" src="/cars/28b8c5aaabd74934997c3b60cb6fbefa.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,612">
                                <span class="productItemDesc">
                                奥迪A3(进口)
                                </span>
                    </a>
                    <span class="productPrice">
                                369,000-369,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,614"><img width="100px" src="/cars/28b8c5aaabd74934997c3b60cb6fbefa.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,614">
                                <span class="productItemDesc">
                                奥迪A3新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                399,000-399,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,616"><img width="100px" src="/cars/11f2c71d5d0245d3924d95eec8a84096.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,616">
                                <span class="productItemDesc">
                                奥迪A4(进口)
                                </span>
                    </a>
                    <span class="productPrice">
                                423,800-468,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,619"><img width="100px" src="/cars/959c4ba3a45f4ee78bb8bd47ee45486c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,619">
                                <span class="productItemDesc">
                                奥迪A5
                                </span>
                    </a>
                    <span class="productPrice">
                                398,000-642,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,633"><img width="100px" src="/cars/5c7e09171f9c4fe5b490101a6331811a.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,633">
                                <span class="productItemDesc">
                                奥迪A7
                                </span>
                    </a>
                    <span class="productPrice">
                                598,000-898,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,656"><img width="100px" src="/cars/321f80df89254486bba63a512be31221.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,656">
                                <span class="productItemDesc">
                                奥迪S5
                                </span>
                    </a>
                    <span class="productPrice">
                                678,800-803,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">日产</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/32,055"><img width="100px" src="/cars/2616a551b8f646819d78ab396efb29e5.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,055">
                                <span class="productItemDesc">
                                天籁
                                </span>
                    </a>
                    <span class="productPrice">
                                175,799-298,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,070"><img width="100px" src="/cars/c922f77e38614f2aa84f5c2f6dc181b8.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,070">
                                <span class="productItemDesc">
                                蓝鸟
                                </span>
                    </a>
                    <span class="productPrice">
                                105,900-143,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,077"><img width="100px" src="/cars/49a3222b966243f2b336a0b8660bf83d.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,077">
                                <span class="productItemDesc">
                                西玛
                                </span>
                    </a>
                    <span class="productPrice">
                                234,800-267,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,109"><img width="100px" src="/cars/9452097368a94fa5880a2c9e296ae6b3.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,109">
                                <span class="productItemDesc">
                                阳光
                                </span>
                    </a>
                    <span class="productPrice">
                                79,800-112,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,121"><img width="100px" src="/cars/260acb629c0b4a998c504a597d96cc9c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,121">
                                <span class="productItemDesc">
                                骊威
                                </span>
                    </a>
                    <span class="productPrice">
                                85,800-117,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,132"><img width="100px" src="/cars/57318e9bf4f54e6a8a46af05f20504a1.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,132">
                                <span class="productItemDesc">
                                骐达
                                </span>
                    </a>
                    <span class="productPrice">
                                99,900-134,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,144"><img width="100px" src="/cars/7dcbb24908a84eaaae9bfd9c8a1f7a7f.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,144">
                                <span class="productItemDesc">
                                奇骏
                                </span>
                    </a>
                    <span class="productPrice">
                                179,800-268,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,154"><img width="100px" src="/cars/d0cec87c345d4bc68e8866a6eb544953.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,154">
                                <span class="productItemDesc">
                                楼兰
                                </span>
                    </a>
                    <span class="productPrice">
                                238,800-291,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,158"><img width="100px" src="/cars/8ec1e10466024edeb03e66128647c29c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,158">
                                <span class="productItemDesc">
                                楼兰新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                297,800-379,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/32,163"><img width="100px" src="/cars/8a5ebfdcf33d480bbf8f89a4b5e7a681.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/32,163">
                                <span class="productItemDesc">
                                逍客
                                </span>
                    </a>
                    <span class="productPrice">
                                139,800-189,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">马自达</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/31,320"><img width="100px" src="/cars/f3575c19cc8d464d9ab153bc4f4a0b49.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/31,320">
                                <span class="productItemDesc">
                                马自达CX-5
                                </span>
                    </a>
                    <span class="productPrice">
                                169,800-245,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/31,329"><img width="100px" src="/cars/6ea0b83384a248408e9d0a36d6bae5f8.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/31,329">
                                <span class="productItemDesc">
                                阿特兹
                                </span>
                    </a>
                    <span class="productPrice">
                                175,799-237,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/31,342"><img width="100px" src="/cars/2fb29f02b75c462f9d191268b595802e.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/31,342">
                                <span class="productItemDesc">
                                马自达CX-4
                                </span>
                    </a>
                    <span class="productPrice">
                                140,800-215,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">奔驰</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/34,888"><img width="100px" src="/cars/93d08224feaa4760b3b7ea2241baa170.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,888">
                                <span class="productItemDesc">
                                奔驰C级
                                </span>
                    </a>
                    <span class="productPrice">
                                312,800-489,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,913"><img width="100px" src="/cars/736b2483a4d94d81abc8d2713091e0f6.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,913">
                                <span class="productItemDesc">
                                奔驰E级
                                </span>
                    </a>
                    <span class="productPrice">
                                422,800-634,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,970"><img width="100px" src="/cars/813f3e339ea64f96b1613f8e16916907.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,970">
                                <span class="productItemDesc">
                                奔驰A级
                                </span>
                    </a>
                    <span class="productPrice">
                                236,000-360,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,982"><img width="100px" src="/cars/a506916527b643d08345e79c48ea3e82.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,982">
                                <span class="productItemDesc">
                                奔驰B级
                                </span>
                    </a>
                    <span class="productPrice">
                                242,000-368,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/34,989"><img width="100px" src="/cars/f38b0e796b064b4dba3aa643415f523f.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/34,989">
                                <span class="productItemDesc">
                                奔驰CLA级
                                </span>
                    </a>
                    <span class="productPrice">
                                247,000-379,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,007"><img width="100px" src="/cars/93d08224feaa4760b3b7ea2241baa170.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,007">
                                <span class="productItemDesc">
                                奔驰C级(进口)
                                </span>
                    </a>
                    <span class="productPrice">
                                382,800-570,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,022"><img width="100px" src="/cars/736b2483a4d94d81abc8d2713091e0f6.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,022">
                                <span class="productItemDesc">
                                奔驰E级(进口)
                                </span>
                    </a>
                    <span class="productPrice">
                                530,000-853,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,074"><img width="100px" src="/cars/3b0cc177262d44bfb33f4c1ee10d5c97.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,074">
                                <span class="productItemDesc">
                                奔驰G级
                                </span>
                    </a>
                    <span class="productPrice">
                                1,329,000-1,838,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,079"><img width="100px" src="/cars/c232dd0bf540467ba0f7f803bb072826.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,079">
                                <span class="productItemDesc">
                                奔驰R级
                                </span>
                    </a>
                    <span class="productPrice">
                                598,000-788,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/35,097"><img width="100px" src="/cars/default.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/35,097">
                                <span class="productItemDesc">
                                奔驰SL级
                                </span>
                    </a>
                    <span class="productPrice">
                                1,068,000-1,308,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">大众</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/37,218"><img width="100px" src="/cars/cbaaf8b214484f0e921451a53971bfcb.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,218">
                                <span class="productItemDesc">
                                Cross桑塔纳
                                </span>
                    </a>
                    <span class="productPrice">
                                102,899-129,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,246"><img width="100px" src="/cars/fd2243db0dab4ad1a4e52c9472453e02.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,246">
                                <span class="productItemDesc">
                                帕萨特
                                </span>
                    </a>
                    <span class="productPrice">
                                189,899-303,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,259"><img width="100px" src="/cars/58e69e6fb891423d9edfccaf70325823.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,259">
                                <span class="productItemDesc">
                                朗行
                                </span>
                    </a>
                    <span class="productPrice">
                                112,899-162,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,282"><img width="100px" src="/cars/cbaaf8b214484f0e921451a53971bfcb.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,282">
                                <span class="productItemDesc">
                                桑塔纳
                                </span>
                    </a>
                    <span class="productPrice">
                                84,900-123,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,290"><img width="100px" src="/cars/116e414d4f0844d690cca2665775b7f4.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,290">
                                <span class="productItemDesc">
                                桑塔纳·浩纳
                                </span>
                    </a>
                    <span class="productPrice">
                                89,900-138,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,299"><img width="100px" src="/cars/523d72860f224b0b9be6fbe34cf34750.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,299">
                                <span class="productItemDesc">
                                辉昂
                                </span>
                    </a>
                    <span class="productPrice">
                                349,000-659,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,324"><img width="100px" src="/cars/1c9c5df9f06c4d3bbb31915cee8f6971.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,324">
                                <span class="productItemDesc">
                                途观
                                </span>
                    </a>
                    <span class="productPrice">
                                199,800-237,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,329"><img width="100px" src="/cars/7d2c9ff6b208409c9c4223525698fc6c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,329">
                                <span class="productItemDesc">
                                途观L
                                </span>
                    </a>
                    <span class="productPrice">
                                223,800-359,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,344"><img width="100px" src="/cars/02d717dee143413f9f7500f29b7ae50e.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,344">
                                <span class="productItemDesc">
                                途安L
                                </span>
                    </a>
                    <span class="productPrice">
                                145,800-230,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/37,352"><img width="100px" src="/cars/ae28c6e215b84c6fba3bbb7fdc7792ae.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/37,352">
                                <span class="productItemDesc">
                                大众CC
                                </span>
                    </a>
                    <span class="productPrice">
                                252,800-342,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">吉利汽车</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/39,977"><img width="100px" src="/cars/5e68bd273a6a4e1684b838030d52928d.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/39,977">
                                <span class="productItemDesc">
                                博瑞
                                </span>
                    </a>
                    <span class="productPrice">
                                119,800-179,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/40,040"><img width="100px" src="/cars/61c12bfe6b2d46ffb53d208d6a1074fc.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/40,040">
                                <span class="productItemDesc">
                                远景
                                </span>
                    </a>
                    <span class="productPrice">
                                53,900-72,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/40,072"><img width="100px" src="/cars/93aec1cf82bb4ff2a464d76a53c33bde.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/40,072">
                                <span class="productItemDesc">
                                帝豪GS
                                </span>
                    </a>
                    <span class="productPrice">
                                77,800-111,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/40,093"><img width="100px" src="/cars/6c465884053e4c48b9e9f12da2116e82.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/40,093">
                                <span class="productItemDesc">
                                远景SUV
                                </span>
                    </a>
                    <span class="productPrice">
                                74,900-101,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/40,105"><img width="100px" src="/cars/b816d05f5b9947cbbe221e3ef35bd527.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/40,105">
                                <span class="productItemDesc">
                                远景X3
                                </span>
                    </a>
                    <span class="productPrice">
                                50,900-65,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <div class="eachHomepageCategoryProducts">
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">雪佛兰</span>
                <br>
                <div class="productItem">
                    <a href="detail/foreproduct/33,519"><img width="100px" src="/cars/799e5e5bcaf5491e81ce0d912840be1b.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,519">
                                <span class="productItemDesc">
                                乐风RV
                                </span>
                    </a>
                    <span class="productPrice">
                                74,900-99,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/33,543"><img width="100px" src="/cars/cca8b0a8409e4585b9751f53d5a2a32c.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,543">
                                <span class="productItemDesc">
                                科沃兹
                                </span>
                    </a>
                    <span class="productPrice">
                                79,900-114,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/33,557"><img width="100px" src="/cars/085482e0d3e945faa7312c0a62b4a869.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,557">
                                <span class="productItemDesc">
                                科鲁兹
                                </span>
                    </a>
                    <span class="productPrice">
                                109,900-169,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/33,578"><img width="100px" src="/cars/e822a48162cf4486aff43675e7562f3a.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,578">
                                <span class="productItemDesc">
                                迈锐宝
                                </span>
                    </a>
                    <span class="productPrice">
                                164,899-189,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/33,586"><img width="100px" src="/cars/8629d39c0d03453aa651f14db92a4db1.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,586">
                                <span class="productItemDesc">
                                迈锐宝XL
                                </span>
                    </a>
                    <span class="productPrice">
                                179,899-249,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/33,599"><img width="100px" src="/cars/8629d39c0d03453aa651f14db92a4db1.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,599">
                                <span class="productItemDesc">
                                迈锐宝XL新能源
                                </span>
                    </a>
                    <span class="productPrice">
                                239,899-269,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/33,604"><img width="100px" src="/cars/1134c8af2d144027a5db302894e47c32.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,604">
                                <span class="productItemDesc">
                                创酷TRAX
                                </span>
                    </a>
                    <span class="productPrice">
                                99,900-149,000
                            </span>
                </div>
                <div class="productItem">
                    <a href="detail/foreproduct/33,613"><img width="100px" src="/cars/1bc9401381484b13bcc7caa6d7a75ea4.jpeg"></a>
                    <a class="productItemDescLink" href="detail/foreproduct/33,613">
                                <span class="productItemDesc">
                                探界者
                                </span>
                    </a>
                    <span class="productPrice">
                                174,899-250,000
                            </span>
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
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