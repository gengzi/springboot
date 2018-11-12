<html lang="zh-CN"> 
<head>
  <meta charset="UTF-8">
  <title>欢迎</title>
</head>
<body>
  <#--<h1 style="color:red" >演示#if标签:<h1>-->
  <#--<h1>欢迎 ${name} <#if name == "耿帅佳" >我们亲爱的朋友</#if> !</h1>  &lt;#&ndash; 注释：字符串需要添加 “” 引号  &ndash;&gt;-->
  <#--<h2>您的年龄 <#if age == 22 >已经大于18岁了，可以访问本网站了。</#if> !</h2>-->
  <#---->
   <#--<h1>欢迎 ${object1.name} -->
   		<#--<#if object1.name == "耿帅佳" >-->
   			<#--我们亲爱的朋友-->
   			<#--<#elseif object1.name == "张娟">-->
   			<#--我们的小仙女呀-->
   			<#--<#else>-->
   			<#--亲爱的网友啊-->
   		<#--</#if> -->
   		<#--!-->
   	<#--</h1> -->
  <#--<h2> ${object1.name} 的年龄 <#if object1.age gte 22 >已经大于18岁了，可以访问本网站了。</#if> !</h2> -->
  <#--&lt;#&ndash; 注释：其中的大于等于 gte 小于等于 lte  大于 gt 小于 lt  &ndash;&gt;-->
  <#---->
  <#---->
  <#--<h1 style="color:red">演示#list标签:<h1>-->
  <#--<table border=1>-->
	  <#--<#list object1.username as username >-->
	    <#--<tr>-->
	    	<#--<td>${username}</td>-->
	    <#--<tr>-->
	  <#--</#list>-->
 <#--</table>-->
 <#---->
   <#--<table border=1>-->
	 	<#--<tr>-->
	 		<#--<th>爱好名称</th>-->
	 		<#--<th>爱好程度</th>-->
	 	<#--</tr>-->
	  <#--<#list object1.hobbys>      &lt;#&ndash; 注释：list 被标识为一个整体&ndash;&gt;-->
	  	<#--<#items as hobby>         &lt;#&ndash; 注释：items的部分才会被循环&ndash;&gt;-->
		    <#--<tr>-->
		    	<#--<td>${hobby.hobbyname}</td>-->
		    	<#--<td>${hobby.hobbylike}</td>-->
		    <#--<tr>-->
	    <#--</#items>-->
	  <#--</#list>-->
 <#--</table>-->
 <#---->
 <#--<h1 style="color:red">演示list - #sep标签:<h1>-->
 <#--<p>爱好: <#list object1.hobbys as hobby>${hobby.hobbyname}<#sep>, </#list></p>-->
  <#---->
 <#--<h1 style="color:red">演示list - #else标签:<h1>-->
 <#--<p>爱好: <#list object1.hobbys as hobby>${hobby.hobbyname}<#sep>,</#sep><#else> 没有爱好哈哈哈 </#list></p>-->
  <#---->
 <#---->
 <#--<h1 style="color:red">演示处理不存在的变量<h1>-->
 <#--<h1>欢迎 ${user!"大家"}!</h1>-->
 <#--<h1>欢迎 ${name!"大家"}!</h1>-->
  <#---->
  <#---->
 <#--<#if user??>-->
 	<#--<h1>欢迎 ${user}!</h1>-->
 	<#--<#else>-->
 	<#--<h1>欢迎 大家!</h1>	-->
 <#--</#if>-->

  <#---->
  <#---->
  <#--<p>主页:-->
  <#--<a href="http://gsjblog.club/GsjBlog">我的主页</a>!-->


	  ${result}
  
  
  <#include "/footer.html">
  

</body>
</html>