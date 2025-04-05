package ucentral.software.PhoenixStore.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.software.PhoenixStore.entidades.Usuario;
import ucentral.software.PhoenixStore.repositorios.RepoUsuario;

@Service
public class ServicioUsuario {

    @Autowired
    private RepoUsuario repoUsuario;

    public void registrarUsuario(Usuario usuario) {
        repoUsuario.save(usuario);
    }
}