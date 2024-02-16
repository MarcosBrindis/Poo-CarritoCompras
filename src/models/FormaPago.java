package models;

public class FormaPago {
    private String tipoDeTarjeta;
    private long numTarjeta;
    private int fechaMM;
    private int fechaAA;
    private int cvv;

    public FormaPago(String tipoDeTarjeta, long numTarjeta, int fechaMM, int fechaAA, int cvv) {
        this.tipoDeTarjeta = tipoDeTarjeta;
        this.numTarjeta = numTarjeta;
        this.fechaMM = fechaMM;
        this.fechaAA = fechaAA;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return
                "tipoDeTarjeta='" + tipoDeTarjeta + '\'' +
                        ", numTarjeta=" + numTarjeta +
                        ", fechaMM=" + fechaMM +
                        ", fechaAA=" + fechaAA +
                        ", cvv=" + cvv
                ;
    }
}
