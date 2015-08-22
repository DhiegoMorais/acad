package br.edu.ifba.plugin.PROJETO.visao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.PROJETO.controle.ControleAluno;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloAluno;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Aluno;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaAluno;

@ManagedBean(name = "paluno")
@ViewScoped
public class PesquisaAluno implements IPesquisaAluno{
	
	private String erro;
	private String sucesso;
	
	private String id = "";
	private String matricula = "";
	private String cpf = "";
	private String nome = "";

	private List<Aluno> alunosEncontrados = new ArrayList<Aluno>();
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void pesquisar() {
		erro = null;
		
		System.out.println("pesquisar");

		ModeloAluno modelo = new ModeloAluno();
		ControleAluno controle = new ControleAluno();

		controle.setModeloAluno(modelo);
		controle.setPesquisaAluno(this);

		controle.pesquisar();
	}

	@Override
	public void atualizarAlunosEncontrados(List<Aluno> alunos) {
		this.alunosEncontrados = alunos;
	}
	
	public List<Aluno> getAlunos() {
		return this.alunosEncontrados;
	}
	
	private void exibirCadastro(String id) {
		ExternalContext context = FacesContext.
				getCurrentInstance()
				.getExternalContext();
		context.getSessionMap().put("idAluno", id);
		try {
			context.redirect("cadastro_aluno.ifba");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ver(String id) {
		exibirCadastro(id);
	}

	public void adicionar() {
		exibirCadastro("");
	}

	public void remover(String id) {
		sucesso = null;
		erro = null;
		
		this.id = id;

		ModeloAluno modelo = new ModeloAluno();
		ControleAluno controle = new ControleAluno();

		controle.setModeloAluno(modelo);
		controle.setPesquisaAluno(this);

		controle.remover();
	}
	
	public String getErro() {
		return erro;
	}

	public String getSucesso() {
		return sucesso;
	}
	
	@Override
	public void notificarAlunosNaoEncontrados() {
		erro = "Nenhum aluno foi encontrado";
	}

	@Override
	public void notificarAlunoRemovido() {
		sucesso = "Aluno removido com sucesso";		
	}

	@Override
	public void notificarErroRemocao() {
		erro = "Não foi possível remover o aluno";
	}

}
