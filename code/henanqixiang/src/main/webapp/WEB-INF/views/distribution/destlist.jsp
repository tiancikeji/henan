<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../includes/head.jsp" %>
<div id="container">

	<div class="mod">

		<div class="hd cf">
			<h2>目标服务器列表</h2>
		</div><!-- mod hd -->

    	<div class="bd">
    		<table class="table">
                <thead>
                    <tr>
                        <th>IP</th>
                        <th>名称</th>
                        <th>目录</th>
                        <th>创建时间</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="dest" items="${destlist}">
                    <tr>
                        <td><c:out value="${dest.destIp}"/></td>
                        <td><c:out value="${dest.destName}"/></td>
                        <td><c:out value="${dest.destDir}"/></td>
                        <td>5</td>
                    </tr>   
                	</c:forEach>
                </tbody>
            </table>
    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>