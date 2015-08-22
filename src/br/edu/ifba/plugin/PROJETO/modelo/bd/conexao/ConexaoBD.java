package br.edu.ifba.plugin.PROJETO.modelo.bd.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoBD {

	private EntityManagerFactory managerFactory = null;

	public void iniciar(String bd) {
		managerFactory = Persistence.createEntityManagerFactory(bd);
	}

	public void fechar() {
		managerFactory.close();
	}

	public EntityManager getEntityManager() {
		return managerFactory.createEntityManager();
	}	
}