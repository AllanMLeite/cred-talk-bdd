package com.agibank.credito.usuario.listar;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.agibank.credito.model.Usuario;
import com.agibank.credito.service.UsuarioService;

public class PassosParaListarUsuario implements cucumber.api.java8.Pt {

	UsuarioService usuarioService = new UsuarioService();
	private List<Usuario> usuarios;
	private String mensagemErro;

	public PassosParaListarUsuario() {
		Dado("^que estou logado no sistema como administrador$", () -> {
			//
		});

		Dado("^que nao existem usuarios cadastrados$", () -> {
			usuarioService.removerTodos();
		});

		Quando("^buscar usuarios$", () -> {
			try {
				usuarioService.listarTodos();
			} catch (Exception e) {
				mensagemErro = e.getMessage();
			}
		});

		Entao("^exibe \"([^\"]*)\"$", (String mensagemEsperada) -> {
			assertEquals(mensagemEsperada, mensagemErro);
		});
	}

}
