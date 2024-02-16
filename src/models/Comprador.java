package models;

import java.util.ArrayList;
import java.util.Objects;

public class Comprador {
    private String nickname;
    private String name;
    private String lastname;
    private String email;
    private long phoneNumber;
    private String password;
    private FormaPago formaPago;
    private DireccionEnvio envio;
    private ArrayList<StockProducto> carritoComp = new ArrayList<>();

    @Override
    public String toString() {
        return "Comprador{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", \nforma de pago:" + (formaPago != null ? formaPago.toString() : "sin rellenar") +
                ", \ndatos envio " + (envio != null ? envio.toString() : "sin rellenar") +
                '}';
    }

    public ArrayList<StockProducto> getCarritoComp() {
        return carritoComp;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void setEnvio(DireccionEnvio envio) {
        this.envio = envio;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public DireccionEnvio getEnvio() {
        return envio;
    }

    public Comprador() {
    }

    public Comprador(String nickname, String name, String lastname, String email, long phoneNumber, String password, FormaPago formaPago, DireccionEnvio envio) {
        this.nickname = nickname;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.formaPago = formaPago;
        this.envio = envio;
    }

    public Comprador(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprador comprador = (Comprador) o;
        return Objects.equals(nickname, comprador.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
