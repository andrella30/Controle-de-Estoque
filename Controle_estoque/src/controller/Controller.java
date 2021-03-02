package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;
import model.ProdutoDAO;

@WebServlet(urlPatterns = { "/Controller", "/main", "/cadastrar_produto", "/editar_produto", "/update_produto",
		"/deletar_produto", "/movimentar_produto", "/update_movimentacao", "/reajuste_produto", "/update_reajuste",
		"/gerar_relatorio" })

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoDAO dao = new ProdutoDAO();
	Produto produto = new Produto();

	public Controller() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);

		switch (action) {
		case "/main":
			menu(request, response);
			break;
		case "/cadastrar_produto":
			cadastroProduto(request, response);
			break;
		case "/editar_produto":
			editarProduto(request, response);
			break;
		case "/update_produto":
			updateProduto(request, response);
			break;
		case "/deletar_produto":
			deleteProduto(request, response);
			break;
		case "/movimentar_produto":
			movimentacaoProduto(request, response);
			break;
		case "/update_movimentacao":
			updateMovimentacaoProduto(request, response);
			break;
		case "/reajuste_produto":
			reajusteProduto(request, response);
			break;
		case "/update_reajuste":
			updateReajuste(request, response);
			break;
		case "/gerar_relatorio":
			gerarRelatorio(request, response);
			break;
		default:
			menu(request, response);
			break;
		}

	}

	protected void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Produto> lista = dao.listarProdutos();

		request.setAttribute("produto", lista);
		RequestDispatcher rd = request.getRequestDispatcher("menu_produto_view/menu.jsp");
		rd.forward(request, response);

	}

	// Create (cadastrar produto)
	protected void cadastroProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar variaveis em produto
		produto.setNome_produto(request.getParameter("nome"));
		produto.setPreco_unitario(Float.parseFloat(request.getParameter("preco")));
		produto.setUnidade_medida((request.getParameter("unidade")));
		produto.setQuantidade_estoque(Integer.parseInt(request.getParameter("quantidade")));

		Float valor_total = Float.parseFloat(request.getParameter("preco"))
				* Integer.parseInt(request.getParameter("quantidade"));
		produto.setValor_total_estoque(valor_total);

		dao.inserirProduto(produto);
		response.sendRedirect("main");
	}

	// Update (editar produto)
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome_produto = request.getParameter("nome_produto");
		produto.setNome_produto(nome_produto);

		Produto existeProduto = dao.getProduto(nome_produto);
		RequestDispatcher rd = request.getRequestDispatcher("editar_produto_view/editar_produto.jsp");
		request.setAttribute("produto", existeProduto);
		rd.forward(request, response);
	}

	protected void updateProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		produto.setPreco_unitario(Float.parseFloat(request.getParameter("preco")));
		produto.setUnidade_medida((request.getParameter("unidade")));
		produto.setQuantidade_estoque(Integer.parseInt(request.getParameter("quantidade")));

		Float valor = Float.parseFloat(request.getParameter("preco"))
				* Integer.parseInt(request.getParameter("quantidade"));
		produto.setValor_total_estoque(valor);

		dao.atualizarProduto(produto);
		response.sendRedirect("main");
	}

	// Delete (deletar produto)
	protected void deleteProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome_produto = request.getParameter("nome_produto");
		produto.setNome_produto(nome_produto);
		dao.deletarProduto(produto);
		response.sendRedirect("main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	// Movimentação
	protected void movimentacaoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome_produto = request.getParameter("nome_produto");
		produto.setNome_produto(nome_produto);
		System.out.println(produto.getNome_produto());

		String preco_unitario = request.getParameter("preco_unitario");
		produto.setPreco_unitario(Float.parseFloat(preco_unitario));
		System.out.println(produto.getPreco_unitario());

		Produto existeProduto = dao.getProduto(nome_produto);
		RequestDispatcher rd = request.getRequestDispatcher("movimentacao_produto_view/movimentacao.jsp");
		request.setAttribute("produto", existeProduto);
		rd.forward(request, response);

	}

	protected void updateMovimentacaoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipo = request.getParameter("submit");

		String quantidade = request.getParameter("quantidade");

		produto.setQuantidade_estoque(Integer.parseInt(quantidade));

		if (tipo.equals("Adicionar")) {
			System.out.println("Add");
			dao.movimentacaoAddProduto(produto);
			response.sendRedirect("main");
		} else if (tipo.equals("Remover")) {
			System.out.println("Rem");
			dao.movimentacaoRemoveProduto(produto);
			response.sendRedirect("main");
		}

	}

	// Reajuste
	protected void reajusteProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome_produto = request.getParameter("nome_produto");
		produto.setNome_produto(nome_produto);


		produto.setQuantidade_estoque(Integer.parseInt(request.getParameter("quantidade")));


		Produto existeProduto = dao.getProduto(nome_produto);
		RequestDispatcher rd = request.getRequestDispatcher("reajuste_produto_view/reajuste.jsp");
		request.setAttribute("produto", existeProduto);
		rd.forward(request, response);

	}

	protected void updateReajuste(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		produto.setPreco_unitario(Float.parseFloat(request.getParameter("preco")));
		

		dao.reajustePreco(produto);
		response.sendRedirect("main");

	}

	// Gerar Relatorio
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Produto> lista = dao.listarProdutos();
		ArrayList<Float> valor_unitario = dao.valorUnitarioProduto(produto);
		ArrayList<Float> sum_produtos = dao.valorTotalProduto(produto);

		response.setContentType("application/pdf");

		try {
			Document document = new Document();
			PdfWriter.getInstance(document, response.getOutputStream());

			document.open();

			Paragraph pCabecalho = new Paragraph();
			pCabecalho.add(new Phrase("RELATÓRIO"));
			pCabecalho.setAlignment(Element.ALIGN_CENTER);
			document.add(pCabecalho);

			Paragraph pListagem = new Paragraph();
			document.add(new Phrase(Chunk.NEWLINE));
			pListagem.add(new Phrase("Relátório Lista de Preço"));
			pListagem.setAlignment(Element.ALIGN_CENTER);
			document.add(pListagem);
			document.add(new Phrase(Chunk.NEWLINE));

			PdfPTable table = new PdfPTable(5);

			table.addCell("Nome");
			table.addCell("Preço");
			table.addCell("Unidade Medida");
			table.addCell("Quantidade");
			table.addCell("Preço Total");

			for (int i = 0; i < lista.size(); i++) {
				table.addCell(lista.get(i).getNome_produto());
				table.addCell(String.valueOf(lista.get(i).getPreco_unitario()));
				table.addCell(lista.get(i).getUnidade_medida());
				table.addCell(String.valueOf(lista.get(i).getQuantidade_estoque()));
				table.addCell(String.valueOf(lista.get(i).getValor_total_estoque()));
			}

			document.add(table);

			Paragraph pBalanco = new Paragraph();
			document.add(new Phrase(Chunk.NEWLINE));
			pBalanco.add(new Phrase("Relatório Balanço Financeiro"));
			pBalanco.setAlignment(Element.ALIGN_CENTER);
			document.add(pBalanco);
			document.add(new Phrase(Chunk.NEWLINE));

			PdfPTable table1 = new PdfPTable(3);

			table1.addCell("Nome");
			table1.addCell("Quantidade");
			table1.addCell("Valor Total");

			for (int i = 0; i < valor_unitario.size(); i++) {
				table1.addCell(lista.get(i).getNome_produto());
				table1.addCell(String.valueOf(lista.get(i).getQuantidade_estoque()));
				table1.addCell(valor_unitario.get(i).toString());
			}

			document.add(table1);
			document.add(new Phrase(Chunk.NEWLINE));

			Paragraph pBalancoFinal = new Paragraph();
			pBalancoFinal.add(new Phrase("Balanço Financeiro: "));
			pBalancoFinal.add(new Phrase(sum_produtos.get(0).toString()));
			pBalancoFinal.setAlignment(Element.ALIGN_CENTER);
			document.add(pBalancoFinal);

			document.close();
		} catch (DocumentException e) {
			System.out.println(e);
		}
	}

}
