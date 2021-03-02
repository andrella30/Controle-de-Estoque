<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Produto"%>
<%@ page import="java.util.ArrayList"%>
<%
String produto = request.getParameter("nome_produto");
String preco_unitario = request.getParameter("preco_unitario");
String unidade = request.getParameter("unidade");
String quantidade = request.getParameter("quantidade");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Controle de Estoque</title>
<link rel="stylesheet" href="editar_produto_view/style.css">
</head>
<body>
	<h1 style="text-align: center">Editar Produto</h1>
	<div style="text-align: center">

		<form name="frmEdicao" action="update_produto">
			<div style="text-align: center">
				<table id="tabela">
					<thead>
						<tr>
							<th>Nome Produto</th>
							<th>Preço</th>
							<th>Unidade</th>
							<th>Quantidade</th>
						</tr>
					</thead>



					<tbody>
						<tr>
							<td><%=produto%></td>
							<td><%=preco_unitario%></td>
							<td><%=unidade%></td>
							<td><%=quantidade%></td>
						</tr>

					</tbody>
				</table>
			</div>

			<table class="table_center">
				<tr>
					<td><input type="number" name="preco" placeholder="Preço"
						class="Caixa1" min="0" pattern="^[1-9]\d*$"></td>
				</tr>
				<tr>
					<td><input type="text" name="unidade"
						placeholder="Unidade de Medida" class="Caixa1"></td>
				</tr>
				<tr>
					<td><input type="number" name="quantidade"
						placeholder="Quantidade de produto" class="Caixa1" min="0" pattern="^[1-9]\d*$"></td>
				</tr>

			</table>
			<input type="button" class="Botao1" value="Editar"
				onclick="validar()">
		</form>
	</div>

	<script src="scripts/validador_edicao.js">
		
	</script>
</body>
</html>