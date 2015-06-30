package br.com.amigosecreto.teste;

import java.util.List;

import br.com.amigosecreto.model.entity.Pessoa;
import br.com.amigosecreto.model.entity.PessoaCrud;

public class TestePessoaCrud {

	static PessoaCrud crud;

	public static void main(String[] args) {

		crud = new PessoaCrud();
		criarPessoas();

		listarPessoas();
		
		buscarPessoaPorId();
		
		buscarPessoaPorNome();

	}

	private static void buscarPessoaPorNome() {
		String nome = "sonia";
		Pessoa p = crud.buscarPorNome(nome);
		System.out.println("nome\temail");
		if(p != null){
			System.out.println(p.getNome() +"\t"+ p.getEmail());
		} else {
			System.out.println("pessoa nao encontrada");
		}
		
	}

	private static void buscarPessoaPorId() {
		int id = 3;
		Pessoa p = crud.buscarPorId(id);
		System.out.println("nome\temail");
		if(p != null){
			System.out.println(p.getNome() +"\t"+ p.getEmail());
		} else {
			System.out.println("pessoa nao encontrada");
		}
		
	}

	private static void listarPessoas() {
		List<Pessoa> lista = crud.listar();
		System.out.println("id\tnome\temail\tbilhete");
		for (Pessoa p : lista) {
			System.out.println(p.getId() +"\t"+ p.getNome() +"\t"+ p.getEmail() +"\t"+ p.getBilhete());
		}

	}

	private static void criarPessoas() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("sonia");
		pessoa.setBilhete("02");
		pessoa.setEmail("sonia@email.com");

		crud.salvar(pessoa);

		pessoa = new Pessoa();
		pessoa.setNome("sandra");
		pessoa.setBilhete("03");
		pessoa.setEmail("sandra@email.com");

		crud.salvar(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setNome("diogo");
		pessoa.setBilhete("04");
		pessoa.setEmail("diogo@email.com");

		crud.salvar(pessoa);

	}
}
