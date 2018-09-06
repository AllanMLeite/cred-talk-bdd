package com.agibank.credito.usuario.listar;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.agibank.credito.model.Usuario;
import com.agibank.credito.service.UsuarioService;

public class PassosParaListarUsuario implements cucumber.api.java8.Pt {

	UsuarioService usuarioService = new UsuarioService();
	private List<Usuario> usuarios;
	private String mensagemErro;
	private String cpfPesquisa;

	public PassosParaListarUsuario() {
		Dado("^que estou logado no sistema como administrador$", () -> {
			//
		});

		Dado("^que nao existem usuarios cadastrados$", () -> {
			usuarioService.removerTodos();
		});

		Quando("^buscar usuarios$", () -> {
			try {
				usuarios = usuarioService.listarTodos(cpfPesquisa);
			} catch (Exception e) {
				mensagemErro = e.getMessage();
			}
		});

		Entao("^exibe \"([^\"]*)\"$", (String mensagemEsperada) -> {
			assertEquals(mensagemEsperada, mensagemErro);
		});

		Dado("^que exista um usuario \"([^\"]*)\" com cpf \"([^\"]*)\"$", (String nome, String cpf) -> {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setCpf(cpf);
			usuarioService.adicionar(usuario);
		});

		Dado("^que informei o cpf \"([^\"]*)\"$", (String cpf) -> {
			cpfPesquisa = cpf;
		});

		Entao("^retorna o usuario \"([^\"]*)\"$", (String nome) -> {
			assertEquals(nome, usuarios.get(0).getNome());
		});

	}

}
