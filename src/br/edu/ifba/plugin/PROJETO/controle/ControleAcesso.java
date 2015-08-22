package br.edu.ifba.plugin.PROJETO.controle;

import br.edu.ifba.plugin.PROJETO.modelo.ModeloProfessor;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoProfessor;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoUsuario;

/**
 * Classe para controle de acesso.
 * 
 * Realiza a integracao entre o modelo {@link #modeloUsuario} e a interface de
 * componente grafico {@link #acessoUsuario}. Esta integracao ocorre a partir da
 * injecao da interface no modelo. O modelo eh ativo (i.e. o MVC implementado se
 * baseia no principio de Modelo ativo) e aciona atualizacoes na interface.
 * 
 * @author PLUGIN
 */
public class ControleAcesso {

	private IAcessoProfessor acessoProfessor = null;
	private ModeloProfessor modeloProfessor = null;

	public void setAcessoProfesspr(IAcessoProfessor acesso) {
		this.acessoProfessor = acesso;
	}

	public void setModeloProfessor(ModeloProfessor modelo) {
		this.modeloProfessor = modelo;
	}

	public void validarAcesso() {
		modeloProfessor.setAcessoProfessor(acessoProfessor);
		modeloProfessor.validarAcesso();
	}

}
