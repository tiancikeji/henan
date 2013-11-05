<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../includes/head.jsp" %>

<div id="container">

	<div class="mod">

		<div class="hd cf">
			<h2>定时设置</h2>
		</div><!-- mod hd -->

    	<div class="bd">
    		<table class="form form-set">
                <tr>
                    <th>发送地址：</th>
                    <td>
                        <input class="ipt-txt ipt-l" type="text" />
                        <span><a href="#">添加地址</a></span>
                    </td>
                </tr>
                <tr>
                    <th>发送方式：</th>
                    <td>
                        <label for="sFTP"><input id="sFTP" type="checkbox" /> FTP</label>
                        <label for="sNOTES"><input id="sNOTES" type="checkbox" /> NOTES</label>
                        <label for="sEMAIL"><input id="sEMAIL" type="checkbox" /> EMAIL</label>
                        <label for="sFAX"><input id="sFAX" type="checkbox" /> 传真</label>               
                    </td>
                </tr>
                <tr>
                    <th>发送时间：</th>
                    <td>
                        <select class="select ipt-l">
                            <option>小时</option>   
                        </select>
                        <select class="select ipt-l">
                            <option>分钟</option>   
                        </select>                        
                    </td>
                </tr>
                <tr>
                    <th>本地文件地址：</th>
                    <td>
                        <select class="select ipt-l">
                            <option>请选择...</option>   
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>文件通配符：</th>
                    <td>
                        <select class="select ipt-l">
                            <option>请选择...</option>   
                        </select>
                    </td>
                </tr>                                                       
            </table>
            <hr />
            <div class="ac">
                <input class="btn btn-blue css3" type="button" value="手动发送" />
                <input class="btn btn-gray css3" type="button" value="取消" />
            </div>            
    	</div><!-- mod bd -->

	</div><!-- mod -->

</div><!-- //container -->
</body>
</html>