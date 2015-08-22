package br.edu.ifba.plugin.PROJETO.modelo.bd.estatico;

import java.util.Date;

public class Aluno {
	
	private int id;
	private String cpf;
	private String rg;
	private String nome;
	private Date dataNascimento;
	private String matricula;
	private String telefone;
	private String endereco;
	private String email;
	private String login;
	private String senha;	
	
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public String getCpf() {
		return cpf;
	}
	public String getRg() {
		return rg;
	}
	public String getNome() {
		return nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
