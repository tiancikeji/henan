<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../includes/head.jsp" %>
<div id="container">

	<div class="mod">

		<div class="hd cf">
			<h2>产品分发系统</h2>
			<div class="fr">
				<input class="btn btn-blue css3" type="button" value="创建第三方服务" onclick='window.location.href = "<c:url value='/distribution/otherserverform'/>";'/>
			</div>
		</div><!-- mod hd -->

    	<div class="bd">
    		<table class="table">
                <thead>
                    <tr>
                        <th><input type="checkbox" /> 服务ip</th>
                        <th>服务名称</th>
                        <th>服务目录</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="ftp" items="${ftplist}">
                    <tr>
                        <td><c:out value="${ftp.ftpIp }"/></td>
                        <td><c:out value="${ftp.ftpName }"/></td>
                        <td><c:out value="${ftp.ftpDir }"/></td>
                    </tr>   
                    </c:forEach>
                </tbody>
            </table>
    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>