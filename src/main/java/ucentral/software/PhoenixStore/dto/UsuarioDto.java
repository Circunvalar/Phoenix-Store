package ucentral.software.PhoenixStore.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ucentral.software.PhoenixStore.entidades.Usuario}
 */

@Value
public class UsuarioDto implements Serializable {

    Long usuid;
    String usuusername;
    String usunombres;
    String usuapellidos;
    Long usucedula;
    String usucontrasena;
    String usurol;
    String usucorreo;
    String usutelefono;
    String usudireccion;
}