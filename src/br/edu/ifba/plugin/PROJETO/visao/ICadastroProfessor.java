package br.edu.ifba.plugin.PROJETO.visao;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;

public interface ICadastroProfessor {
	
	public int getId();

	public Professor getProfessor();

	// /////////////////////

	public void atualizarProfessorEncontrado(Professor professor);

	public void notificarProfessorNaoEncontrado();

	public void notificarProfessorGravado(Professor professor);

	public void notificarErroGravacao();

}
