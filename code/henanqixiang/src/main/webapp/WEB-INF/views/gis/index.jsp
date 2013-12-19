<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../includes/head.jsp" %>
<div id="container">
	<div class="mod">

		<div class="hd cf">
			<h2>流域实况</h2>
            <ul id="Tabs1" class="tabs fl">
                <li><a href="#">雨量显示</a></li>
                <li><a href="#">温度实况</a></li>
            </ul>
			<div class="fr">
                <input class="btn btn-blue css3" type="button" value="刷新" />
                <input class="btn btn-blue css3" type="button" value="导出" />
                <input class="btn btn-blue css3" type="button" value="储存" />
			</div>
		</div><!-- mod hd -->

    	<div class="bd grid-elastic">
    		
            <div class="grid-170">
                <div class="sidebar">
                    <h3>逐小时</h3>
                    <ul class="menu">
                        <li class="mactive"><a href="#">3小时</a></li>
                        <li><a href="#">6小时</a></li>
                        <li><a href="#">12小时</a></li>
                        <li><a href="#">24小时</a></li>
                    </ul>
                </div>
            </div><!-- sidebar -->

            <div class="wrapper">
                <div class="main bg-map panes">
                    <div>
                        <div id="mapDiv" style="width:900px; height:600px; border:1px solid #000;"></div>
                    </div>
                </div>
            </div><!-- main -->

    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
    

 
  <link rel="stylesheet" type="text/css" href="http://localhost:2000/arcgis_js_api/library/3.5/3.5/js/dojo/dijit/themes/tundra/tundra.css"/>
    <link rel="stylesheet" type="text/css" href="http://localhost:2000/arcgis_js_api/library/3.5/3.5/js/esri/css/esri.css" />
   
   <script type="text/javascript" src="http://localhost:2000/arcgis_js_api/library/3.5/3.5/init.js"></script>

    <script type="text/javascript">

      dojo.require("esri.map");

      function init() {
        var myMap = new esri.Map("mapDiv");
        //note that if you do not have public Internet access then you will need to point this url to your own locally accessible cached service.
		var layer = "http://server.arcgisonline.com/ArcGIS/rest/services/NGS_Topo_US_2D/MapServer";
        //var layer = "http://win-79hpgpn66b4/ArcGIS/rest/services/world/MapServer";
        var layer1 = "http://win-79hpgpn66b4/ArcGIS/rest/services/yellowriver/MapServer";
	    var myTiledMapServiceLayer = new esri.layers.ArcGISTiledMapServiceLayer(layer1);

        myMap.addLayer(myTiledMapServiceLayer);

      }

      dojo.addOnLoad(init);

    </script>
     </body>
</html>
