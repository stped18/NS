package com.backend.grouptracker.models;





import org.bouncycastle.util.encoders.Hex;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class User {

    private String id;
    private String mail;
    private String password;


    public User(String mail, String password) {
        LocalDateTime datatime = LocalDateTime.now();
        String originalString= mail+password+datatime.toString();
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8));
        this.id = new String(Hex.encode(hash));
        this.mail = mail;
        this.password = password;
    }

    public User(String id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
