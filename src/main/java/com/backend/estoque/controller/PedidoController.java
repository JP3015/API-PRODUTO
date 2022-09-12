package com.backend.estoque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backend.estoque.model.Pedido;
import com.backend.estoque.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> GetAll() {
		return ResponseEntity.ok(pedidoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getById(@PathVariable long id) {
		return pedidoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/pesquisa/{nome}")
	public ResponseEntity<List<Pedido>> getByTitle(@PathVariable String nome) {
		return ResponseEntity.ok(pedidoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Pedido> post(@Valid @RequestBody Pedido pedido) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}

	@PutMapping
	public ResponseEntity<Pedido> put(@Valid @RequestBody Pedido pedido) {
		if (pedidoRepository.existsById(pedido.getId())) {
			return ResponseEntity.status(HttpStatus.OK).body(pedidoRepository.save(pedido));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		java.util.Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		if (pedido.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		pedidoRepository.deleteById(id);
	}
}