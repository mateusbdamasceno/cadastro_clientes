package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Cliente;
import br.com.dao.ClienteDAO;
import br.com.db.ConnectionFactory;

public class ClienteDAO {
	
	private ConnectionFactory con;

	public List<Cliente> getClientes() {
		PreparedStatement stmt = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			String sql = "select * from clientes ";
			stmt = con.createConnectonDb().prepareStatement(sql);
			
		    ResultSet rs = (ResultSet) stmt.executeQuery();

		    
		    while (rs.next()) {
		    	Cliente cliente = new Cliente();
		    	cliente.setNome(rs.getString("NOME"));
		    	cliente.setCpf(rs.getString("CPF"));
		    	cliente.setEndereco(rs.getString("ENDERECO"));
		    	
		    	clientes.add(cliente);
		    }
		    rs.close();
	        stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
        return clientes;
	}

	public Cliente insertCliente(Cliente cliente) {
		PreparedStatement stmt = null;
		
 		try {
 			String sql = "insert into clientes(nome, cpf, endereco)values(?,?,?)";
 			stmt = con.createConnectonDb().prepareStatement(sql);
 	 		stmt.setString(1, cliente.getNome());
 	 		stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEndereco());
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

	public void deleteCliente(Integer clientid) {
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

	public Cliente updateCliente(Cliente cliente) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "update clientes set nome=?, cpf=?, endereco=?";
			stmt = con.createConnectonDb().prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEndereco());
			
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
