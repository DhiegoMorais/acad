package br.edu.ifba.plugin.PROJETO.modelo.bd.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.PROJETO.modelo.bd.ConexaoBD;


public class AlunoSaguDAO {
	
	public List<AlunoSagu> getAlunosPorLoginSenha(String login, String senha) {
		List<AlunoSagu> encontrados = new ArrayList<AlunoSagu>();

		EntityManager em = ConexaoBD.getInstancia().getEntityManager();
		TypedQuery<AlunoSagu> query = em
				.createQuery(
						"select u from AlunoSagu u where u.login = :login and u.senha = :senha",
						AlunoSagu.class);
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
