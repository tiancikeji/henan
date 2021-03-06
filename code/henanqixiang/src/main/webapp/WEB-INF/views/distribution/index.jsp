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
				<input class="btn btn-blue css3" type="button" value="刷新" />
				<input class="btn btn-blue css3" type="button" value="手动发送" />
			</div>
		</div><!-- mod hd -->

    	<div class="bd">
    		<table class="table">
                <thead>
                    <tr>
                        <th><input type="checkbox" /> 文件名称</th>
                        <th>文件来源</th>
                        <th>创建时间</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="file" items="${filelist}">
                    <tr>
                        <td><c:out value="${file.fileName }"/></td>
                        <td><c:out value="${file.destName }"/></td>
                        <td></td>
                    </tr>   
                    </c:forEach>
                </tbody>
            </table>
    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>