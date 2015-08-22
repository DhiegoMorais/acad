package br.edu.ifba.plugin.PROJETO.visao;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Aluno;


public interface ICadastroAluno {
	
	public int getId();

	public Aluno getAluno();

	// /////////////////////

	public void atualizarAlunoEncontrado(Aluno aluno);

	public void notificarAlunoNaoEncontrado();

	public void notificarAlunoGravado(Aluno aluno);

	public void notificarErroGravacao();

}
