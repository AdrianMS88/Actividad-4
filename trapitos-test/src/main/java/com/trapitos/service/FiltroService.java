package com.trapitos.service;

import com.trapitos.model.Producto;

import java.util.List;
import java.util.stream.Collectors;
public class FiltroService {
    public List<Producto> filtrarPorColor(List<Producto> productos, String colorDeseado) {
        return productos.stream()
                .filter(p -> colorDeseado.equals(p.getColor()))
                .collect(Collectors.toList());
    }
}
