<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>流域水况</title>
	    <link rel="stylesheet" type="text/css" href="http://localhost:2000/arcgis_js_api/library/3.5/3.5/js/dojo/dijit/themes/tundra/tundra.css"/>
    <link rel="stylesheet" type="text/css" href="http://localhost:2000/arcgis_js_api/library/3.5/3.5/js/esri/css/esri.css" />
    <script type="text/javascript" src="http://localhost:2000/arcgis_js_api/library/3.5/3.5/init.js"></script>

    <script type="text/javascript">

      dojo.require("esri.map");

      function init() {
        var myMap = new esri.Map("mapDiv");
        //note that if you do not have public Internet access then you will need to point this url to your own locally accessible cached service.

        var myTiledMapServiceLayer = new esri.layers.ArcGISTiledMapServiceLayer("http://server.arcgisonline.com/ArcGIS/rest/services/NGS_Topo_US_2D/MapServer");

        myMap.addLayer(myTiledMapServiceLayer);

      }

      dojo.addOnLoad(init);

    </script>
	
</head>
<body>
<%@include file="../includes/menu.jsp" %>

  <body class="tundra">
    <div id="mapDiv" style="width:900px; height:600px; border:1px solid #000;"></div>

  </body>
</body>
</html>
