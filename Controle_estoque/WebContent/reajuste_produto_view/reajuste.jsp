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
<link rel="stylesheet" href="reajuste_produto_view/style.css">
</head>
<body>
	<h1 style="text-align: center">Reajuste de Preço</h1>




	<div style="text-align: center">
		<form name="frmReajuste" action="update_reajuste">
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
					<td><span> <input type="number" name="preco"
							placeholder="Valor" class="Caixa1"> %
					</span></td>
				</tr>

			</table>


			<input type="button" name="button" class="Botao1" value="Reajustar"
				onclick="validar_reajuste()">

		</form>
	</div>
	<script src="scripts/validar_reajuste.js"></script>
</body>
</html>