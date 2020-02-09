package br.com.unipe.posweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.posweb.entity.Hospital;
import br.com.unipe.posweb.repository.HospitalRepository;

@Service
public class HospitalService implements CrudInterface<Hospital> {

    @Autowired
    private HospitalRepository hospitalRepository;
    
	public HospitalService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Hospital> findAll() {
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@Override
	public Hospital findById(long id) {
		return hospitalRepository.findById(id).get();
	}

	public Hospital findByNome(String nome) {
		return hospitalRepository.findByNomeIgnoreCase(nome);
	}

	@Override
	public void delete(Hospital hospital) {
		hospitalRepository.delete(hospital);		
	}

}
