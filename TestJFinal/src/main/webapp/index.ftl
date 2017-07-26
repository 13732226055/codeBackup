<@demo.layout>
<h1>JFinal Demo 项目首页</h1>
<div class="table_box">
	<p>欢迎来到 JFinal极速开发世界！</p>
	
	<br><br><br>
	
	本Demo采用FreeMarker 作为视图文件，您还可以使用Jsp、Velocity或自定义类型视图。
	点击<a href="${base?if_exists}/blog"><b>此处</b></a>开始试用Demo。
	<br><br><br>
	<a href="javascript:void(0);" onclick="testJson()">测试renderJson</a>
	<br><br><br>
	<a href="${base?if_exists}/testInterceptorStack">测试testInterceptorStack</a>
	<br><br><br>
	<a href="${base?if_exists}/blog/testTx">测试事务</a>
	<br><br><br>
	<a href="${base?if_exists}/blog/testTxByAnnoation">测试声明式事务</a>
	
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</div>
<script language="javascript">
	function testJson(){
		$.ajax({
	        url : '${base?if_exists}/testJson',
	        data:{'a':1,'b':'中文'},
	        cache : false, 
	        async : true,
	        type : "POST",
	        dataType: 'json',
	        success : function (result){
	      		alert(result.b);
	        }
	    });	
	}
</script>
</@demo.layout>