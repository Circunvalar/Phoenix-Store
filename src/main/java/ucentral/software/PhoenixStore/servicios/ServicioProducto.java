package ucentral.software.PhoenixStore.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.software.PhoenixStore.entidades.Productos;
import ucentral.software.PhoenixStore.repositorios.RepoProducto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ServicioProducto {

        @Autowired
        private static RepoProducto repoProducto;

        public static List<Productos> obtenerTodosLosProductos() {
            return (List<Productos>) repoProducto.findAll();
        }
}
