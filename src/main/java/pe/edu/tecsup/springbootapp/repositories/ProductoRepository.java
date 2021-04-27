package pe.edu.tecsup.springbootapp.repositories;

import java.util.List;

import pe.edu.tecsup.springbootapp.models.Producto;

public interface ProductoRepository {

	
	public List<Producto> listar() throws Exception;
	public void registrar(Producto producto) throws Exception;
	public void eliminar(Long id) throws Exception;

}
