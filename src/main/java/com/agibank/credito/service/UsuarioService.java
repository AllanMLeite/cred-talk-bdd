package com.agibank.credito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.agibank.credito.model.Usuario;

public class UsuarioService {

	private List<Usuario> usuarios = new ArrayList<>();

	public void removerTodos() {
		usuarios = new ArrayList<>();
	}

	public List<Usuario> listarTodos(String cpfPesquisa) throws Exception {
		if (usuarios.isEmpty())
			throw new Exception("Nenhum usuario cadastrado.");

		return usuarios.stream().filter(x -> x.getCpf().equals(cpfPesquisa)).collect(Collectors.toList());
	}

	public void adicionar(Usuario usuario) {
		usuarios.add(usuario);
	}
}
