package br.com.spassu.cliente;

import java.util.Scanner;

import br.com.spassu.cliente.controller.ClienteController;
import br.com.spassu.cliente.controller.CompraController;
import br.com.spassu.cliente.model.Cliente;

public class App {

	private ClienteController clienteController = new ClienteController();
	private CompraController compraController = new CompraController();

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
		case 3:
			clienteController.atualizar();
			break;
		case 4:
			clienteController.deletar();
			break;
		case 5:
			clienteController.clienteById();
			break;
		case 6:
			Cliente cliente = clienteController.getCliente();
			compraController.cadastro(cliente);
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
		System.out.println("3 - Alterar Cliente");
		System.out.println("4 - Excluir Cliente");
		System.out.println("5 - Consultar Cliente");
		System.out.println("6 - Incluir Compra");
		System.out.println("9 - Sair");
	}

}
