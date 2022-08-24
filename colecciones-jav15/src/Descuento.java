
public class Descuento {
    private final int porcentajeDescuento;
    private final Boolean cupon;
    private final Boolean puntos;

    public Descuento(int porcentajeDescuento, Boolean cupon, Boolean puntos) {
        this.porcentajeDescuento = porcentajeDescuento;
        this.cupon = cupon;
        this.puntos = puntos;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public Boolean getCupon() {
        return cupon;
    }

    public Boolean getPuntos() {
        return puntos;
    }
}
