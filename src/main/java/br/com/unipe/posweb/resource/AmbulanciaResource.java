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

import br.com.unipe.posweb.entity.Ambulancia;
import br.com.unipe.posweb.service.AmbulanciaService;

@RestController
@RequestMapping("/api")
public class AmbulanciaResource {

	@Autowired
	private AmbulanciaService ambulanciaService;

	@GetMapping("/ambulancia/listar")
	public List<Ambulancia> getAll() {
		return ambulanciaService.findAll();
	}

	@GetMapping("/ambulancia/buscar/{id}")
	public Ambulancia getById(@PathVariable Long id) {
		return ambulanciaService.findById(id);
	}

	@GetMapping("/ambulancia/buscarPorNome/{nome}")
	public Ambulancia getByNome(@PathVariable String nome) {
		return ambulanciaService.findByNome(nome);
	}

    @PostMapping("/ambulancia/cadastrar")
    public ResponseEntity<Ambulancia>
    save(@Valid @RequestBody Ambulancia ambulancia) {
    	ambulanciaService.save(ambulancia);
        return ResponseEntity.ok(ambulancia);
    }

    @PutMapping("/ambulancia/alterar")
    public ResponseEntity update(@Valid @RequestBody Ambulancia ambulancia) {
    	ambulanciaService.save(ambulancia);
        return ResponseEntity.ok().body(ambulancia);
    }

    @DeleteMapping("/ambulancia/deletar")
    public ResponseEntity<String> delete(@Valid @RequestBody Ambulancia ambulancia) {
    	ambulanciaService.delete(ambulancia);
        return  ResponseEntity.ok().body("Ambulancia de id " + ambulancia.getId() + " excluido.");
    }

}