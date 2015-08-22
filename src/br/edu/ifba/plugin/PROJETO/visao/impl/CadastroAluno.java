package br.edu.ifba.plugin.PROJETO.visao.impl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.PROJETO.controle.ControleAluno;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloAluno;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Aluno;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroAluno;


@ManagedBean(name = "cadaluno")
@ViewScoped
public class CadastroAluno implements ICadastroAluno{
	
	private static final String ERRO_CPF_NAO_INFORMADO = "Cpf deve ser informado!";
	private static final String ERRO_MATRICULA_NAO_INFORMADO = "Matricula deve ser informada!";
	private static final String ERRO_NOME_NAO_INFORMADO = "Nome deve ser informado!";
	private static final String ERRO_RG_NAO_INFORMADO = "RG deve ser informado!";
	
	public boolean gravado = false;
	
	private String id = "";
	
	private Aluno aluno = new Aluno();
	
	public CadastroAluno(){
		ExternalContext contexto = FacesContext.getCurrentInstance()
				.getExternalContext();
		id = (String) contexto.getSessionMap().get("idAluno");

		if ((id != null) && (!id.isEmpty())) {
			recuperarAluno();
		}
	}
	
	public void recuperarAluno() {
		ModeloAluno modelo = new ModeloAluno();
		ControleAluno controle = new ControleAluno();

		controle.setCadastroAluno(this);
		controle.setModeloAluno(modelo);

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
	public Aluno getAluno() {
		return aluno;
	}

	@Override
	public void atualizarAlunoEncontrado(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void gravar() {
		gravado = false;

		if ((aluno.getCpf() == null) || (aluno.getCpf().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:cpf",
					new FacesMessage(ERRO_CPF_NAO_INFORMADO,
							ERRO_CPF_NAO_INFORMADO));
		} else if 
			 ((aluno.getMatricula() == null) || (aluno.getMatricula().isEmpty())) {
				FacesContext.getCurrentInstance().addMessage(
						"form:cpf",
						new FacesMessage(ERRO_MATRICULA_NAO_INFORMADO,
								ERRO_MATRICULA_NAO_INFORMADO)); }
		
		else if ((aluno.getRg() == null) || (aluno.getRg().isEmpty())) {
				FacesContext.getCurrentInstance().addMessage(
						"form:cpf",
						new FacesMessage(ERRO_RG_NAO_INFORMADO,
								ERRO_RG_NAO_INFORMADO)); }
		else if ((aluno.getNome() == null) || (aluno.getNome().isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(
					"form:cpf",
					new FacesMessage(ERRO_NOME_NAO_INFORMADO,
							ERRO_NOME_NAO_INFORMADO)); }
		else {
				
				gravarAluno();
		}
	}

	
	private void gravarAluno() {
		ModeloAluno modelo = new ModeloAluno();
		ControleAluno controle = new ControleAluno();

		controle.setCadastroAluno(this);
		controle.setModeloAluno(modelo);

		controle.gravar();
	}

	@Override
	public void notificarAlunoNaoEncontrado() {
		
	}

	@Override
	public void notificarAlunoGravado(Aluno aluno) {
		gravado = true;
	}

	public boolean getGravado() {
		return gravado;
	}
	
	@Override
	public void notificarErroGravacao() {
		
	}

}
