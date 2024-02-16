package models;

import java.time.LocalDate;

public class StockProducto {
    private float cantidadDelProducto;
    private LocalDate fecha;
    private Producto producto;

    public StockProducto(float cantidadDelProducto, LocalDate fecha, Producto producto) {
        this.cantidadDelProducto = cantidadDelProducto;
        this.fecha = fecha;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public float getCantidadDelProducto() {
        return cantidadDelProducto;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
