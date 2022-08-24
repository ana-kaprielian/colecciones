import enums.EstadoReserva;

import java.util.List;

public class Reserva {
    private final String resID;
    private final String fecha;
    private final String paisOrigen;
    private final String idioma;
    private final String canal;
    private final EstadoReserva estadoReserva;
    private final List<Producto> productos;
    private final List<Descuento> descuentos;
    private final List<Pasajero> pasajeros;

    public Reserva(String resID, String fecha, String paisOrigen, String idioma, String canal, EstadoReserva estadoReserva, List<Producto> productos, List<Descuento> descuentos, List<Pasajero> pasajeros) {
        this.resID = resID;
        this.fecha = fecha;
        this.paisOrigen = paisOrigen;
        this.idioma = idioma;
        this.canal = canal;
        this.estadoReserva = estadoReserva;
        this.productos = productos;
        this.descuentos = descuentos;
        this.pasajeros = pasajeros;
    }

    public String getResID() {
        return resID;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getCanal() {
        return canal;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Descuento> getDescuentos() {
        return descuentos;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }
}
