package br.edu.ifba.plugin.PROJETO.visao;

import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Documento;

public interface ICadastroDocumento {

	public Documento getDocumento();
	
	public void setListaDocumentos(List<Documento> documentos);
	
	public void notificarSucesso();
	
	public void notificarFalha();

}
