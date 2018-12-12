package uy.com.jep.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import uy.com.jep.domains.Cliente;
import uy.com.jep.domains.SearchClientes;

public interface ClientesMapper {
	
	@Select("SELECT * FROM clientes")
	@ResultMap("uy.com.cvaucher.ms.pacientes.mybatis.mapper.PacientesMapper.PacientesResult")
	List<Cliente> findAllClientes();
	
	
	/*@Select("SELECT * FROM pacientes " +
			"WHERE cedula = #{cedula} " +
			"OR pac_nombre = #{pacNombre} " +
			"OR pac_apellido = #{pacApellido} " +
			"OR(pac_nombre = #{pacNombre} AND pac_apellido = #{pacApellido})")
	@ResultMap("uy.com.cvaucher.services.mappers.PacientesMapper.PacientesResult")*/
	List<Cliente> findClientes(SearchClientes searchClientes);
	
	@Select("SELECT * FROM pacientes WHERE id = #{id}")
	@ResultMap("uy.com.cvaucher.ms.pacientes.mybatis.mapper.PacientesMapper.PacientesResult")
	Cliente findClienteById(int id);
	
	@Select("SELECT * FROM pacientes WHERE nombre = #{nombre:VARCHAR}")
	@ResultMap("uy.com.cvaucher.ms.pacientes.mybatis.mapper.PacientesMapper.PacientesResult")
	List<Cliente> findClientesByNom(String nombre);
	
	@Select("SELECT * FROM pacientes WHERE apellido = #{apellido:VARCHAR}")
	@ResultMap("uy.com.cvaucher.ms.pacientes.mybatis.mapper.PacientesMapper.PacientesResult")
	List<Cliente> findClientesByApellido(String apellido);
	
	
	@Select("SELECT * FROM pacientes WHERE cedula = #{cedula}")
	@ResultMap("uy.com.cvaucher.ms.pacientes.mybatis.mapper.PacientesMapper.PacientesResult")
	Cliente findClienteByCedula(int cedula);
	
	@Select("SELECT * FROM pacientes WHERE cedula = #{cedula}")
	@ResultMap("uy.com.cvaucher.ms.pacientes.mybatis.mapper.PacientesMapper.PacientesResult")
	List<Cliente> findClienteByCedulaList(int cedula);
	
	
	@Select(("SELECT * FROM pacientes WHERE nombre = #{nombre}"
			+ " AND apellido = #{apellido}"))
	@ResultMap("uy.com.cvaucher.ms.pacientes.mybatis.mapper.PacientesMapper.PacientesResult")
	List<Cliente> findClientesByNombreAndApellido(@Param("nombre")String nombre, @Param("apellido") String apellido);
	
	@Insert("INSERT INTO pacientes " +
						"(nombre, " +
						"apellido, " +
						"cedula, " +
						"ocupacion, " +
						"sociedad_medica, " +
						"emergencia_movil) " +
				"VALUES (#{nombre}, " +
						"#{apellido}, " +
						"#{cedula}, " +
						"#{ocupacion}, " +
						"#{sociedadMedica}, " +
						"#{emergenciaMovil} " +
						")")
	@Options(useGeneratedKeys=true, keyProperty="pacId") 
	Cliente insertCliente(Cliente cliente);
	
	
	@Update("UPDATE pacientes " +
			"SET 	nombre =#{nombre}, " +
					"apellido =#{apellido}, " +
					"cedula =#{cedula}, " +			
					"ocupacion = #{ocupacion}, " +
					"sociedad_medica =#{sociedadMedica}, " +
					"emergencia_movil =#{emergenciaMovil} " +
					
			"WHERE 	 cedula = #{cedula}")
	Cliente updateCliente(Cliente cliente);
	
	@Delete("DELETE FROM pacientes WHERE  id =#{pacId}")
	void deleteCliente(int id);
	
	@Delete("DELETE FROM pacientes WHERE cedula = #{cedula}")
	void deleteClienteByCedula(int cedula);
	
}
