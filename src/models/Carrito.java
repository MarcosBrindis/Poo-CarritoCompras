package models;

public class Carrito {
    private Comprador comprador;
    private Tienda tienda;

    public Carrito(Comprador comprador, Tienda tienda) {
        this.comprador = comprador;
        this.tienda = tienda;
    }

    public String agregarCarrito(int selector) {
        String imprimir;
        if (selector > 0 && selector <= tienda.getInventario().size()) {
            StockProducto stockProducto = tienda.getInventario().get(selector - 1);
            comprador.getCarritoComp().add(stockProducto);
            imprimir = "Producto agregado al carrito.";
        } else {
            imprimir = "Número de producto no válido.";
        }
        return imprimir;
    }

    public String mostrarcarrito() {
        String imprimir = "";
        if (comprador.getCarritoComp().isEmpty()) {
            imprimir = "El carrito está vacío.";
        } else {
            int i = 0;
            for (StockProducto stockProducto : comprador.getCarritoComp()) {
                i++;
                Producto producto = stockProducto.getProducto();
                imprimir += i + ") " + producto.getNombreProd() + "\n$" + "precio: " + producto.getPrecioProd();
                imprimir += "\n-------------------------------------------------\n";
            }
        }
        return imprimir;
    }

    public String eliminarProducto(int seleccionarElim) {
        String imprimir;
        if (comprador.getCarritoComp().isEmpty()) {
            imprimir = "El carrito está vacío. No hay productos para eliminar.";
        } else if (seleccionarElim > 0 && seleccionarElim <= comprador.getCarritoComp().size()) {
            StockProducto productoAEliminar = comprador.getCarritoComp().get(seleccionarElim - 1);
            comprador.getCarritoComp().remove(productoAEliminar);
            imprimir = "Producto eliminado del carrito.";
        } else if (seleccionarElim == 0) {
            imprimir = "Operación cancelada.";
        } else {
            imprimir = "Número de producto no válido.";
        }
        return imprimir;
    }

    public String totalaPagar() {
        String imprimir = "";
        float total = 0;
        for (StockProducto stockProducto : comprador.getCarritoComp()) {
            Producto producto = stockProducto.getProducto();
            total += producto.getPrecioProd();
        }
        imprimir = "total: $" + total;
        return imprimir;
    }

    public float totalaPagarusar() {
        float total = 0;
        for (StockProducto stockProducto : comprador.getCarritoComp()) {
            Producto producto = stockProducto.getProducto();
            total += producto.getPrecioProd();
        }
        return total;
    }

}
