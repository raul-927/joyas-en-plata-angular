package uy.com.jep.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.jep.domains.Cliente;
import uy.com.jep.domains.SearchClientes;
import uy.com.jep.mybatis.mappers.ClientesMapper;


@Service("pacienteService")
public class ClienteServiceImpl implements ClienteService {

private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private ClientesMapper clientesMapper;
	
	@Override
	public List<Cliente> findAllClientes()
	{
		logger.debug("findAllClientes: ");
		
		List<Cliente> clientes = clientesMapper.findAllClientes();
		return clientes;
		
	}
	
	@Override
	public Cliente findClienteById(int id){
		logger.debug("findClienteById :"+id);
		
		return clientesMapper.findClienteById(id);
	}
	
	@Override
	public Cliente findClienteByCedula(int cedula)
	{
		logger.debug("findClienteByCedula :"+cedula);
		
		Cliente cliente = null;
		if(cedula ==0)
		{
			System.out.println("Cedula = 0");
			return null;
		}
		cliente = clientesMapper.findClienteByCedula(cedula);
		return cliente;
		
		
		
	}
	
	@Override
	public List<Cliente> findClientesByNombre(String nombre)
	{
		logger.debug("findPacientesByNombre :"+nombre);
		
		List<Cliente> clientes = clientesMapper.findClientesByNom(nombre);
		return clientes;
	}
	
	@Override
	public List<Cliente> findClientesByApellido(String apellido)
	{
		logger.debug("findClientesByApellido :"+apellido);
		
		List<Cliente> clientes = clientesMapper.findClientesByApellido(apellido);
		return clientes;
	}
	
	@Override
	public void insertCliente(Cliente cliente)
	{
		logger.debug("insertCliente :"+cliente);
		
		clientesMapper.insertCliente(cliente);
	}
	
	@Override
	public void updateCliente(Cliente cliente)
	{
		logger.debug("updateCliente :"+cliente);
		
		clientesMapper.updateCliente(cliente);
	}
	
	@Override
	public void deleteCliente(int id)
	{
		logger.debug("deletePacientes :"+id);
		
		clientesMapper.deleteCliente(id);
	}

	@Override
	public List<Cliente> findClientes(SearchClientes searchClientes){
		logger.debug("findClientes :"+ searchClientes);
		List<Cliente> clientes = null;
		
		if(searchClientes.getCedula()!=0){
			 clientes =  clientesMapper.findClienteByCedulaList(searchClientes.getCedula());
		}
		else if(searchClientes.getCedula() == 0 
				&& !searchClientes.getPacNombre().equals("") 
				&& searchClientes.getPacApellido().equals("")){
			clientes = clientesMapper.findClientesByNom(searchClientes.getPacNombre());
		}
		else if(searchClientes.getCedula() == 0  
				&& searchClientes.getPacNombre().equals("") 
				&& !searchClientes.getPacApellido().equals("")){
			
			clientes = clientesMapper.findClientesByApellido(searchClientes.getPacApellido());
		}
		else if(searchClientes.getCedula() == 0 
				&& !searchClientes.getPacNombre().equals("")
				&& !searchClientes.getPacApellido().equals("")){
			
			clientes = clientesMapper.findClientesByNombreAndApellido(searchClientes.getPacNombre(), searchClientes.getPacApellido());
		}
		else if(searchClientes.getCedula()== 0 
				&& searchClientes.getPacNombre().equals("") 
				&& searchClientes.getPacApellido().equals("")){
			
			clientes = clientesMapper.findAllClientes();
		}
		
		return clientes;
		
	}

	@Override
	public List<Cliente> findClientesByNombreAndApellido(String nombre,
			String apellido) {
		
		List<Cliente> clientes = clientesMapper.findClientesByNombreAndApellido(nombre, apellido);
		
		return clientes;
	}

	@Override
	public void deleteClienteByCedula(int cedula) {
		clientesMapper.deleteClienteByCedula(cedula);
		
	}

}
