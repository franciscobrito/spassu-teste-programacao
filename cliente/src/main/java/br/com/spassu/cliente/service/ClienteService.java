package br.com.spassu.cliente.service;

import java.util.ArrayList;
import java.util.List;

import br.com.spassu.cliente.model.Cliente;

public class ClienteService {
	
	private List<Cliente> clientes = new ArrayList<>();
	
	public List<Cliente> listarCliente() {
		return clientes;
	}
	
	public void saveOrUpdateCliente(Cliente cliente) {
		if (clientes.contains(cliente)) {
			System.out.println(cliente.getId() + "; " + cliente.getNome() + "; " + cliente.getCidade());
			System.out.println("Cliente " + cliente.getId() + " alterado");
		} else {
			clientes.add(cliente);
			System.out.println(cliente.getId() + "; " + cliente.getNome() + "; " + cliente.getCidade());
			System.out.println("Cliente " + cliente.getId() + " incluído");
		}
	}

}
