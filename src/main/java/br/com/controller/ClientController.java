package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bean.Client;
import br.com.service.ClientService;

	@Repository
	@RestController
	@RequestMapping("/cadastro")
	public class ClientController {
		
		@Autowired 
		private ClientService service;
	
		@GetMapping
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<?> findAll() {
	        List<Client> clients = service.getClients();
	        return ResponseEntity.ok(clients);
		}
	
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<?> create(@RequestBody Client client) {
	    	client = service.insertClient(client);
	    	return ResponseEntity.ok(client);
	    }
    
	    @DeleteMapping
	    public ResponseEntity<?> delete(@RequestBody Integer id) {
	    	service.deleteClient(id);
	    	return ResponseEntity.ok("Cliente deletado com sucesso.");
	    }
	    
	    @PutMapping
	    public ResponseEntity<?> update(@RequestBody Client client) {
	    	service.updateClient(client);
	    	return ResponseEntity.ok(client);
	    }

}
