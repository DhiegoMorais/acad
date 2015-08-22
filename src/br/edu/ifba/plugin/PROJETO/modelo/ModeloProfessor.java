package br.edu.ifba.plugin.PROJETO.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.ProfessorDAO;
import br.edu.ifba.plugin.PROJETO.modelo.bd.jpa.ProfessorSagu;
import br.edu.ifba.plugin.PROJETO.modelo.bd.jpa.ProfessorSaguDAO;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoProfessor;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroProfessor;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaProfessor;
public class ModeloProfessor {
	
private static final boolean UTILIZAR_SAGU = true;
	
	private IAcessoProfessor acessoProfessor = null;
	private IPesquisaProfessor pesquisaProfessor = null;
	private ICadastroProfessor cadastroProfessor = null;

	public void setAcessoProfessor(IAcessoProfessor acesso) {
		this.acessoProfessor = acesso;
	}

	public void setPesquisaProfessor(IPesquisaProfessor pesquisa) {
		this.pesquisaProfessor = pesquisa;
	}

	public void setCadastroProfessor(ICadastroProfessor cadastro) {
		this.cadastroProfessor = cadastro;
	}

	public void validarAcesso() {
		if (UTILIZAR_SAGU) {
			List<ProfessorSagu> professores = new ProfessorSaguDAO()
					.getProfessoresPorLoginSenha(acessoProfessor.getLogin(),
							acessoProfessor.getSenha());
			if (professores.isEmpty()) {
				acessoProfessor.notificarSemPermissao();
			} else {
				ProfessorSagu professor = professores.get(0);
				acessoProfessor.atualizarProfessorComPermissao(professor);
			}
		} else {
			List<Professor> professores = ProfessorDAO.getProfessoresPorLoginSenha(
					acessoProfessor.getLogin(), acessoProfessor.getSenha());
			if (professores.isEmpty()) {
				acessoProfessor.notificarSemPermissao();
			} else {
				Professor professor = professores.get(0);
				acessoProfessor.atualizarProfessorComPermissao(professor);
			}
		}

	}

	public void pesquisar() {
		List<Professor> professores = new ArrayList<Professor>();

		String criterio = pesquisaProfessor.getCpf();
		if (!criterio.equals("")) {
			professores = ProfessorDAO.getProfessoresPorCPF(criterio);
		} else {
			criterio = pesquisaProfessor.getAreaAtuacao();
			if (!criterio.equals("")) {
				professores = ProfessorDAO.getProfessoresPorAreaAtuacao(criterio);
			} else {
				criterio = pesquisaProfessor.getNome();
				if (!criterio.equals("")) {
					professores = ProfessorDAO.getProfessoresPorNome(criterio);
				}
			}
		}

		pesquisaProfessor.atualizarProfessoresEncontrados(professores);

		if (professores.isEmpty()) {
			pesquisaProfessor.notificarProfessoresNaoEncontrados();
		}
	}

	public void pesquisarParaCadastro() {
		Professor professor = ProfessorDAO.getProfessor(cadastroProfessor.getId());

		if (professor == null) {
			cadastroProfessor.notificarProfessorNaoEncontrado();
		} else {
			cadastroProfessor.atualizarProfessorEncontrado(professor);
		}
	}

	public void remover() {
		ProfessorDAO.remover(Integer.parseInt(pesquisaProfessor.getId()));

		pesquisar();
		
		pesquisaProfessor.notificarProfessorRemovido();
	}

	public void adicionar() {
		Professor professor = cadastroProfessor.getProfessor();

		professor.setId(-1);
		if (ProfessorDAO.gravar(professor) > 0) {
			cadastroProfessor.notificarErroGravacao();
		} else {
			cadastroProfessor.notificarProfessorGravado(professor);
		}
	}

	public void atualizar() {
		Professor professor = cadastroProfessor.getProfessor();

		if (ProfessorDAO.gravar(professor) > 0) {
			cadastroProfessor.notificarErroGravacao();
		} else {
			cadastroProfessor.notificarProfessorGravado(professor);
		}
	}


}
