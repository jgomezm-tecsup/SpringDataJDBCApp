package pe.edu.tecsup.springbootapp;

/*
@Autowired 
@Controller     
@Service   
@Repository       
            
Spring Data :  Annotaciones

  - Spring Data JDBC
  - Spring Data JPA

*/


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.edu.tecsup.springbootapp.models.Categoria;
import pe.edu.tecsup.springbootapp.models.Producto;
import pe.edu.tecsup.springbootapp.services.CategoriaService;
import pe.edu.tecsup.springbootapp.services.ProductoService;

@SpringBootApplication
public class SpringDataJdbcAppApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(SpringDataJdbcAppApplication.class);

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	ProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Invocando categorias");
		List<Categoria> cats = categoriaService.listar();
		log.info("" + cats);

		List<Categoria> categorias = categoriaService.listar();

		for (Categoria cat : categorias)
			log.info("--> " + cat);

		log.info(" ------------------------------------- ");

		List<Producto> productos = productoService.listar();

		for (Producto producto : productos)
			log.info("--> " + producto);

		log.info(" ------------------------------------- ");

		Producto productoNuevo = new Producto();
		productoNuevo.setCategorias_id(2L);
		productoNuevo.setNombre("Kingstone");
		productoNuevo.setDescripcion("Kingstone 64GB DDR3");
		productoNuevo.setPrecio(80.0);
		productoNuevo.setStock(12);

		productoService.registrar(productoNuevo);
		log.info(" - Producto Registrado --------------- ");
		log.info("--> " + productoNuevo);

		log.info(" ------------------------------------- ");
		productos = productoService.listar();

		log.info(" - Lista de Productos--------------- ");
		for (Producto producto : productos)
			log.info("--> " + producto);

		log.info(" ----------------------------------- ");

	}

}
