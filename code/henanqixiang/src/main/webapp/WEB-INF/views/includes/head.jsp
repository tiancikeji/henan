<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--[if IE 6]><html class="ie6 ielt9 no-css3 no-js lte7" lang="en" dir="ltr"><![endif]-->
<!--[if IE 7]><html class="ie7 ielt9 no-css3 no-js lte7" lang="en" dir="ltr"><![endif]-->
<!--[if IE 8]><html class="ie8 ielt9 no-css3 no-js" lang="en" dir="ltr"><![endif]-->
<!--[if IE 9]><html class="ie9 ielt9 no-css3 no-js" lang="en" dir="ltr"><![endif]-->
<!--[if !(IE 6) | !(IE 7) | !(IE 8) | !(IE 9) ]><!--><html lang="en" dir="ltr" class="no-js"><!--<![endif]-->
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>河南省气象预报综合业务平台</title>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="<c:url value="/resources/css/reset.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/screen.css"/>" />
<!--[if IE]>
<script src="js/ie/html5.js"></script>
<![endif]-->
<!--[if lt IE 9]>
<style type="text/css">.css3{behavior: url(js/ie/css3.htc);-pie-lazy-init: true; position: relative;}.ie6png{-pie-png-fix: true;}</style>
<script src="js/ie/ie9.js"></script>
<![endif]-->
<!--[if IE 6]>
<script src="js/ie/png.js"></script>
<script>DD_belatedPNG.fix('.pngfix, .pngfix img, #logo img, #nav');</script>
<![endif]-->
<script src="<c:url value="/resources/js/ie/modernizr.js"/>"></script>
<script src="<c:url value="/resources/js/jquery/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/jquery/jquery.tools.min.js"/>"></script>
<script>
$(function() {
	// 导航切换
	$("#nav ul").tabs("div.subnav", {event:'mouseover'});
});
</script>

</head>
<body>
<div class="wrap-header">
	<header id="header" class="cf">
		<div class="cf">

			<h1 id="logo">
				<a href="index.html">
					<img src="<c:url value="/resources/images/logo.png"/>" alt="河南省气象预报综合业务平台" title="河南省气象预报综合业务平台" />
				</a>
			</h1><!-- logo -->

			<ul id="user-bar" class="font-white link-white">
				<li id="localTime"><script src="<c:url value="/resources/js/localtime.js"/>"></script></li>
				<li><a href="sys-user.html">王小丽</a></li>
				<li>|</li>
				<li><a href="index.html">安全退出</a></li>
				<li>|</li>
				<li><a href="psw.html">密码</a></li>
			</ul><!-- user bar -->

		    <nav id="nav">
		    	<ul class="cf">
		    		<li><span>信息发布</span></li>
		    		<li><span>灾害性天气预报监测</span></li>
		    		<li><span>系统管理</span></li>
		    		<li><span>黄河流域水文气象预报平台</span></li>
		    	</ul>
		    </nav><!-- nav -->

	    </div>

	    <div class="subnav cf">
    		<ul>
    			<li class="active"><a href="<c:url value="/distribution"/>">产品分发系统</a></li>
    			<li><a href="<c:url value="/distribution/monitor"/>">发送监控</a></li>
    			<li><a href="<c:url value="/distribution/current"/>">当日发送文件结果记录</a></li>
    			<li><a href="<c:url value="/distribution/config"/>">定时设置</a></li>
    		</ul>
    	</div>
    	<div class="subnav cf">
    		<ul>
    			<li><a href="<c:url value="/weather"/>">0-12小时</a></li>
    			<li><a href="disaster-2.html">12-24小时</a></li>
    			<li><a href="disaster-3.html">24-48小时</a></li>
    			<li><a href="disaster-4.html">48-72小时</a></li>                               
    		</ul>
    	</div>
    	<div class="subnav cf">
    		<ul>
    			<li><a href="sys-user.html">用户管理</a></li>
    			<li><a href="sys-privileges.html">权限管理</a></li>                             
    		</ul>    		              
    	</div>
    	<div class="subnav cf">
    		<ul>
    			<li><a href="<c:url value="/gis" />">流域实况</a></li>
    			<li><a href="hydro-rainfall-history.html">历史雨量查询</a></li>
    			<li><a href="hydro-rainfall-scene.html">面雨量实况查询</a></li>
    			<li><a href="hydro-warning-disaster.html">灾害预警</a></li>
    			<li><a href="hydro-regimen.html">水情信息</a></li>
    			<li><a href="hydro-radarsat.html">雷达卫星</a></li>
    			<li><a href="hydro-pro-numerical.html">数值产品</a></li>
    			<li><a href="hydro-pro-forecast.html">黄河流域预报产品</a></li>
    			<li><a href="hydro-monitoring.html">流域信息监控</a></li>
    			<li><a href="hydro-forecast-hydrologic.html">水文预报</a></li>
    			<li><a href="hydro-forecast-waterlogging.html">城市积涝预报</a></li>
    			<li><a href="hydro-warning-weather.html">流域气象风险灾害预警</a></li>                                          
    		</ul>   
    	</div><!-- sub nav -->

	</header>
</div><!-- //header -->