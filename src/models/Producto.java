package models;

import java.util.UUID;

public class Producto {
    private String nombreProd;
    private String descripcionProd;
    private String idProd;
    private float PrecioProd;

    public Producto() {
        this.idProd = UUID.randomUUID().toString();
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public String getIdProd() {
        return idProd;
    }

    public float getPrecioProd() {
        return PrecioProd;
    }

    public void setPrecioProd(float precioProd) {
        PrecioProd = precioProd;
    }
}
