package ucentral.software.PhoenixStore.configs;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt {

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordEncrypt() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Encriptar la contraseña
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // Verificar la contraseña
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
