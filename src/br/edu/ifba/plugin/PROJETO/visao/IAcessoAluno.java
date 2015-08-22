package br.edu.ifba.plugin.PROJETO.visao;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Aluno;
import br.edu.ifba.plugin.PROJETO.modelo.bd.jpa.AlunoSagu;


public interface IAcessoAluno {
	
	public String getLogin();

	public String getSenha();

	public void atualizarAlunoComPermissao(Aluno aluno);

	public void atualizarAlunoComPermissao(AlunoSagu aluno);

	public void notificarSemPermissao();

}
