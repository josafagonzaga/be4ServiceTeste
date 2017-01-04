package be4service2.service;

import java.util.List;

import be4service2.models.Contratante;
import be4service2.models.ContratanteProfissional;
import be4service2.models.Profissional;
import be4service2.models.Servico;

public interface ServicoService {

	List<Servico> all();

	void save(Servico servico);

	Servico findById(Integer id);

	void remove(Servico servico);

	void update(Servico servico);
	
	void criarServico(Contratante contratante,Servico servico);
	
	void criarServico(ContratanteProfissional contratante,Servico servico);
	
	void selecionarProfissional(Profissional profissional,Servico servico);
	
	void selecionarProfissional(ContratanteProfissional profissional,Servico servico);
	
	void aceitarServico(Integer id,Integer resposta);
	
}