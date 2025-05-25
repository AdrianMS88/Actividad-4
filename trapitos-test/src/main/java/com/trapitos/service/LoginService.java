package com.trapitos.service;

public class LoginService {
    public boolean autenticar(String email, String password) {
        return email.equals("cliente@trapitos.com.es") && password.equals("claveSegura123");
    }
}