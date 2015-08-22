package br.edu.ifba.plugin.PROJETO.visao.impl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.PROJETO.controle.ControleProfessor;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloProfessor;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroProfessor;


@ManagedBean(name = "cadprofessor")
@ViewScoped
public class CadastroProfessor implements ICadastroProfessor{

	private static final String ERRO_CPF_NAO_INFORMADO = "Cpf deve ser informado!";
	private static final String ERRO_NOME_NAO_INFORMADO = "Nome deve ser informado!";
	private static final String ERRO_RG_NAO_INFORMADO = "RG deve ser informado!";

	public boolean gravado = false;
	
	private String id = "";
	
	private Professor professor = new Professor();
	
	public CadastroProfessor(){
		ExternalContext contexto = FacesContext.getCurrentInstance()
				.getExternalContext();
		id = (String) contexto.getSessionMap().get("idProfessor");

		if ((id != null) && (!id.isEmpty())) {
			recuperarProfessor();
		}
	}
	
	public void recuperarProfessor() {
		ModeloProfessor modelo = new ModeloProfessor();
		ControleProfessor controle = new ControleProfessor();

		controle.setCadastroProfessor(this);
		controle.setModeloProfessor(modelo);

		controle.pesquisarParaCadastro();
		
	}

	
	@Override
	public int getId() {
		int iid = 0;

		if ((id != null) && (!id.isEmpty())) {
			iid = Integer.parseInt(id);
		}

		return iid;
	}

	@Override
	public Professor getProfessor() {
		return professor;
	}

	@Override
	public void atualizarProfessorEncontrado(Professor professor) {
		this.professor = professor;
	}
	
	public void gravar() {
		gravado = false;

		if ((professor.getCpf() == null) || (professor.getCpf().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:cpf",
					new FacesMessage(ERRO_CPF_NAO_INFORMADO,
							ERRO_CPF_NAO_INFORMADO));
		} else if ((professor.getNome() == null) || (professor.getNome().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:cpf",
					new FacesMessage(ERRO_NOME_NAO_INFORMADO,
							ERRO_NOME_NAO_INFORMADO));}
							
		  else if ((professor.getRg() == null) || (professor.getRg().isEmpty())) {
				FacesContext.getCurrentInstance().addMessage(
						"form:cpf",
						new FacesMessage(ERRO_RG_NAO_INFORMADO,
								ERRO_RG_NAO_INFORMADO));}
		  else{
							gravarProfessor();
		}
	}
	
	private void gravarProfessor() {
		ModeloProfessor modelo = new ModeloProfessor();
		ControleProfessor controle = new ControleProfessor();

		controle.setCadastroProfessor(this);
		controle.setModeloProfessor(modelo);

		controle.gravar();
	}

	@Override
	public void notificarProfessorNaoEncontrado() {
		
	}

	@Override
	public void notificarProfessorGravado(Professor professor) {
		gravado = true;
	}

	public boolean getGravado() {
		return gravado;
	}
	
	@Override
	public void notificarErroGravacao() {
		
	}
	
}
