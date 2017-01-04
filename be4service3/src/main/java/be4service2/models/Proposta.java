package be4service2.models;

import java.math.BigDecimal;

public class Proposta {
	private Servico servico;
	private Profissional profissional;
	private double valorProposta;
	
	
	public Proposta(Servico servico, Profissional profissional, double valorProposta) {
		super();
		this.servico = servico;
		this.profissional = profissional;
		this.valorProposta = valorProposta;
	}
	
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	public double getValorProposta() {
		return valorProposta;
	}
	public void setValorProposta(double valorProposta) {
		this.valorProposta = valorProposta;
	}
	
	
	
}
