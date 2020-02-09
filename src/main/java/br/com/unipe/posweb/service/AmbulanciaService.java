package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Ambulancia;
import br.com.unipe.posweb.repository.AmbulanciaRepository;

@Service
public class AmbulanciaService implements CrudInterface<Ambulancia> {

    @Autowired
    private AmbulanciaRepository ambulanciaRepository;
    
	public AmbulanciaService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Ambulancia> findAll() {
		return ambulanciaRepository.findAll();
	}

	@Override
	public Ambulancia save(Ambulancia ambulancia) {
		return ambulanciaRepository.save(ambulancia);
	}

	@Override
	public Ambulancia findById(long id) {
		return ambulanciaRepository.findById(id).get();
	}

	public Ambulancia findByNome(String numero) {
		return ambulanciaRepository.findByNumeroIgnoreCase(numero);
	}

	@Override
	public void delete(Ambulancia ambulancia) {
		ambulanciaRepository.delete(ambulancia);		
	}

}
