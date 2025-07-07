package Modelo;

import java.time.LocalDateTime;

public class Movimiento {
    private String tipo;
    private Producto producto;
    private int cantidad;
    private java.util.Date fecha;

    public Movimiento(String tipo, Producto producto, int cantidad, java.util.Date fecha) {
        this.tipo = tipo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getTipo() { return tipo; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public java.util.Date getFecha() { return fecha; }
}