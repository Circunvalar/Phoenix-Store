package ucentral.software.PhoenixStore.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.software.PhoenixStore.configs.PasswordEncrypt;
import ucentral.software.PhoenixStore.entidades.Usuario;
import ucentral.software.PhoenixStore.repositorios.RepoUsuario;

@Service
public class ServicioUsuario {

    private final RepoUsuario repoUsuario;
    private final PasswordEncrypt passwordEncrypt;

    @Autowired
    public ServicioUsuario(RepoUsuario repoUsuario, PasswordEncrypt passwordEncrypt) {
        this.repoUsuario = repoUsuario;
        this.passwordEncrypt = passwordEncrypt;
    }

    public Usuario obtenerPorUsername(String username) {
        return repoUsuario.findByUsuusername(username).orElse(null);
    }

    public void registrarUsuario(Usuario usuario) {
        // Encriptar la contraseña antes de guardar
        String contrasenaEncriptada = passwordEncrypt.encodePassword(usuario.getUsucontrasena());
        usuario.setUsucontrasena(contrasenaEncriptada);

        // Guardar usuario
        repoUsuario.save(usuario);
    }
}
