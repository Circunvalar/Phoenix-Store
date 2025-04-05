package ucentral.software.PhoenixStore.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.software.PhoenixStore.entidades.Usuario;
import ucentral.software.PhoenixStore.servicios.ServicioUsuario;

@Controller
public class ControladorLogin {

    private final ServicioUsuario servicioUsuario;

    public ControladorLogin(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String iniciarSesion(Usuario usuario, Model model) {
        Usuario usuarioExistente = servicioUsuario.obtenerPorUsername(usuario.getUsuusername());

        if (usuarioExistente != null && usuarioExistente.getUsucontrasena().equals(usuario.getUsucontrasena())) {
            // Puedes guardar el usuario en sesión o redirigir
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            model.addAttribute("usuario", usuario);
            return "login";
        }
    }

    @GetMapping("/home")
    public String mostrarHome() {
        return "home";
    }
}