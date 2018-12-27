package uy.com.jep.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import uy.com.jep.services.ClienteService;

/*
import javax.sql.DataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
*/
/**
 * @author Raul Hernandez
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("uy.com.jep")
public class RootContextConfig {
	

	@Autowired
	private ClienteService clienteService;
	
	@Bean(name="/jep.clientes")
	public HttpInvokerServiceExporter httpPacientesService() {
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(clienteService);
		httpInvokerServiceExporter.setServiceInterface(ClienteService.class);
		return httpInvokerServiceExporter;
	}
	
	
	
	
}
