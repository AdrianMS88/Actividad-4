package com.trapitos.service;

import com.trapitos.model.Usuario;

import java.util.HashMap;
import java.util.Map;
//import java.util.regex.Pattern;

public class FormularioRegistroValidator {
    public Map<String, String> validar(Usuario usuario) {
        Map<String, String> errores = new HashMap<>();

        if (!usuario.getEmail().contains("@") || usuario.getEmail().endsWith("@")) {
            errores.put("email", "Email no válido");
        }

        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            errores.put("password", "La contraseña no puede estar vacía");
        }

        return errores;
    }
}
