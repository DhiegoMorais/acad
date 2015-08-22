package br.edu.ifba.plugin.PROJETO.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.PROJETO.controle.ControleDocumento;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Documento;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroDocumento;

@ManagedBean(name = "cadastroDocumento")
@ViewScoped
public class CadastroDocumento implements ICadastroDocumento{

	private List<Documento> listaDocumentos = new ArrayList<Documento>();
	private Documento documento;

	boolean edicao = false;

	private ControleDocumento controle;

	public CadastroDocumento() {
		controle = new ControleDocumento(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.documento = new Documento();

		edicao = true;
	
	}

	public void prepararEdicao(Documento documento) {
		this.documento = documento;
		edicao = true;
	}

	public void cancelarEdicao() {
		
		edicao = false;
	}

	@Override
	public Documento getDocumento() {
		return documento;
	}

	public void setAtividade(Documento objeto) {
		this.documento = objeto;
	}

	public void listarDocumentos() {

		controle.listar();
	}

	public void excluirDocumento() {
		controle.excluir();
	}

	public void gravarDocumento() {
		controle.gravar();
	}

	@Override
	public void setListaDocumentos(List<Documento> documentos) {
		this.listaDocumentos = documentos;
	}

	public List<Documento> getListaDocumentos() {
		return listaDocumentos;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
		
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
		
	}
}
