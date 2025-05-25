package com.trapitos.test;


import com.trapitos.model.Producto;
import com.trapitos.model.Usuario;
import com.trapitos.service.*;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TrapitosTests {

    @Test
    void testLoginConCredencialesValidas() {
        LoginService loginService = new LoginService();
        assertTrue(loginService.autenticar("cliente@trapitos.com.es", "claveSegura123"));
    }

    @Test
    void testLoginConCredencialesInvalidas() {
        LoginService loginService = new LoginService();
        assertFalse(loginService.autenticar("cliente@trapitos.com.es", "malacontraseña"));
    }

    @Test
    void testCalculoTotalCarrito() {
        CarritoService carrito = new CarritoService();
        carrito.agregarProducto(new Producto("Camiseta", 10.0), 2);
        carrito.agregarProducto(new Producto("Pantalón", 20.0), 1);
        assertEquals(40.0, carrito.calcularTotal(), 0.01);
    }

    @Test
    void testValidacionEmailInvalido() {
        Usuario usuario = new Usuario("cliente@", "clave123");
        FormularioRegistroValidator validator = new FormularioRegistroValidator();
        Map<String, String> errores = validator.validar(usuario);
        assertTrue(errores.containsKey("email"));
    }

    @Test
    void testAgregarProductoExcediendoStock() {
        Producto producto = new Producto("Zapatos", 50.0, 3, null);
        CarritoService carrito = new CarritoService();
        boolean resultado = carrito.agregarProducto(producto, 5, true);
        assertFalse(resultado);
    }

    @Test
    void testFiltroPorColorRojo() {
        List<Producto> productos = List.of(
            new Producto("Vestido", "rojo"),
            new Producto("Camisa", "negro")
        );
        FiltroService filtro = new FiltroService();
        List<Producto> filtrados = filtro.filtrarPorColor(productos, "rojo");
        assertEquals(1, filtrados.size());
        assertEquals("rojo", filtrados.get(0).getColor());
    }
}