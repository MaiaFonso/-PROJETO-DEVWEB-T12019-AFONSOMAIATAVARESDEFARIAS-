package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Paciente;
import br.com.unipe.posweb.repository.PacienteRepository;

@Service
public class PacienteService implements CrudInterface<Paciente> {

    @Autowired
    private PacienteRepository pacienteRepository;
    
	public PacienteService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente save(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public Paciente findById(long id) {
		return pacienteRepository.findById(id).get();
	}

	public Paciente findByNome(String nome) {
		return pacienteRepository.findByNomeIgnoreCase(nome);
	}

	@Override
	public void delete(Paciente paciente) {
		pacienteRepository.delete(paciente);		
	}

}
