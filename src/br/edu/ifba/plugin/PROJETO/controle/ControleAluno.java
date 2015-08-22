package br.edu.ifba.plugin.PROJETO.controle;

import br.edu.ifba.plugin.PROJETO.modelo.ModeloAluno;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroAluno;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaAluno;



public class ControleAluno {
	
	private IPesquisaAluno pesquisaAluno;
	private ICadastroAluno cadastroAluno;
	private ModeloAluno modeloAluno;

	public void setPesquisaAluno(IPesquisaAluno pesquisa) {
		this.pesquisaAluno = pesquisa;
	}

	public void setCadastroAluno(ICadastroAluno cadastro) {
		this.cadastroAluno = cadastro;
	}

	public void setModeloAluno(ModeloAluno modelo) {
		this.modeloAluno = modelo;
	}

	public void pesquisar() {
		modeloAluno.setPesquisaAluno(pesquisaAluno);
		modeloAluno.pesquisar();
	}

	public void pesquisarParaCadastro() {
		modeloAluno.setCadastroAluno(cadastroAluno);
		modeloAluno.pesquisarParaCadastro();
	}

	public void remover() {
		modeloAluno.setPesquisaAluno(pesquisaAluno);
		modeloAluno.remover();
	}

	public void gravar() {
		modeloAluno.setCadastroAluno(cadastroAluno);
		
		if (cadastroAluno.getId() == -1) {
			modeloAluno.adicionar();
		} else {
			modeloAluno.atualizar();
		}
	}


}
