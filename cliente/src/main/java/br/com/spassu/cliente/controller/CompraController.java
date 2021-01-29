package br.com.spassu.cliente.controller;

import java.util.Date;
import java.util.Scanner;

import br.com.spassu.cliente.model.Cliente;
import br.com.spassu.cliente.model.Compra;
import br.com.spassu.cliente.service.CompraService;

public class CompraController {
	
	private CompraService compraService = new CompraService();
	
	public void cadastro(Cliente cliente) {
		Compra compra = new Compra();
		Scanner scanner = new Scanner(System.in);

		compra.setData(new Date());

		System.out.println("Valor: ");
		Double valor = scanner.nextDouble();
		if (valor != null) {
			compra.setValor(valor);
		}

		if (cliente.getId() > 0 && compra.getData() != null && compra.getValor() != null) {
			compra.setValorImposto(compraService.impostoCompra(cliente, compra.getValor()));
			compra.getCliente().add(cliente);
			compraService.cadastrar(compra);
		} else {
			System.out.println("IdCliente, Data e Valor são campos de preenchimento obrigatórios.");
			compra = null;
		}

	}

}
