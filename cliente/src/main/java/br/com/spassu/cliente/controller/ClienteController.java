package br.com.spassu.cliente.controller;

import java.util.List;
import java.util.Scanner;

import br.com.spassu.cliente.model.Cliente;
import br.com.spassu.cliente.service.ClienteService;

public class ClienteController {

	private ClienteService clienteService = new ClienteService();

	int incrementoId = 0;

	public void listarCliente() {
		List<Cliente> clientes = clienteService.listarCliente();

		if (!clientes.isEmpty()) {
			for (Cliente cliente : clientes) {
				System.out.println(
						"| " + cliente.getId() + " | " + cliente.getNome() + " | " + cliente.getCidade() + " |");
			}
		}
	}

	public void cadastro() {
		Cliente cliente = new Cliente(++incrementoId);
		saveOrUpdate(cliente);
	}

	public void atualizar() {
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = clienteService.clienteById(scanner.nextInt());
		if (cliente != null)
			saveOrUpdate(cliente);
		else
			System.out.println("Código inválido.");
	}

	public void saveOrUpdate(Cliente cliente) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		if (nome != null && !nome.isEmpty()) {
			cliente.setNome(nome);
		}

		System.out.println("Cidade: ");
		String cidade = scanner.nextLine();
		if (cidade != null && !cidade.isEmpty()) {
			cliente.setCidade(cidade);
		}

		if (cliente.getNome() != null && cliente.getCidade() != null) {
			clienteService.saveOrUpdateCliente(cliente);
		} else {
			System.out.println("Nome ou Cidade são campos de preenchimento obrigatórios.");
			cliente = null;
			--incrementoId;
		}
	}

	public void deletar() {
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = clienteService.clienteById(scanner.nextInt());
		if (cliente != null)
			clienteService.deletar(cliente);
		else
			System.out.println("Código inválido.");
	}

	public void clienteById() {
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = clienteService.clienteById(scanner.nextInt());
		if (cliente != null)
			System.out.println(cliente.getId() + " " + cliente.getNome() + " " + cliente.getCidade() + " ");
		else
			System.out.println("Código inválido.");
	}

}
