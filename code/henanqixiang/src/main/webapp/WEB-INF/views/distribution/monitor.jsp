<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../includes/head.jsp" %>
<div id="container">

	<div id="fullscreen" class="mod">

		<div class="hd cf">
			<h2>发送监控</h2>
			<div class="fr">
                <a class="requestfullscreen fullscreen-btn" href="#">全屏查看</a>
                <a class="exitfullscreen fullscreen-btn hidden" href="#">退出全屏</a>
				<input class="btn btn-blue css3" type="button" value="刷新" />
			</div>
		</div><!-- mod hd -->

    	<div class="bd">
    		<table class="table">
                <thead>
                    <tr>
                        <th><input type="checkbox" /> 文件名称</th>
                        <th>发送方式</th>
                        <th>发送时间</th>
                        <th>发送状态</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>   
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>                       
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>                        
                </tbody>
            </table>
    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>