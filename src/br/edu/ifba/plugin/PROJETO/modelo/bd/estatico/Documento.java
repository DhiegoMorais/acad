package br.edu.ifba.plugin.PROJETO.modelo.bd.estatico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento", schema = "progressaoacademica")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id = -1;
	@Column(name = "nome", nullable = false)
	private String nome;

	public Documento() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Documento [idDocumento=" + id + ", nomeDocumento=" + nome + "]";
	}


}
