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

import br.com.unipe.posweb.entity.Medico;
import br.com.unipe.posweb.service.MedicoService;

@RestController
@RequestMapping("/api")
public class MedicoResource {

	@Autowired
	private MedicoService medicoService;

	@GetMapping("/medico/listar")
	public List<Medico> getAll() {
		return medicoService.findAll();
	}

	@GetMapping("/medico/buscar/{id}")
	public Medico getById(@PathVariable Long id) {
		return medicoService.findById(id);
	}

	@GetMapping("/medico/buscarPorNome/{nome}")
	public Medico getByNome(@PathVariable String nome) {
		return medicoService.findByNome(nome);
	}

    @PostMapping("/medico/cadastrar")
    public ResponseEntity<Medico>
    save(@Valid @RequestBody Medico medico) {
    	medicoService.save(medico);
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/medico/alterar")
    public ResponseEntity update(@Valid @RequestBody Medico medico) {
    	medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }

    @DeleteMapping("/medico/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Medico medico) {
    	medicoService.delete(medico);
        return  ResponseEntity.ok().body("Medico de id " + medico.getId() + " excluido.");
    }

}