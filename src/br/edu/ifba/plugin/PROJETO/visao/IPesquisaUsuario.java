package br.edu.ifba.plugin.PROJETO.visao;

import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;

public interface IPesquisaUsuario {

	public String getId();
	public String getRg();

	public String getCpf();

	public String getNome();
	
	public String getAreaAtuacao();

	// ////////////////////

	public void atualizarProfessoresEncontrados(List<Professor> professors);

	public void notificarProfessoresNaoEncontrados();

}
