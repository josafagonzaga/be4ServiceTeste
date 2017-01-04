package be4service2.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//teste git
//2

@Entity
@DiscriminatorValue(value="profissional")
public class Profissional extends Pessoa
{
	
	private Double avaliacaoProfissional=0.0;

	@OneToMany(mappedBy="profissional")
	private List<Servico> servicosPrestados;
	
	

	
	
	public Profissional() {
	
	}
	
	public Profissional(Integer id, String nome, Double avaliacaoProfissional) {
		super(id, nome);
		this.avaliacaoProfissional = avaliacaoProfissional;
	}
	public Profissional( String nome, Double avaliacaoProfissional) {
		super(nome);
		this.avaliacaoProfissional = avaliacaoProfissional;
	}

	
	
	//get set
	public Double getAvaliacaoProfissional() {
		return avaliacaoProfissional;
	}

	public void setAvaliacaoProfissional(Double avaliacaoProfissional) {
		this.avaliacaoProfissional = avaliacaoProfissional;
	}
	public List<Servico> getServicosPrestados() {
		return servicosPrestados;
	}
	public void setServicosPrestados(List<Servico> servicosPrestados) {
		this.servicosPrestados = servicosPrestados;
	}
	
	



  
   

}
