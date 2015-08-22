package br.edu.ifba.plugin.PROJETO.controle;

import br.edu.ifba.plugin.PROJETO.modelo.ModeloProfessor;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroProfessor;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaProfessor;

public class ControleProfessor {
	
	private IPesquisaProfessor pesquisaProfessor;
	private ICadastroProfessor cadastroProfessor;
	private ModeloProfessor modeloProfessor;

	public void setPesquisaProfessor(IPesquisaProfessor pesquisa) {
		this.pesquisaProfessor = pesquisa;
	}

	public void setCadastroProfessor(ICadastroProfessor cadastro) {
		this.cadastroProfessor = cadastro;
	}

	public void setModeloProfessor(ModeloProfessor modelo) {
		this.modeloProfessor = modelo;
	}

	public void pesquisar() {
		modeloProfessor.setPesquisaProfessor(pesquisaProfessor);
		modeloProfessor.pesquisar();
	}

	public void pesquisarParaCadastro() {
		modeloProfessor.setCadastroProfessor(cadastroProfessor);
		modeloProfessor.pesquisarParaCadastro();
	}

	public void remover() {
		modeloProfessor.setPesquisaProfessor(pesquisaProfessor);
		modeloProfessor.remover();
	}

	public void gravar() {
		modeloProfessor.setCadastroProfessor(cadastroProfessor);
		
		if (cadastroProfessor.getId() == -1) {
			modeloProfessor.adicionar();
		} else {
			modeloProfessor.atualizar();
		}
	}

}
