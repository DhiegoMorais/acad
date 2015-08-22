package br.edu.ifba.plugin.PROJETO.visao;

import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Aluno;

public interface IPesquisaAluno {
	
	public String getId();
	
	public String getMatricula();

	public String getCpf();

	public String getNome();

	///////////////////////

	public void atualizarAlunosEncontrados(List<Aluno> alunos);

	public void notificarAlunosNaoEncontrados();
	
	public void notificarAlunoRemovido();
	
	public void notificarErroRemocao();

}
