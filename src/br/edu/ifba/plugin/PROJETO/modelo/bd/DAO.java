package br.edu.ifba.plugin.PROJETO.modelo.bd;

import javax.persistence.EntityManager;

import br.edu.ifba.plugin.PROJETO.modelo.bd.conexao.ConexaoSagu;

public abstract class DAO {

	protected EntityManager em;

	public DAO() {
		em = ConexaoSagu.getInstancia().getEntityManager();
	}

	public void iniciarTransacao() {
		if (em.getTransaction().isActive() == false) {
			em.getTransaction().begin();
		}
	}

	public void rollbackTransacao() {
		em.getTransaction().rollback();
	}

	public void commitTransacao() {
		em.getTransaction().commit();
	}

}
