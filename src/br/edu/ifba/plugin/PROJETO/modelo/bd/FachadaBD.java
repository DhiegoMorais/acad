package br.edu.ifba.plugin.PROJETO.modelo.bd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Professor;
import br.edu.ifba.plugin.PROJETO.modelo.beans.Funcionario;

/**
 * Mock de acesso a banco de dados. Utiliza colecoes estaticas para
 * simular manipulacao de banco.
 * 
 * OBS.: deve ser substituido por fachada(s) real(is).
 * 
 * @author PLUGIN
 */
public class FachadaBD {

	private static Map<Integer, Funcionario> funcionarios = 
			new TreeMap<Integer, Funcionario>();
	
	static {
		
		Funcionario u1 = new Funcionario();
		u1.setId(1);
		u1.setCpf("123-4");
		u1.setRg("321-1");
		u1.setCtps("456-7");
		u1.setNome("Astrogildo da Silva");
		u1.setLogin("astro");
		u1.setSenha("123");
		u1.setAreaAtuacao("programacao");
		
		funcionarios.put(u1.getId(), u1);
		
		Funcionario u2 = new Funcionario();
		u2.setId(2);
		u2.setCpf("789-0");
		u2.setRg("987-6");
		u2.setCtps("567-8");
		u2.setNome("Estelvania da Silva");
		u2.setLogin("telva");
		u2.setSenha("456");
		
		funcionarios.put(u2.getId(), u2);
	}
	
	public static List<Funcionario> getUsuariosPorLoginSenha(String login,
			String senha) {
		List<Funcionario> encontrados = new ArrayList<Funcionario>();
		
		for (Funcionario u : funcionarios.values()) {
			if (u.getLogin().equals(login) && 
					u.getSenha().equals(senha)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Funcionario> getUsuariosPorCPF(String cpf){
		List<Funcionario> encontrados = new ArrayList<Funcionario>();
		
		for (Funcionario u : funcionarios.values()) {
			if(u.getCpf().equals(cpf)){
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Funcionario> getUsuariosPorRG(String rg){
		List<Funcionario> encontrados = new ArrayList<Funcionario>();
		
		for (Funcionario u : funcionarios.values()) {
			if(u.getRg().equals(rg)){
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Funcionario> getUsuariosPorNome(String nome){
		List<Funcionario> encontrados = new ArrayList<Funcionario>();
		
		for (Funcionario u : funcionarios.values()) {
			if(u.getNome().toLowerCase().contains(nome.toLowerCase())){
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Funcionario> getUsuariosPorAreaAtuacao(
			String areaAtuacao)
	{
		List<Funcionario> encontrados = new ArrayList<Funcionario>();
		
		for (Funcionario u : funcionarios.values()) {
			if (u.getAreaAtuacao().toLowerCase().
					contains(areaAtuacao.toLowerCase())) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
}











