package ucentral.software.PhoenixStore.servicios;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.software.PhoenixStore.configs.PasswordEncrypt;
import ucentral.software.PhoenixStore.entidades.Usuario;
import ucentral.software.PhoenixStore.repositorios.RepoUsuario;

import java.util.Optional;
@Service
public class ServicioAutentificacion {
    @Autowired
    RepoUsuario repoUsuario;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncrypt passwordEncrypt;

    public boolean inicioSesion(String usu_username, String usu_contrasena) {
        if (usu_username == null || usu_username.isEmpty()) {
            return false;
        }
        Optional<Usuario> clienteOptional = repoUsuario.findByUsuusername(usu_username);
        if (clienteOptional.isPresent()) {
            Usuario clienteEncontrado = clienteOptional.get();
            return passwordEncrypt.checkPassword(usu_contrasena, clienteEncontrado.getUsucontrasena());
        } else {
            return false;
        }
    }
}
