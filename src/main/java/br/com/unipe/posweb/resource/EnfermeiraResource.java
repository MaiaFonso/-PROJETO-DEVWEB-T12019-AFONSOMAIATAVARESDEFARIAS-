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

import br.com.unipe.posweb.entity.Enfermeira;
import br.com.unipe.posweb.service.EnfermeiraService;

@RestController
@RequestMapping("/api")
public class EnfermeiraResource {

	@Autowired
	private EnfermeiraService enfermeiraService;

	@GetMapping("/enfermeira/listar")
	public List<Enfermeira> getAll() {
		return enfermeiraService.findAll();
	}

	@GetMapping("/enfermeira/buscar/{id}")
	public Enfermeira getById(@PathVariable Long id) {
		return enfermeiraService.findById(id);
	}

	@GetMapping("/enfermeira/buscarPorNome/{nome}")
	public Enfermeira getByNome(@PathVariable String nome) {
		return enfermeiraService.findByNome(nome);
	}

    @PostMapping("/enfermeira/cadastrar")
    public ResponseEntity<Enfermeira>
    save(@Valid @RequestBody Enfermeira enfermeira) {
    	enfermeiraService.save(enfermeira);
        return ResponseEntity.ok(enfermeira);
    }

    @PutMapping("/enfermeira/alterar")
    public ResponseEntity update(@Valid @RequestBody Enfermeira enfermeira) {
    	enfermeiraService.save(enfermeira);
        return ResponseEntity.ok().body(enfermeira);
    }

    @DeleteMapping("/enfermeira/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Enfermeira enfermeira) {
    	enfermeiraService.delete(enfermeira);
        return  ResponseEntity.ok().body("Enfermeira de id " + enfermeira.getId() + " excluido.");
    }

}