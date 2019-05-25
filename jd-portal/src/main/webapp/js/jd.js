/**
 * 由于前期前端页面没有想好用什么技术，搞得页面混乱 现在用jQuery添加几个公用方法
 */
// server配置
const SSO_SERVER = 'http://localhost:8085';
const ORDER_SERVER='http://localhost:8087';
var JD = {
	checkLogin: function() {
		var user;
		var token = JD.getCookie("token");
		if(!token) {
			debugger;
			return;
		}
		fetch(SSO_SERVER + '/sso/user/token/' + token, {
				method: 'GET',
				headers: {
					"Content-Type": "application/x-www-form-urlencoded"
				}
			})
			.then(function(response) {
				return response.json();
			}).then(function(data) {
				if(data.status == 200) {
					var username = data.data.username;
					$("#login_name").html('<a href="javascript:;">'+username+' &nbsp; &nbsp;</a>');
					$("#login_state").html('<a href="javascript:JD.quite();" style="color: red;">退出 &nbsp; &nbsp;|</a>');
					user=data.data;
				}
				user=data.data;
			}).catch(function(e) {
				console.log("Oops, error");
			});
		debugger;
		return user;
	},
	login: function() {
		window.location.href = SSO_SERVER+'/page/login';
	},
	
	registe:function(){
		window.location.href = SSO_SERVER+'/page/registe';
	},
	myorder:function(){
		window.location.href='/orderlist.html';
	},	
	getIndex:function(){
		window.location.href='/main.html';
	},
	myCart:function(){
		window.location.href = "/page/cart/list";
	},
	getCookie:function(name){
		var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
		if(arr=document.cookie.match(reg))
			return unescape(arr[2]);
		else
			return null;
	},
	quite:function(){
		fetch('http://localhost:8085/sso/user/quite/'+JD.getCookie("token"), {
			method: 'POST',
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			}
		})
		.then(function(response) {
			return response.json();
		}).then(function(data) {
			if(data.status==200){
				window.location="http://localhost:8085/page/login";
			}else{
				alert("出现问题");
			}
		}).catch(function(e) {
			console.log("Oops, error");
			debugger;
		});
	}
	
}

$(function() {
	// 查看是否已经登录，如果已经登录查询登录信息
	JD.checkLogin();
});