package br.edu.ifba.plugin.PROJETO.modelo.bd.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.PROJETO.modelo.bd.ConexaoBD;
import br.edu.ifba.plugin.PROJETO.modelo.bd.jpa.FuncionarioSagu;

/**
 * Acesso ao banco de dados do SAGU
 * 
 * @author PLUGIN
 */
public class FuncionarioSaguDAO {

	public List<FuncionarioSagu> getUsuariosPorLoginSenha(String login, String senha) {
		List<FuncionarioSagu> encontrados = new ArrayList<FuncionarioSagu>();

		EntityManager em = ConexaoBD.getInstancia().getEntityManager();
		TypedQuery<FuncionarioSagu> query = em
				.createQuery(
						"select u from UsuarioSagu u where u.login = :login and u.senha = :senha",
						FuncionarioSagu.class);
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
