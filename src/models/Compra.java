package models;

import java.time.LocalDateTime;

public class Compra {
    private boolean status;
    private int id;
    private LocalDateTime fechaHoraCompra;
    private Comprador comprador;
    private float totalCompra;

    public Compra(boolean status, int id, LocalDateTime fechaHoraCompra, Comprador comprador, float totalCompra) {
        this.status = status;
        this.id = id;
        this.fechaHoraCompra = fechaHoraCompra;
        this.comprador = comprador;
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "status=" + status +
                ", id=" + id +
                ", fechaHoraCompra=" + fechaHoraCompra +
                ", comprador=" + comprador +
                ", totalCompra=" + totalCompra +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public int getId() {
        return id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getFechaHoraCompra() {
        return fechaHoraCompra;
    }
}
