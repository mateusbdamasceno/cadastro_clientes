package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Client;
import br.com.dao.ClientDAO;
import br.com.db.ConnectionFactory;

public class ClientDAO {
	
	private ConnectionFactory con;

	public List<Client> getClients() {
		PreparedStatement stmt = null;
		List<Client> clients = new ArrayList<Client>();
		
		try {
			String sql = "select * from clientes ";
			stmt = con.createConnectonDb().prepareStatement(sql);
			
		    ResultSet rs = (ResultSet) stmt.executeQuery();

		    
		    while (rs.next()) {
		    	Client cliente = new Client();
		    	cliente.setName(rs.getString("NAME"));
		    	cliente.setCpf(rs.getString("CPF"));
		    	cliente.setAddress(rs.getString("ADDRESS"));
		    	
		    	clients.add(cliente);
		    }
		    rs.close();
	        stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
        return clients;
	}

	public Client insertClient(Client cliente) {
		PreparedStatement stmt = null;
		
 		try {
 			String sql = "insert into clientes(name, cpf, address)values(?,?,?)";
 			stmt = con.createConnectonDb().prepareStatement(sql);
 	 		stmt.setString(1, cliente.getName());
 	 		stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getAddress());
			stmt.execute();
	 		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
		return null;
	}

	public void deleteClient(Integer clientid) {
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM  clientes WHERE id= ?";
			stmt = con.createConnectonDb().prepareStatement(sql);
			stmt.execute();
	 		stmt.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Client updateClient(Client cliente) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "update clientes set name=?, cpf=?, address=?";
			stmt = con.createConnectonDb().prepareStatement(sql);
			stmt.setString(1, cliente.getName());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getAddress());
			
			stmt.execute();
	 		stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}

}
