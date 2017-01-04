package be4service2.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
	
	@ManyToOne
	@JoinColumn(name="id_contratante")
	private Pessoa contratante;
	@ManyToOne
	@JoinColumn(name="id_profissional")
	private Pessoa profissional;
	
	private String status;

	public Servico(Integer idServico, Contratante contratante) {
		super();
		this.idServico = idServico;
		this.contratante = contratante;
	}


	public Servico(){
		super();
	}


	public Servico(Servico s,Contratante contratante) {
		super();
		this.contratante = contratante;
	}


	public Integer getIdServico() {
		return idServico;
	}


	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}


	

	@JsonIgnore
	public Pessoa getContratante() {
		return contratante;
	}


	public void setContratante(Pessoa contratante) {
		this.contratante = contratante;
	}

	@JsonIgnore
	public Pessoa getProfissional() {
		return profissional;
	}


	public void setProfissional(Pessoa profissional) {
		this.profissional = profissional;
	}


	@Override
	public String toString() {
		return "Servico [idServico=" + idServico + ", contratante=" + contratante + ", profissional=" + profissional
				+ "]";
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
