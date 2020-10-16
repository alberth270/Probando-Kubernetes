package com.banco.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.modelos.Banco;
import com.banco.modelos.Cuenta;
import com.banco.services.CuentaService;

import io.reactivex.Observable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/cuentas")
public class CuentaController {
	
	CuentaService cuentaService;
	
	public CuentaController(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}
	
	@GetMapping("/lista")
	public Observable<List<Cuenta>> obtenerLista() throws Exception{
		return cuentaService.findAll();
	}
	
	@GetMapping("/mostrar/{id}")
	public ResponseEntity<?> getCuentaId(@PathVariable Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(cuentaService.findById(id));
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> save(@RequestBody Cuenta entity) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(cuentaService.save(entity));
	}
	

}
