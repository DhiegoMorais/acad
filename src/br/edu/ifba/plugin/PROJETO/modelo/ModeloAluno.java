package br.edu.ifba.plugin.PROJETO.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Aluno;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.AlunoDAO;
import br.edu.ifba.plugin.PROJETO.modelo.bd.jpa.AlunoSagu;
import br.edu.ifba.plugin.PROJETO.modelo.bd.jpa.AlunoSaguDAO;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoAluno;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroAluno;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaAluno;

public class ModeloAluno {
	
	private static final boolean UTILIZAR_SAGU = true;
	
	private IAcessoAluno acessoAluno = null;
	private IPesquisaAluno pesquisaAluno = null;
	private ICadastroAluno cadastroAluno = null;

	public void setAcessoAluno(IAcessoAluno acesso) {
		this.acessoAluno = acesso;
	}

	public void setPesquisaAluno(IPesquisaAluno pesquisa) {
		this.pesquisaAluno = pesquisa;
	}

	public void setCadastroAluno(ICadastroAluno cadastro) {
		this.cadastroAluno = cadastro;
	}

	public void validarAcesso() {
		if (UTILIZAR_SAGU) {
			List<AlunoSagu> alunos = new AlunoSaguDAO()
					.getAlunosPorLoginSenha(acessoAluno.getLogin(),
							acessoAluno.getSenha());
			if (alunos.isEmpty()) {
				acessoAluno.notificarSemPermissao();
			} else {
				AlunoSagu aluno = alunos.get(0);
				acessoAluno.atualizarAlunoComPermissao(aluno);
			}
		} else {
			List<Aluno> alunos = AlunoDAO.getAlunosPorLoginSenha(
					acessoAluno.getLogin(), acessoAluno.getSenha());
			if (alunos.isEmpty()) {
				acessoAluno.notificarSemPermissao();
			} else {
				Aluno aluno = alunos.get(0);
				acessoAluno.atualizarAlunoComPermissao(aluno);
			}
		}

	}

	public void pesquisar() {
		List<Aluno> alunos = new ArrayList<Aluno>();

		String criterio = pesquisaAluno.getCpf();
		if (!criterio.equals("")) {
			alunos = AlunoDAO.getAlunosPorCPF(criterio);
		} else {
			criterio = pesquisaAluno.getMatricula();
			if (!criterio.equals("")) {
				alunos = AlunoDAO.getAlunosPorMatricula(criterio);
			} else {
				criterio = pesquisaAluno.getNome();
				if (!criterio.equals("")) {
					alunos = AlunoDAO.getAlunosPorNome(criterio);
				}
			}
		}

		pesquisaAluno.atualizarAlunosEncontrados(alunos);

		if (alunos.isEmpty()) {
			pesquisaAluno.notificarAlunosNaoEncontrados();
		}
	}

	public void pesquisarParaCadastro() {
		Aluno aluno = AlunoDAO.getAluno(cadastroAluno.getId());

		if (aluno == null) {
			cadastroAluno.notificarAlunoNaoEncontrado();
		} else {
			cadastroAluno.atualizarAlunoEncontrado(aluno);
		}
	}

	public void remover() {
		AlunoDAO.remover(Integer.parseInt(pesquisaAluno.getId()));

		pesquisar();
		
		pesquisaAluno.notificarAlunoRemovido();
	}

	public void adicionar() {
		Aluno aluno = cadastroAluno.getAluno();

		aluno.setId(-1);
		if (AlunoDAO.gravar(aluno) > 0) {
			cadastroAluno.notificarErroGravacao();
		} else {
			cadastroAluno.notificarAlunoGravado(aluno);
		}
	}

	public void atualizar() {
		Aluno aluno = cadastroAluno.getAluno();

		if (AlunoDAO.gravar(aluno) > 0) {
			cadastroAluno.notificarErroGravacao();
		} else {
			cadastroAluno.notificarAlunoGravado(aluno);
		}
	}

}
