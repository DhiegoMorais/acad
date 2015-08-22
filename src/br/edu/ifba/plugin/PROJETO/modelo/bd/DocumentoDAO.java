package br.edu.ifba.plugin.PROJETO.modelo.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Documento;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroDocumento;

public class DocumentoDAO extends DAO{
	
	private ICadastroDocumento cadastro;

	public DocumentoDAO(ICadastroDocumento documento) {
		super();
		this.cadastro = documento;
	}

	public void listar() {
		List<Documento> encontrados = new ArrayList<Documento>();

		TypedQuery<Documento> query = em.createQuery(
				"select u from Documento u order by u.id", Documento.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaDocumentos(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			System.out.println("Iniciou a transaçao para exlcuir...");
			Documento m = em.merge(cadastro.getDocumento());
			System.out.println(m);
			em.remove(m);
			System.out.println("Excluiu da lista...");
			commitTransacao();
		} catch (Exception e) {
			System.out.println("Não excluiu da lista...");
			e.printStackTrace();
			rollbackTransacao();
		}

	}

	public void gravar() {
		Documento documento = cadastro.getDocumento();
		
		System.out.println(documento);
		System.out.println("... ... ...");
		
		try {
			iniciarTransacao();
			if(documento.getId() == -1)
			{
				em.persist(documento);
				System.out.println("Iseriu na tabela...");
			}else{
				em.merge(documento);
				System.out.println("Atualizou: ");
				System.out.println(documento);
			}
			commitTransacao();
			
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();

			cadastro.notificarFalha();
		}

	}

}
