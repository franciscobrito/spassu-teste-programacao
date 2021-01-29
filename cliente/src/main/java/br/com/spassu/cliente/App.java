package br.com.spassu.cliente;

import java.util.Scanner;

import br.com.spassu.cliente.controller.ClienteController;

public class App {

	private ClienteController clienteController = new ClienteController();
	
	public static void main(String[] args) throws Exception {
		App app = new App();
		int opcaoMenu;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			app.listaMenu();
			opcaoMenu = scanner.nextInt();
			app.chamaOperacao(opcaoMenu);
		}
	}
	
	public void chamaOperacao(int opcaoMenu) {
		switch (opcaoMenu) {
		case 1:
			clienteController.listarCliente();
			break;
		case 2:
			clienteController.cadastro();
			break;
		case 9:
			System.out.println("Finalizado");
			System.exit(0);
		default:
			System.out.println("Opção inválida");
			break;
		}
	}
	
	public void listaMenu() {
		System.out.println("Selecione a opção:");
		System.out.println("1 - Listar Clientes");
		System.out.println("2 - Incluir Cliente");
		System.out.println("9 - Sair");
	}

}
