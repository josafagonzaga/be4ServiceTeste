package be4service2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be4service2.daos.ServicoDao;
import be4service2.models.Contratante;
import be4service2.models.ContratanteProfissional;
import be4service2.models.Profissional;
import be4service2.models.Servico;


@Service
@Transactional
public class ServicolServiceImpl implements ServicoService {
	 @Autowired
	   private ServicoDao servicoDao;
	
	@Override
	public List<Servico> all() {
		
		return servicoDao.all();
	}

	@Override
	public void save(Servico servico) {
		 servicoDao.save(servico);
		
	}

	@Override
	public Servico findById(Integer id) {
		
		return servicoDao.findById(id);
	}

	@Override
	public void remove(Servico servico) {
		servicoDao.remove(servico);
		
	}

	@Override
	public void update(Servico servico) {
		servicoDao.update(servico);
		
	}

	@Override
	public void criarServico(Contratante contratante,Servico servico) {
		servico.setContratante(contratante);
		contratante.getServicosContratados().add(servico);
		servico.setStatus("Aberto");
		servicoDao.save(servico);
	}

	@Override
	public void selecionarProfissional(Profissional profissional, Servico servico) {
		if(profissional!=null){
			servico.setProfissional(profissional);
			profissional.getServicosPrestados().add(servico);
			servico.setStatus("Aguardando Aceitação do Profissional");
			servicoDao.update(servico);
		}else{
			try {
				throw new Exception("Profissional não cadastrado.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void criarServico(ContratanteProfissional contratanteProfissional, Servico servico) {
		servico.setContratante(contratanteProfissional);
		contratanteProfissional.getServicosContratados().add(servico);
		servico.setStatus("Aberto");
		servicoDao.save(servico);
		
	}

	@Override
	public void selecionarProfissional(ContratanteProfissional profissional, Servico servico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceitarServico(Integer id,Integer resposta) {
		//busca o servico
		Servico servico=servicoDao.findById(id);
		if(resposta==0){
			
			//muda o status
			servico.setStatus("Aberto");
			//cria um objeto profissional e seta o profissional do servico
			Profissional p=(Profissional) servico.getProfissional();
			//remove o serviço da lista do profissional
			p.getServicosPrestados().remove(servico.getIdServico());
			//remove o profissional do serviço
			servico.setProfissional(null);	
		}
		else{
			servico.setStatus("Em Andamento");
		}
		
	}


}
