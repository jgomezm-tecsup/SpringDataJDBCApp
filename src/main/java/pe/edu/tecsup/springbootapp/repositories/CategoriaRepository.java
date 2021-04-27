package pe.edu.tecsup.springbootapp.repositories;

import java.util.List;
import pe.edu.tecsup.springbootapp.models.Categoria;

public interface CategoriaRepository {
	
	public List<Categoria> listar() throws Exception;
}
