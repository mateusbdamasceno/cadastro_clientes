package br.com.service;

import java.util.ArrayList;
import java.util.List;

import br.com.bean.Cliente;
import br.com.dao.ClienteDAO;

public class ClienteService{
	
	ClienteDAO dao = new ClienteDAO();

	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = dao.getClientes();
		return clientes;
	}

	public Cliente insertCliente(Cliente cliente) {
		Cliente clienteReturn = dao.insertCliente(cliente);
		return clienteReturn;
	}

	public void deleteCliente(Integer clientid) {
		dao.deleteCliente(clientid);	
	}

	public Cliente updateCliente(Cliente cliente) {
		Cliente clienteReturn = dao.updateCliente(cliente);
		return clienteReturn;
	}

}
