package br.com.unipe.posweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	Hospital findByNomeIgnoreCase(String nome);
}
