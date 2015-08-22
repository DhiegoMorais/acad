package br.edu.ifba.plugin.PROJETO.modelo.bd.estatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AlunoDAO {
	
	private static Map<Integer, Aluno> alunos = 
			new TreeMap<Integer, Aluno>();
	
	static {
		
		Aluno a1 = new Aluno();
		
		a1.setId(1);
		a1.setCpf("1234");
		a1.setMatricula("1234");
		a1.setNome("aluno");
		
		alunos.put(a1.getId(), a1);
	}
	
	public static List<Aluno> getAlunosPorCPF(String cpf)
	{
		List<Aluno> encontrados = new ArrayList<Aluno>();
		
		for (Aluno a : alunos.values()) {
			if (a.getCpf().equals(cpf)) {
				encontrados.add(a);
			}
		}
		
		return encontrados;
	}
	
	public static List<Aluno> getAlunosPorMatricula(String matricula)
	{
		List<Aluno> encontrados = new ArrayList<Aluno>();
		
		for (Aluno a : alunos.values()) {
			if (a.getMatricula().equals(matricula)) {
				encontrados.add(a);
			}
		}
		
		return encontrados;
	}
	
	public static List<Aluno> getAlunosPorNome(String nome)
	{
		List<Aluno> encontrados = new ArrayList<Aluno>();
		
		for (Aluno a : alunos.values()) {
			if (a.getNome().equals(nome)) {
				encontrados.add(a);
			}
		}
		
		return encontrados;
	}
	
	public static List<Aluno> getAlunosPorLoginSenha(
			String login,
			String senha) {
		List<Aluno> encontrados = new ArrayList<Aluno>();
		
		for (Aluno a : alunos.values()) {
			if (a.getLogin().equals(login) && 
					a.getSenha().equals(senha)) {
				encontrados.add(a);
			}
		}
		
		return encontrados;
	}
	
	public static Aluno getAluno(int id){
		return alunos.get(id);
	}
	
	public static void remover(int id){
		alunos.remove(id);
	}
	
	public static int gravar(Aluno aluno) {
		if (aluno.getId() != -1) {
			remover(aluno.getId());
			alunos.put(aluno.getId(), aluno);
		} else {
			int ultimoId = 0;
			for (int id : alunos.keySet()) {
				ultimoId = id;
			}
			aluno.setId(ultimoId + 1);
			alunos.put(ultimoId + 1, aluno);
		}
		
		return 0;
	}

}
