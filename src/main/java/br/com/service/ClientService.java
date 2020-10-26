package br.com.service;

import java.util.ArrayList;
import java.util.List;

import br.com.bean.Client;
import br.com.dao.ClientDAO;

public class ClientService{
	
	ClientDAO dao = new ClientDAO();

	public List<Client> getClients() {
		List<Client> clientes = new ArrayList<Client>();
		clientes = dao.getClients();
		return clientes;
	}

	public Client insertClient(Client client) {
		Client clientReturn = dao.insertClient(client);
		return clientReturn;
	}

	public void deleteClient(Integer clientid) {
		dao.deleteClient(clientid);	
	}

	public Client updateClient(Client client) {
		Client clientReturn = dao.updateClient(client);
		return clientReturn;
	}

}
