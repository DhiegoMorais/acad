package br.edu.ifba.plugin.PROJETO.visao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.PROJETO.controle.ControleProfessor;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloProfessor;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaProfessor;

@ManagedBean(name = "pprofessor")
@ViewScoped
public class PesquisaProfessor implements IPesquisaProfessor {
	
	private String erro;
	private String sucesso;
	
	private String id = "";
	private String areaAtuacao = "";
	private String cpf = "";
	private String nome = "";

	private List<Professor> professoresEncontrados = new ArrayList<Professor>();

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
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

		ModeloProfessor modelo = new ModeloProfessor();
		ControleProfessor controle = new ControleProfessor();

		controle.setModeloProfessor(modelo);
		controle.setPesquisaProfessor(this);

		controle.pesquisar();
	}
	
	@Override
	public void atualizarProfessoresEncontrados(List<Professor> professores) {
		this.professoresEncontrados = professores;
		
	}
	
	public List<Professor> getProfessores() {
		return this.professoresEncontrados;
	}
	
	private void exibirCadastro(String id) {
		ExternalContext context = FacesContext.
				getCurrentInstance()
				.getExternalContext();
		context.getSessionMap().put("idProfessor", id);
		try {
			context.redirect("cadastro_professor.ifba");
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

		ModeloProfessor modelo = new ModeloProfessor();
		ControleProfessor controle = new ControleProfessor();

		controle.setModeloProfessor(modelo);
		controle.setPesquisaProfessor(this);

		controle.remover();
	}
	
	public String getErro() {
		return erro;
	}

	public String getSucesso() {
		return sucesso;
	}

	@Override
	public void notificarProfessoresNaoEncontrados() {
		erro = "Nenhum professor foi encontrado";
		
	}

	@Override
	public void notificarProfessorRemovido() {
		sucesso = "Professor removido com sucesso";	
		
	}

	@Override
	public void notificarErroRemocao() {
		erro = "Não foi possível remover o professor";
		
	}

}