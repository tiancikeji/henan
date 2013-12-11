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
                        <th>发送类型</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="dest" items="${destlist}">
                    <tr>
                        <td><c:out value="${dest.destIp}"/></td>
                        <td><c:out value="${dest.destName}"/></td>
                        <td><c:out value="${dest.destDir}"/></td>
                        <td><c:choose>
							<c:when test="${dest.sendType == 0}">
								自动
							</c:when>
							<c:otherwise>
								手动
							</c:otherwise>
                        </c:choose></td>
                        <td>激活中</td>
                        <td><a href="#">发送类型</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">状态</a></td>
                    </tr>   
                	</c:forEach>
                </tbody>
            </table>
    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>