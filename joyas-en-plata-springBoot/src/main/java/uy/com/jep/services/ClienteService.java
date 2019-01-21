package uy.com.jep.services;

import java.util.List;

import uy.com.jep.domains.Cliente;
import uy.com.jep.domains.SearchClientes;


public interface ClienteService {
	Cliente findClienteById(int id);
	Cliente findClienteByCedula(int cedula);
	
	List<Cliente> findAllClientes();
	List<Cliente> findClientesByNombre(String nombre);
	List<Cliente> findClientesByApellido(String apellido);
	List<Cliente> findClientes(SearchClientes searchClientes);
	List<Cliente> findClientesByNombreAndApellido(String nombre, String apellido);
	void insertCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void deleteCliente(int id);
	void deleteClienteByCedula(int cedula);
	

}
