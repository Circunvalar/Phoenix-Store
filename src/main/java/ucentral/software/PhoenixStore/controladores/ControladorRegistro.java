package ucentral.software.PhoenixStore.controladores;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ucentral.software.PhoenixStore.entidades.Usuario;
import ucentral.software.PhoenixStore.servicios.ServicioUsuario;

@Controller
public class ControladorRegistro {

    private final ServicioUsuario servicioUsuario;

    public ControladorRegistro(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/register")
    public String formularioRegistro() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registrarUsuario(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("error", "Datos inválidos. Por favor, revisa el formulario.");
            return modelAndView;
        }

        try {
            servicioUsuario.registrarUsuario(usuario);
            return new ModelAndView("redirect:/login");
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("error", "Error al registrar el usuario: " + e.getMessage());
            return modelAndView;
        }
    }
}
