package br.com.unipe.posweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Enfermeira;

@Repository
public interface EnfermeiraRepository extends JpaRepository<Enfermeira, Long>{
	Enfermeira findByNomeIgnoreCase(String nome);
}