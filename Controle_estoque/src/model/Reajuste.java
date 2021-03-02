package model;

import java.time.LocalDateTime;

public class Reajuste {

	private int id;
	private LocalDateTime data_reajuste;
	private String nome_produto;

	public Reajuste(int id, LocalDateTime data_reajuste, String nome_produto) {
		super();
		this.setId(id);
		this.setData_reajuste(data_reajuste);
		this.setNome_produto(nome_produto);

	}

	public Reajuste() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getData_reajuste() {
		return data_reajuste;
	}

	public void setData_reajuste(LocalDateTime data_reajuste) {
		this.data_reajuste = data_reajuste;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

}
