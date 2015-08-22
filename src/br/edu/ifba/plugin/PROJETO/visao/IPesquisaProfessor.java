package br.edu.ifba.plugin.PROJETO.visao;

import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;

public interface IPesquisaProfessor {

public String getId();
	
	public String getAreaAtuacao();

	public String getCpf();

	public String getNome();

	///////////////////////

	public void atualizarProfessoresEncontrados(List<Professor> professores);

	public void notificarProfessoresNaoEncontrados();
	
	public void notificarProfessorRemovido();
	
	public void notificarErroRemocao();
	
}
