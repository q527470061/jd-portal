/**
 * 倚窗听雨（秦）制作 组件封装
 */
// 京东页面尾部
Vue.component('jd-footer', {
	template: '<div class="container text-center footer">						<ul class="row nav nav-pills ">				<li>					<a href="#"> 关于我们 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 人才招聘 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 商家入驻 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 广告服务 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 手机京东 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 友情链接 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 销售联盟 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 京东社区 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 京东公益 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> 京东公益 &nbsp; &nbsp; |</a>				</li>				<li>					<a href="#"> English Site &nbsp; &nbsp;</a>				</li>			</ul>			<div class="row foot_but "> Copyright &nbsp;© &nbsp;2004 - 2018 &nbsp; &nbsp;京东JD.com &nbsp;版权所有</div>		</div>'
})

// 顶部搜索
Vue.component('jd-search', {
	data: function() {
		return {
			query: '曲面屏'
		}
	},
	template: '<div class="container head_search">			<div class="row">				<div class="col-md-4 text-center"><img src="/img/jdlogo2.png" /></div>				<div class="col-md-8">					<div class="col-md-6"><input type="search" class="form-control" v-model="query" /></div>					<div class="col-md-6 soubutton">						<a href="#" class="btn btn-info btn-lg"  @click="fun"><span class="glyphicon glyphicon-search">搜索</span></a>					</div>				</div>			</div>		</div>',
	methods: {
		fun() {
			sessionStorage.clear();
			sessionStorage.setItem('query', this.query);
			window.location.href = "/products.html";
		}
	}
})

// 顶部top1
Vue.component('jd-top1', {
	props: ['top_param1', 'top_param2'],
	template: '<div class="container top">			<div class="row">				<nav>					<ul class="col-md-2 nav nav-pills pull-left" :style="top_param1">						<li id="ttbar-home">							<a href="javascript:JD.getIndex()">								<span class="glyphicon glyphicon-home"></span>京东首页							</a>						</li>						<li id="ttbar-mycity">							<a href="#">								<span class="glyphicon glyphicon-map-marker" style="color: red;"></span>北京							</a>						</li>					</ul>					<ul class="col-md-1"></ul>					<ul class="col-md-8 nav nav-pills pull-right top_ul" :style="top_param2">						<li style="margin-right: -35px;" id="login_name">							<a href="javascript:JD.login()" style="color: red;">您好，请登陆 &nbsp; &nbsp;</a>						</li>						<li id="login_state">							<a href="javascript:JD.registe()">免费注册 &nbsp; |</a>						</li>						<li>							<a href="javascript:JD.myorder()">我的订单 &nbsp; |</a>						</li>						<li class="dropdown ">							<a href="# " class="dropdown-toggle " data-toggle="dropdown ">								我的京东<b class="caret "></b> &nbsp; |							</a>							<table class="dropdown-menu panel panel-default ">								<tr>									<td>产品 A</td>									<td>200</td>								</tr>								<tr>									<td>产品 B</td>									<td>400</td>								</tr>							</table>						</li>						<li>							<a href="# ">京东会员 &nbsp; |</a>						</li>						<li>							<a href="# ">企业采购 &nbsp; |</a>						</li>						<li>							<a href="# ">客户服务 &nbsp; |</a>						</li>						<li>							<a href="# " id="nav_internet ">网站导航<b class="caret "></b> &nbsp; |</a>						</li>						<li>							<a href="# ">手机京东 &nbsp;</a>						</li>					</ul>				</nav>			</div>		</div>',
})

// 顶部top2
Vue.component('jd-top2', {
	data: function() {
		return {
			query: '曲面屏'
		}
	},
	props: ['top2_param1', 'top2_param2', 'lie'],
	template: '<div class="container top2">			<div class="row top2_fir" :style="top2_param1">				<div class="col-md-3 pull-left">					<img src="/img/jdlogo2.png" />				</div>				<div :class="lie">					<div class="col-md-10">						<input type="search" class="form-control"  style="border: solid 2px red;" v-model="query"/>					</div>					<div class="col-md-2">						<a href="#" class="btn btn-info btn-lg" id="sosuo" @click="fun">							<span class="glyphicon glyphicon-search"></span>搜索						</a>					</div>				</div>				<div class="col-md-2" :style="top2_param2">					<div>						<a href="#" class="btn btn-info btn-lg" id="cart" @click="forwardCard">							<span class="glyphicon glyphicon-shopping-cart"></span>我的购物车						</a>					</div>				</div>			</div>		</div>',
	methods: {
		fun() {
			sessionStorage.clear();
			sessionStorage.setItem('query', this.query);
			window.location.href = "/products.html";
		},
		forwardCard(){
			window.location.href = "/page/cart/list";
		}
	}
})

// 顶部top3
Vue.component('jd-top3', {
	props: ['top3_param'],
	template: '<div class="container top3">			<ul class="nav nav-pills" :style="top3_param">				<li id="alltypes">					<a href="#" style="color: white;font-weight:normal;">全部商品分类</a>				</li>				<li>					<a href="#">服装城</a>				</li>				<li>					<a href="#">美妆馆</a>				</li>				<li>					<a href="#">超市</a>				</li>				<li>					<a href="#">生鲜</a>				</li>				<li>					<a href="#">全球购</a>				</li>				<li>					<a href="#">闪购</a>				</li>				<li>					<a href="#">拍卖</a>				</li>				<li>					<a href="#">金融</a>				</li>			</ul>		</div>'
})

// 頂部中間
Vue.component('jd-top-middle', {
	props: ['topmiddle_layout','topmiddle_innner'],
	template: '<div class="container" :style="topmiddle_layout">				<div class="row">					<div class="col-md-3"></div>					<div class="col-md-8" :style="topmiddle_innner">						<ul class="nav nav-pills sosuoxia">							<li>								<a href="#">春新当young</a>							</li>							<li>								<a href="#">奇异果</a>							</li>							<li>								<a href="#">宝贝趴</a>							</li>							<li>								<a href="#">多买多折</a>							</li>							<li>								<a href="#">跨店4免1</a>							</li>							<li>								<a href="#">旅行红包</a>							</li>							<li>								<a href="#">规模养殖</a>							</li>						</ul>					</div>				</div>			</div>'
})