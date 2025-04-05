package ucentral.software.PhoenixStore.configs;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt {

    public String encrypt(String password) {
        return password;
    }

    public boolean checkPassword(String password, String encryptedPassword) {
        return password.equals(encryptedPassword);
    }
}
