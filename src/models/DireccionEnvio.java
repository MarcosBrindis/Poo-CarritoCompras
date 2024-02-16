package models;

public class DireccionEnvio {
    private String country;
    private String estado;
    private String city;
    private String direccion;
    private int codigoPostal;

    public DireccionEnvio(String country, String estado, String city, String direccion, int codigoPostal) {
        this.country = country;
        this.estado = estado;
        this.city = city;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return
                "pais='" + country + '\'' +
                        ", estado='" + estado + '\'' +
                        ", ciudad='" + city + '\'' +
                        ", direccion='" + direccion + '\'' +
                        ", codigo Postal=" + codigoPostal
                ;
    }
}
