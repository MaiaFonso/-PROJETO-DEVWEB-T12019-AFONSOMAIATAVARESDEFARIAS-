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

import br.com.unipe.posweb.entity.Paciente;
import br.com.unipe.posweb.service.PacienteService;

@RestController
@RequestMapping("/api")
public class PacienteResource {

	@Autowired
	private PacienteService pacienteService;

	@GetMapping("/paciente/listar")
	public List<Paciente> getAll() {
		return pacienteService.findAll();
	}

	@GetMapping("/paciente/buscar/{id}")
	public Paciente getById(@PathVariable Long id) {
		return pacienteService.findById(id);
	}

	@GetMapping("/paciente/buscarPorNome/{nome}")
	public Paciente getByNome(@PathVariable String nome) {
		return pacienteService.findByNome(nome);
	}

    @PostMapping("/paciente/cadastrar")
    public ResponseEntity<Paciente>
    save(@Valid @RequestBody Paciente paciente) {
    	pacienteService.save(paciente);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/paciente/alterar")
    public ResponseEntity update(@Valid @RequestBody Paciente paciente) {
    	pacienteService.save(paciente);
        return ResponseEntity.ok().body(paciente);
    }

    @DeleteMapping("/paciente/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Paciente paciente) {
    	pacienteService.delete(paciente);
        return  ResponseEntity.ok().body("Paciente de id " + paciente.getId() + " excluido.");
    }

}