package ucentral.software.PhoenixStore.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ucentral.software.PhoenixStore.servicios.ServicioAutentificacion;

@Controller
public class ControladorInicio {

    @Autowired
    private ServicioAutentificacion servicioAutentificacion;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("usu_username") String usu_username, @RequestParam("usu_contrasena") String usu_contrasena) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (usu_username == null || usu_username.isEmpty()) {
            modelAndView.addObject("error", "El nombre de usuario no puede estar vacío");
            return modelAndView;
        }

        boolean loginExitoso = servicioAutentificacion.inicioSesion(usu_username, usu_contrasena);
        if (loginExitoso) {
            return new ModelAndView("redirect:/tienda");
        } else {
            modelAndView.addObject("error", "Credenciales incorrectas");
            return modelAndView;
        }
    }

    @GetMapping("/tienda")
    public String mostrarTienda() {
        return "tienda";
    }
}