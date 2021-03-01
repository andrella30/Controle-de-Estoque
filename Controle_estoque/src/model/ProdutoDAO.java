package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/controle_estoque?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "root";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// Create (inserir produto)
	public void inserirProduto(Produto produto) {
		String create = "insert into produto (nome_produto, preco_unitario, unidade_medida, quantidade_estoque, preco_total) values (?,?,?,?,?) ";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getNome_produto());
			pst.setFloat(2, produto.getPreco_unitario());
			pst.setString(3, produto.getUnidade_medida());
			pst.setInt(4, produto.getQuantidade_estoque());
			pst.setFloat(5, produto.getValor_total_estoque());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Read (listar produtos)
	public ArrayList<Produto> listarProdutos() {
		ArrayList<Produto> produto = new ArrayList<>();
		String read = "select * from produto order by nome_produto";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String nome_produto = rs.getString(1);
				float preco_unitario = rs.getFloat(2);
				String unidade_medida = rs.getString(3);
				int quantidade_estoque = rs.getInt(4);
				float preco_total = rs.getFloat(5);

				produto.add(new Produto(nome_produto, preco_unitario, unidade_medida, quantidade_estoque, preco_total));
			}
			con.close();
			return produto;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Update (atualizar produto)
	public void atualizarProduto(Produto produto) {
		String update = "update produto set preco_unitario = ?, unidade_medida=?, quantidade_estoque=?, preco_total=?";
		update += " where nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);

			pst.setFloat(1, produto.getPreco_unitario());
			pst.setString(2, produto.getUnidade_medida());
			pst.setInt(3, produto.getQuantidade_estoque());
			pst.setFloat(4, produto.getValor_total_estoque());
			pst.setString(5, produto.getNome_produto());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Delete (deletar produto)
	public void deletarProduto(Produto produto) {
		String delete = "DELETE FROM produto where nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getNome_produto());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Movimentacao Adicionar
	public void movimentacaoAddProduto(Produto produto) {
		String mov = "update produto set quantidade_estoque = quantidade_estoque + ? where nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(mov);

			pst.setInt(1, produto.getQuantidade_estoque());
			pst.setString(2, produto.getNome_produto());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		String mov_total = "update produto set preco_total = quantidade_estoque  * ? where nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(mov_total);

			// pst.setInt(1, produto.getQuantidade_estoque());
			pst.setFloat(1, produto.getPreco_unitario());
			pst.setString(2, produto.getNome_produto());

			System.out.println(produto.getPreco_unitario());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Movimentacao Remover
	public void movimentacaoRemoveProduto(Produto produto) {
		String mov = "update produto set quantidade_estoque = quantidade_estoque - ? where nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(mov);

			pst.setInt(1, produto.getQuantidade_estoque());
			pst.setString(2, produto.getNome_produto());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		String mov_total = "update produto set preco_total = quantidade_estoque  * ? where nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(mov_total);

			// pst.setInt(1, produto.getQuantidade_estoque());
			pst.setFloat(1, produto.getPreco_unitario());
			pst.setString(2, produto.getNome_produto());

			System.out.println(produto.getPreco_unitario());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Reajustar Preço
	public void reajustePreco(Produto produto) {
		String reajuste = "update produto set preco_unitario = ? where nome_produto =  ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(reajuste);

			pst.setFloat(1, produto.getPreco_unitario());
			pst.setString(2, produto.getNome_produto());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		String update_preco = "update produto set preco_total = ?  * ? where nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update_preco);

			pst.setFloat(1, produto.getPreco_unitario());
			pst.setInt(2, produto.getQuantidade_estoque());
			pst.setString(3, produto.getNome_produto());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Produto getProduto(String nome) {
		Produto produto = null;
		String sql = "SELECT * FROM produto WHERE nome_produto = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nome);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String nome_produto = rs.getString("nome_produto");
				float preco_unitario = rs.getFloat("preco_unitario");
				String unidade_medida = rs.getString("unidade_medida");
				int quantidade_estoque = rs.getInt("quantidade_estoque");
				float preco_total = rs.getFloat("preco_total");

				produto = new Produto(nome_produto, preco_unitario, unidade_medida, quantidade_estoque, preco_total);
			}
			pst.executeQuery();
			con.close();

			return produto;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public ArrayList<Float> valorUnitarioProduto(Produto produto) {
		ArrayList<Float> preco_unitario = new ArrayList<>();

		String read = "select preco_unitario * quantidade_estoque from produto";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				preco_unitario.add(rs.getFloat(1));

			}

			con.close();
			return preco_unitario;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public ArrayList<Float> valorTotalProduto(Produto produto) {
		ArrayList<Float> preco_total = new ArrayList<>();

		String read = "select SUM(preco_total) from produto";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				preco_total.add(rs.getFloat(1));

			}

			con.close();
			return preco_total;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
