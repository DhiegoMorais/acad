package br.edu.ifba.plugin.PROJETO.visao;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;
import br.edu.ifba.plugin.PROJETO.modelo.bd.jpa.ProfessorSagu;

public interface IAcessoProfessor {
	
	public String getLogin();

	public String getSenha();

	public void atualizarProfessorComPermissao(Professor professor);

	public void atualizarProfessorComPermissao(ProfessorSagu professor);

	public void notificarSemPermissao();

}
