package com.banco.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.modelos.Banco;
import com.banco.services.BancoService;

import io.reactivex.Observable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/bancos")
public class BancoController {
	
	private BancoService bancoService;
	
	public BancoController( BancoService bancoService) {
		this.bancoService = bancoService;
	}
	
	@GetMapping("/lista bancos")
	public Observable<List<Banco>> obtenerLista() throws Exception{
		return bancoService.findAll();
	}
	
	@GetMapping("/mostrar/{id}")
	public Observable getBancoId(@PathVariable Long id) throws Exception{
		return bancoService.findById(id);
	}
	
	@GetMapping("/mostrar/codigo/{codigo}")
	public Observable getBancoCodigo(@PathVariable Integer codigo) throws Exception{
		return  bancoService.findByCodigo(codigo);
	}
	
	@GetMapping("/mostrar/nombre/{banco}")
	public Observable getBancoNombre(@PathVariable String banco) throws Exception{
		return  bancoService.findByNombre(banco);
	}
	
	
	
	@PostMapping("/agregar")
	public ResponseEntity<?> save(@RequestBody Banco entity) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(bancoService.save(entity));
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Banco entity) throws Exception{
		
		return ResponseEntity.status(HttpStatus.OK).body(bancoService.save(entity));
	}
	
	
	

}
