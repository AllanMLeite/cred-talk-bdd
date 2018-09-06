package com.agibank.credito.service;

import java.util.ArrayList;
import java.util.List;

import com.agibank.credito.model.Usuario;

public class UsuarioService {

	private List<Usuario> usuarios = new ArrayList<>();

	public void removerTodos() {
		usuarios = new ArrayList<>();
	}

	public List<Usuario> listarTodos() throws Exception {
		if (usuarios.isEmpty())
			throw new Exception("Nenhum usuario cadastrado.");

		return usuarios;
	}

}
