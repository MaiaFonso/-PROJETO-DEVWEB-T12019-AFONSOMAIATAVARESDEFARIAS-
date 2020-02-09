package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Enfermeira;
import br.com.unipe.posweb.repository.EnfermeiraRepository;

@Service
public class EnfermeiraService implements CrudInterface<Enfermeira> {

    @Autowired
    private EnfermeiraRepository enfermeiraRepository;
    
	public EnfermeiraService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Enfermeira> findAll() {
		return enfermeiraRepository.findAll();
	}

	@Override
	public Enfermeira save(Enfermeira enfermeira) {
		return enfermeiraRepository.save(enfermeira);
	}

	@Override
	public Enfermeira findById(long id) {
		return enfermeiraRepository.findById(id).get();
	}

	public Enfermeira findByNome(String nome) {
		return enfermeiraRepository.findByNomeIgnoreCase(nome);
	}

	@Override
	public void delete(Enfermeira enfermeira) {
		enfermeiraRepository.delete(enfermeira);		
	}

}
