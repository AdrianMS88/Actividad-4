package com.trapitos.model;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private String color;

    public Producto(String nombre, double precio) {
        this(nombre, precio, 0, null);
    }

    public Producto(String nombre, String color) {
        this(nombre, 0, 0, color);
    }

    public Producto(String nombre, double precio, int stock, String color) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.color = color;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getColor() { return color; }

    public void setStock(int stock) { this.stock = stock; }
}
