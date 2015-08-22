package br.edu.ifba.plugin.PROJETO.modelo.bd.conexao;


public class ConexaoSagu extends ConexaoBD {

	private static String BDSAGU = "progressao";

	private static ConexaoSagu instancia = null;

	public static ConexaoSagu getInstancia() {
		if (instancia == null) {
			instancia = new ConexaoSagu();
			instancia.iniciar(BDSAGU);
		}

		return instancia;
	}

	private ConexaoSagu() {
	}

}