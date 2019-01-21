package uy.com.jep.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.CrossOrigin;

import uy.com.jep.domains.Cliente;
import uy.com.jep.domains.SearchClientes;
import uy.com.jep.mybatis.sql.ClientesSQL;

public interface ClientesMapper {
	
	@SelectProvider(type= ClientesSQL.class, method ="findAllClientes")
	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
	List<Cliente> findAllClientes();
	
	
	@SelectProvider(type= ClientesSQL.class, method ="findClientes")
	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
	List<Cliente> findClientes(SearchClientes searchClientes);
	
	@SelectProvider(type= ClientesSQL.class, method ="findClienteById")
	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
	Cliente findClienteById(int id);
	
	@SelectProvider(type= ClientesSQL.class, method ="findClientesByApellido")
	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
	List<Cliente> findClientesByNom(String nombre);
	
	@SelectProvider(type= ClientesSQL.class, method ="findClientesByNom")
	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
	List<Cliente> findClientesByApellido(String apellido);
	
	
	@SelectProvider(type= ClientesSQL.class, method ="findClienteByCedula")
	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
	Cliente findClienteByCedula(@Param("cedula") int cedula);
	
//	@SelectProvider(type= ClientesSQL.class, method ="findClienteByCedulaList")
//	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
//	List<Cliente> findClienteByCedulaList(int cedula);
	
	
	@Select(("SELECT * FROM cliente WHERE nombre = #{nombre}"
			+ " AND apellido = #{apellido}"))
	@ResultMap("uy.com.jep.mybatis.mappers.ClientesMapper.ClientesResult")
	List<Cliente> findClientesByNombreAndApellido(@Param("nombre")String nombre, @Param("apellido") String apellido);
	
	@InsertProvider(type= ClientesSQL.class, method="insertCliente")
	@Options(useGeneratedKeys=true, keyProperty="id") 
	void insertCliente(@Param("cliente") Cliente cliente);
	
	
	@Update("UPDATE cliente " +
			"SET 	nombre =#{nombre}, " +
					"apellido =#{apellido}, " +
					"cedula =#{cedula}, " +			
					"ocupacion = #{ocupacion}, " +
			"WHERE 	 cedula = #{cedula}")
	void updateCliente(Cliente cliente);
	
	@Delete("DELETE FROM cliente WHERE  id =#{pacId}")
	void deleteCliente(int id);
	
	@Delete("DELETE FROM cliente WHERE cedula = #{cedula}")
	void deleteClienteByCedula(int cedula);
	
}
