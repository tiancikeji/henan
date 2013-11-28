<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../includes/head.jsp" %>

<div id="container">

	<div class="mod">

		<div class="hd cf">
			<h2>添加目标服务器</h2>
		</div><!-- mod hd -->

    	<div class="bd">
    		<form action="<c:url value='/distribution/destcreate'/>" method="post">
    		<table class="form form-set">
                <tr>
                    <th>目标IP：</th>
                    <td>
                        <input class="ipt-txt ipt-l" type="text" name="destIp"/>
                    </td>
                </tr>
                <tr>
                    <th>目标名称：</th>
                    <td>
                        <input class="ipt-txt ipt-l" type="text" name="destName"/>
                    </td>
                </tr>
                <tr>
                    <th>目标目录：</th>
                    <td>
                        <input class="ipt-txt ipt-l" type="text" name="destDir"/>
                    </td>
                </tr>
                
            </table>
            <hr />
            <div class="ac">
                <input class="btn btn-blue css3" type="submit" value="添加" />
            </div>            
            </form>
    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>