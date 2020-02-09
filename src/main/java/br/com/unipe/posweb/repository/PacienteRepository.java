package br.com.unipe.posweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	Paciente findByNomeIgnoreCase(String nome);
}

