package br.edu.ifba.plugin.PROJETO.modelo.bd.estatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Mock de acesso a banco de dados. Utiliza colecoes estaticas para
 * simular manipulacao de banco.
 * 
 * OBS.: deve ser substituido por fachada(s) real(is).
 * 
 * @author PLUGIN
 */
public class ProfessorDAO {

	private static Map<Integer, Professor> professors = 
			new TreeMap<Integer, Professor>();
	
	static {
		
		Professor u1 = new Professor();
		u1.setId(1);
		u1.setCpf("123-4");
		u1.setRg("321-1");
		u1.setNome("Astrogildo da Silva");
		u1.setLogin("astro");
		u1.setSenha("123");
		u1.setAreaAtuacao("Programacao");
		
		professors.put(u1.getId(), u1);
		
		Professor u2 = new Professor();
		u2.setId(2);
		u2.setCpf("789-0");
		u2.setRg("987-6");
		u2.setNome("Estelvania da Silva");
		u2.setLogin("telva");
		u2.setSenha("456");
		u2.setAreaAtuacao("matematica");
		
		professors.put(u2.getId(), u2);
		
		Professor u3 = new Professor();
		u3.setId(2);
		u3.setCpf("789-0");
		u3.setRg("987-6");
		u3.setNome("Maria");
		u3.setLogin("telva");
		u3.setSenha("456");
		u3.setAreaAtuacao("linguagem");
		
		professors.put(u3.getId(), u3);
	}
	
	public static List<Professor> getProfessoresPorLoginSenha(
			String login,
			String senha) {
		List<Professor> encontrados = new ArrayList<Professor>();
		
		for (Professor u : professors.values()) {
			if (u.getLogin().equals(login) && 
					u.getSenha().equals(senha)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Professor> getProfessoresPorCPF(String cpf)
	{
		List<Professor> encontrados = new ArrayList<Professor>();
		
		for (Professor u : professors.values()) {
			if (u.getCpf().equals(cpf)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}

	public static List<Professor> getProfessoresPorRG(String rg)
	{
		List<Professor> encontrados = new ArrayList<Professor>();
		
		for (Professor u : professors.values()) {
			if (u.getRg().equals(rg)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Professor> getProfessoresPorNome(
			String nome)
	{
		List<Professor> encontrados = new ArrayList<Professor>();
		
		for (Professor u : professors.values()) {
			if (u.getNome().toLowerCase().
					contains(nome.toLowerCase())) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Professor> getProfessoresPorAreaAtuacao(
			String areaAtuacao)
	{
		List<Professor> encontrados = new ArrayList<Professor>();
		
		for (Professor u : professors.values()) {
			if (u.getAreaAtuacao().toLowerCase().
					contains(areaAtuacao.toLowerCase())) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static Professor getProfessor(int id){
		return professors.get(id);
	}
	
	public static void remover(int id){
		professors.remove(id);
	}
	
	public static int gravar(Professor professor) {
		if (professor.getId() != -1) {
			remover(professor.getId());
			professors.put(professor.getId(), professor);
		} else {
			int ultimoId = 0;
			for (int id : professors.keySet()) {
				ultimoId = id;
			}
			professor.setId(ultimoId + 1);
			professors.put(ultimoId + 1, professor);
		}
		
		return 0;
	}
}











