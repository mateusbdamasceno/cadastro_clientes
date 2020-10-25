package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bean.Cliente;
import br.com.service.ClienteService;

	@Repository
	@RestController
	@RequestMapping("/cadastro")
	public class ClientesController {
		
		@Autowired 
		private ClienteService service;
	
		@GetMapping
		public List<Cliente> findAll() {
	        return service.getClientes();
	    }
	
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Cliente create(@RequestBody Cliente cliente) {
	    	cliente = service.insertCliente(cliente);
	        return cliente;
	    }
    
	    @DeleteMapping
	    public void delete(@RequestBody Integer id) {
	    	service.deleteCliente(id);
	    }
	    
	    @PutMapping
	    public void update(@RequestBody Cliente cliente) {
	    	service.updateCliente(cliente);
	    }

}
