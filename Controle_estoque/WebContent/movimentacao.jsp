<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Produto"%>
<%@ page import="java.util.ArrayList"%>
<%
String produto = request.getParameter("nome_produto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Controle de Estoque</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 style="text-align: center">Movimentação</h1>


	<div style="text-align: center">
		<form name="frmMovimentacao" action="update_movimentacao">
			<div style="text-align: center">
				<table id="tabela">
					<thead>
						<tr>
							<th>Nome Produto</th>
						</tr>
					</thead>



					<tbody>
						<tr>
							<td><%=produto%></td>
						</tr>

					</tbody>
				</table>
			</div>


			<table class="table_center">
				<tr>
					<td><input type="number" name="quantidade"
						placeholder="Quantidade de produto" class="Caixa1" min="0" pattern="^[1-9]\d*$"></td>
				</tr>

			</table>

			<input type="submit" name="submit" class="Botao1" value="Adicionar"
				onclick="validar_movimentacao()"> <input type="submit"
				name="submit" class="Botao1" value="Remover"
				onclick="validar_movimentacao()">


		</form>
	</div>
	<script src="scripts/validar_movimentacao.js"></script>

</body>
</html>