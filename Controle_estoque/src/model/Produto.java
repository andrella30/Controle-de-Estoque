package model;

public class Produto {

	private String nome_produto;
	private float preco_unitario;
	private String unidade_medida;
	private int quantidade_estoque;
	private float valor_total_estoque;

	public Produto(String nome_produto, float preco_unitario, String unidade_medida, int quantidade_estoque,
			float valor_total_estoque) {
		super();
		this.nome_produto = nome_produto;
		this.preco_unitario = preco_unitario;
		this.unidade_medida = unidade_medida;
		this.quantidade_estoque = quantidade_estoque;
		this.valor_total_estoque = valor_total_estoque;
	}

	public Produto() {
		super();
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public float getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(float preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public String getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(String unidade_medida) {
		this.unidade_medida = unidade_medida;
	}

	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public float getValor_total_estoque() {
		return valor_total_estoque;
	}

	public void setValor_total_estoque(float valor_total_estoque) {
		this.valor_total_estoque = valor_total_estoque;

	}
}
