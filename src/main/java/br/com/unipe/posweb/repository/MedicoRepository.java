package br.com.unipe.posweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
	Medico findByNomeIgnoreCase(String nome);
}