<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Produto"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Produto> lista = (ArrayList<Produto>) request.getAttribute("produto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Controle de Estoque</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
	<header class="cabecalho">
		<h1 style="text-align: center">Controle de Estoque</h1>
	</header>

	<div style="text-align: center">
		<h1></h1>
		<a href="cadastro_produto.html" class="Botao1"> Cadastrar Produto
		</a>
		 <a href="gerar_relatorio" class="Botao1"> Relatórios
		</a>
	</div>

	<div style="text-align: center">
		<table id="tabela">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Preço</th>
					<th>Unidade</th>
					<th>Quantidade</th>
					<th>Preço Total</th>
					<th style="text-align: center">Opções</th>
				</tr>
			</thead>

			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>

					<td><%=lista.get(i).getNome_produto()%></td>
					<td><%=lista.get(i).getPreco_unitario()%></td>
					<td><%=lista.get(i).getUnidade_medida()%></td>
					<td><%=lista.get(i).getQuantidade_estoque()%></td>
					<td><%=lista.get(i).getValor_total_estoque()%></td>
					<td><a
						href="editar_produto?nome_produto=<%=lista.get(i).getNome_produto()%>"
						class="Botao1"> Editar </a> <a
						href="deletar_produto?nome_produto=<%=lista.get(i).getNome_produto()%>"
						class="BotaoDelet" onclick="validar_delecao()"> Deletar </a> <a
						href="movimentar_produto?nome_produto=<%=lista.get(i).getNome_produto()%>&preco_unitario=<%=lista.get(i).getPreco_unitario()%>"
						class="Botao1"> Movimentação </a> <a
						href="reajuste_produto?nome_produto=<%=lista.get(i).getNome_produto()%>&quantidade=<%=lista.get(i).getQuantidade_estoque()%>"
						class="Botao1"> Reajuste </a></td>

				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<script src="scripts/validar_delecao.js"></script>
</body>
</html>