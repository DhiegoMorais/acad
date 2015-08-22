package br.edu.ifba.plugin.PROJETO.controle;

import br.edu.ifba.plugin.PROJETO.modelo.bd.DocumentoDAO;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroDocumento;

public class ControleDocumento {

private DocumentoDAO dao;
	
	public ControleDocumento(ICadastroDocumento documento)
	{
		dao = new DocumentoDAO(documento);
	}
		
	public void listar()
	{
		dao.listar();
	}
	

	public void gravar()
	{
		dao.gravar();
		dao.listar();
	}
	
	public void excluir()
	{
		dao.excluir();
		dao.listar();
	}
	

}
