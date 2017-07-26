<@demo.layout>
<h1>Blog管理 ---&gt; 修改Blog
</h1>
<a href="${base?if_exists}/blog">Blog列表</a>
<div class="form_box">
	<form action="${base?if_exists}/blog/update" method="post">
		<#include "_form.ftl" />
	</form>
</div>
</@demo.layout>