package br.com.spassu.cliente.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {

	private Date data;
	private Double valor;
	private Double valorImposto;

	private List<Cliente> cliente = new ArrayList<>();

	public Compra() {
	}

	public Compra(Cliente c) {
		cliente.add(c);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(Double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	
}
