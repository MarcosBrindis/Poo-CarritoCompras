package models;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<StockProducto> stockProducto = new ArrayList<>();
    private ArrayList<Compra> compras = new ArrayList<>();

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "compras=" + compras +
                '}';
    }

    public void addproductos(StockProducto inventarioo) {
        stockProducto.add(inventarioo);
    }

    public ArrayList<StockProducto> getInventario() {
        return stockProducto;
    }

    public void addCompra(Compra nuevaCompra) {
        compras.add(nuevaCompra);
    }
}
