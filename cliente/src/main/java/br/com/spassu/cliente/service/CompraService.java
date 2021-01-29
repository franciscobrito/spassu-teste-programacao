package br.com.spassu.cliente.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.spassu.cliente.model.Cliente;
import br.com.spassu.cliente.model.Compra;

public class CompraService {

	List<Compra> compras = new ArrayList<>();

	DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	static double percentual10 = 0.1, percentual20 = 0.2;

	public List<Compra> listarCompras() {
		return compras;
	}
	
	public void cadastrar(Compra compra) {
		compras.add(compra);
		System.out.println(compra.getCliente().get(0).getId() + "; " + sdf.format(compra.getData()) + "; "
				+ format.format(compra.getValor()));
		System.out.println("Compara para o cliente " + compra.getCliente().get(0).getId() + " incluído");
	}
	
	public char ultimoCaractere(String nomeCidade) {
		if (nomeCidade != null && !nomeCidade.isEmpty()) {
			return nomeCidade.charAt(nomeCidade.length() - 1);
		}
		return (char) 0;
	}

	public Double impostoCompra(Cliente cliente, Double valor) {
		Double valorImposto = 0.0;
		switch (ultimoCaractere(cliente.getCidade())) {
		case 'a':
			valorImposto = percentual10 * valor;

			break;
		case 'o':
			valorImposto = percentual20 * valor;
			break;

		default:
			break;
		}
		return valorImposto;
	}
	
}
