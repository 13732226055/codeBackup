<@demo.layout>
	<h1>Blog管理&nbsp;&nbsp;
	<a href="${base?if_exists}/blog/add">创建Blog</a>
	</h1>
	<div class="table_box">
		<table class="list">
			<tbody>
				<tr>
					<th width="4%">id</th>
					<th width="35%">标题</th>
					<th width="12%">操作</th>
				</tr>
				
				<#list blogPage.getList() as x>
				<tr>
					<td style="text-align:left;">${x.id}</td>
					<td style="text-align:left;">${x.title}</td>
					<td style="text-align:left;">
						&nbsp;&nbsp;<a href="${base?if_exists}/blog/delete/${x.id}">删除</a>
						&nbsp;&nbsp;<a href="${base?if_exists}/blog/edit/${x.id}">修改</a>
					</td>
				</tr>
				</#list>
			</tbody>
		</table>
	<@demo.paginate currentPage=blogPage.pageNumber totalPage=blogPage.totalPage actionUrl="${base?if_exists}/blog/" />
</div>
</@demo.layout>
