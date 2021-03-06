<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ include file="../includes/head.jsp" %>

<div id="container">

	<div class="mod">

		<div class="hd cf">
			<h2>0-12小时 灾害性天气预报监测</h2>
			<div class="fr">
                <ul class="toolbar fl">
                    <li><strong>工具栏：</strong></li>
                    <li><a class="icon-toolbar icon-toolbar1" href="#">1</a></li>
                    <li><a class="icon-toolbar icon-toolbar2" href="#">2</a></li>
                    <li><a class="icon-toolbar icon-toolbar3" href="#">3</a></li>
                    <li><a class="icon-toolbar icon-toolbar4" href="#">4</a></li>
                </ul>
                <input class="btn btn-blue css3" type="button" value="保存" />
			</div>
		</div><!-- mod hd -->

    	<div class="bd grid-elastic">
    		
            <div class="grid-170">
                <div class="sidebar">
                    <h3>灾害类型</h3>
                    <ul class="menu">
                        <li class="mactive"><a href="#">冰雹</a></li>
                        <li><a href="#">雷暴</a></li>
                        <li><a href="#">冻雨</a></li>
                        <li><a href="#">霜冻</a></li>
                        <li><a href="#">雾</a></li>
                        <li><a href="#">雪</a></li>
                        <li><a href="#">雨</a></li>
                        <li><a href="#">沙尘暴</a></li>
                        <li><a href="#">大风</a></li>
                        <li><a href="#">高温</a></li>
                        <li><a href="#">降温</a></li>
                    </ul>
                    <p class="btn-wrap1">
                        <input class="btn btn-blue css3" type="button" value="+ 添加灾害类型" />
                    </p>
                </div>
            </div><!-- sidebar -->

            <div class="wrapper">
                <div class="main bg-map">
                    <iframe src="http://win-79hpgpn66b4/ArcGIS/rest/services/weather1/MapServer?f=jsapi" width="100%" height="800px">
                    </iframe>
                </div>
            </div><!-- main -->

    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>