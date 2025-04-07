package ucentral.software.PhoenixStore.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.software.PhoenixStore.entidades.Productos;
import ucentral.software.PhoenixStore.repositorios.RepoProducto;

import java.util.List;

@Service
public class ServicioProducto {

    @Autowired
    private RepoProducto repoProducto;

    public List<Productos> obtenerTodos() {
        return repoProducto.findAll();

    }
    public List<Productos> obtenerTodosLosProductos() {
        return repoProducto.findAll();
    }
    public List<Productos> buscarPorNombre(String query) {
        return repoProducto.findByPronombreContainingIgnoreCase(query);
    }

}

