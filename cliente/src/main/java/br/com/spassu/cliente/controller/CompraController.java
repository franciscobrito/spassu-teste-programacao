package br.com.spassu.cliente.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.spassu.cliente.model.Cliente;
import br.com.spassu.cliente.model.Compra;
import br.com.spassu.cliente.service.CompraService;

public class CompraController {
	
	private CompraService compraService = new CompraService();
	
	DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void listarCompra() {
		List<Compra> compras = compraService.listarCompras();
		if (!compras.isEmpty()) {

			compras.stream().sorted(Comparator.comparing(Compra::getData).reversed()).forEach(compra -> {
				System.out.println("| " + compra.getCliente().get(0).getId() + " | "
						+ compra.getCliente().get(0).getNome() + " | " + sdf.format(compra.getData()) + " | "
						+ format.format(compra.getValor()) + " |" + format.format(compra.getValorImposto()));
			});

		}

		Double valorTotal = compras.stream().map(x -> x.getValor()).reduce(0.0, Double::sum);
		System.out.println("| Total Compras: " + valorTotal + " |");

	}
	
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
