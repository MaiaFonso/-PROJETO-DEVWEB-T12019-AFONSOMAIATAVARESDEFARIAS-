package br.com.unipe.posweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipe.posweb.entity.Ambulancia;

@Repository
public interface AmbulanciaRepository extends JpaRepository<Ambulancia, Long>{
	Ambulancia findByNumeroIgnoreCase(String numero);
}
