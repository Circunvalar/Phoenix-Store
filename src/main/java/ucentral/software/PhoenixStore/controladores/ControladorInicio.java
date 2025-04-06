package ucentral.software.PhoenixStore.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ucentral.software.PhoenixStore.entidades.Productos;
import ucentral.software.PhoenixStore.servicios.ServicioProducto;

import java.util.List;

@Controller
public class ControladorInicio {

    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping("/tienda")
    public String mostrarTienda() {
        return "home";
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Productos> productos = ServicioProducto.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "productos"; // productos.html
    }

    @GetMapping("/")
    public String mostrarProductos() {
        return "index";
    }
}