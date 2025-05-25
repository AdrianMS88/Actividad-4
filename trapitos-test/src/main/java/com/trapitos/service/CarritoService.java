package com.trapitos.service;

import com.trapitos.model.Producto;

import java.util.HashMap;
import java.util.Map;

public class CarritoService {
    private Map<Producto, Integer> productos = new HashMap<>();

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
    }

    public boolean agregarProducto(Producto producto, int cantidad, boolean checkStock) {
        if (checkStock && cantidad > producto.getStock()) {
            return false;
        }
        agregarProducto(producto, cantidad);
        return true;
    }

    public double calcularTotal() {
        return productos.entrySet()
                .stream()
                .mapToDouble(e -> e.getKey().getPrecio() * e.getValue())
                .sum();
    }
}