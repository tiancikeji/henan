<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<li>信息发布
		<ul>
			<li><a href="<c:url value="/distribution/" />">产品分发系统</a></li>
			<li><a href="<c:url value="/distribution/monitor" />">发送监控</a></li>
			<li><a href="<c:url value="/distribution/current" />">当日发送文件结果记录</a></li>
			<li><a href="<c:url value="/distribution/config" />">定时设置</a></li>
		</ul>
	</li>
	<li>灾害性天气预报监测
		<ul>
			<li><a href="<c:url value="/weather?time=12" />">0-12小时</a></li>
			<li><a href="<c:url value="/weather?time=24" />">12-24小时</a></li>
			<li><a href="<c:url value="/weather?time=48" />">24-48小时</a></li>
			<li><a href="<c:url value="/weather?time=72" />">48-72小时</a></li>
		</ul>
	</li>
	<li>系统管理
		<ul>
			<li><a href="<c:url value="/system/users" />">用户管理</a></li>
			<li><a href="<c:url value="/system/roles" />">权限管理</a></li>
		</ul>
	</li>
	<li>黄河流域水文气象预报平台
		<ul>
			<li><a href="<c:url value="/gis/" />">流域实况</a></li>
			<li><a href="<c:url value="/gis/" />">历史雨量查询</a></li>
			<li><a href="<c:url value="/gis/" />">面雨量实况查询</a></li>
			<li><a href="<c:url value="/gis/" />">灾害预警</a></li>
			<li><a href="<c:url value="/gis/" />">水情信息</a></li>
			<li><a href="<c:url value="/gis/" />">雷达卫星</a></li>
			<li><a href="<c:url value="/gis/" />">数值产品</a></li>
			<li><a href="<c:url value="/gis/" />">黄河流域预报产品</a></li>
			<li><a href="<c:url value="/gis/" />">流域信息监控</a></li>
			<li><a href="<c:url value="/gis/" />">水文预报</a></li>
			<li><a href="<c:url value="/gis/" />">城市积涝预报</a></li>
			<li><a href="<c:url value="/gis/" />">流域气象风险灾害预警</a></li>
		</ul>
	</li>
</ul>