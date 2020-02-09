package br.com.unipe.posweb.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipe.posweb.entity.Hospital;
import br.com.unipe.posweb.service.HospitalService;

@RestController
@RequestMapping("/api")
public class HospitalResource {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/hospital/listar")
	public List<Hospital> getAll() {
		return hospitalService.findAll();
	}

	@GetMapping("/hospital/buscar/{id}")
	public Hospital getById(@PathVariable Long id) {
		return hospitalService.findById(id);
	}

	@GetMapping("/hospital/buscarPorNome/{nome}")
	public Hospital getByNome(@PathVariable String nome) {
		return hospitalService.findByNome(nome);
	}

    @PostMapping("/hospital/cadastrar")
    public ResponseEntity<Hospital>
    save(@Valid @RequestBody Hospital hospital) {
    	hospitalService.save(hospital);
        return ResponseEntity.ok(hospital);
    }

    @PutMapping("/hospital/alterar")
    public ResponseEntity update(@Valid @RequestBody Hospital hospital) {
    	hospitalService.save(hospital);
        return ResponseEntity.ok().body(hospital);
    }

    @DeleteMapping("/hospital/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Hospital hospital) {
    	hospitalService.delete(hospital);
        return  ResponseEntity.ok().body("Hospital de id " + hospital.getId() + " excluido.");
    }

}