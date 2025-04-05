package ucentral.software.PhoenixStore.controladores;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.software.PhoenixStore.entidades.Usuario;
import ucentral.software.PhoenixStore.servicios.ServicioUsuario;

@Controller
public class ControladorRegistro {

    private final ServicioUsuario servicioUsuario;

    public ControladorRegistro(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/register")
    public String formularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario()); // 👈 Importante
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@Valid Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario); // 👈 Para mantener datos y errores
            return "register";
        }
        try {
            servicioUsuario.registrarUsuario(usuario);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el usuario");
            return "register";
        }
    }
}
