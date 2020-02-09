package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Medico;
import br.com.unipe.posweb.repository.MedicoRepository;

@Service
public class MedicoService implements CrudInterface<Medico> {

    @Autowired
    private MedicoRepository medicoRepository;
    
	public MedicoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Medico> findAll() {
		return medicoRepository.findAll();
	}

	@Override
	public Medico save(Medico medico) {
		return medicoRepository.save(medico);
	}

	@Override
	public Medico findById(long id) {
		return medicoRepository.findById(id).get();
	}

	public Medico findByNome(String nome) {
		return medicoRepository.findByNomeIgnoreCase(nome);
	}

	@Override
	public void delete(Medico medico) {
		medicoRepository.delete(medico);		
	}

}
