package br.edu.ifba.plugin.PROJETO.modelo.bd.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.PROJETO.modelo.bd.ConexaoBD;

public class ProfessorSaguDAO {

	public List<ProfessorSagu> getProfessoresPorLoginSenha(String login, String senha) {
		List<ProfessorSagu> encontrados = new ArrayList<ProfessorSagu>();

		EntityManager em = ConexaoBD.getInstancia().getEntityManager();
		TypedQuery<ProfessorSagu> query = em
				.createQuery(
						"select u from ProfessorSagu u where u.login = :login and u.senha = :senha",
						ProfessorSagu.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);

		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}

		return encontrados;
	}
}
