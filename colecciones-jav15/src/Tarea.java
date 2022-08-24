import enums.EstadoReserva;
import enums.TipoProducto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tarea {
    public static void main(String[] args) {

        // DESCUENTOS
        Descuento descuento1 = new Descuento(10, true, false);
        Descuento descuento2 = new Descuento(15, false, true);

        // PASAJEROS
        Pasajero pasajero1 = new Pasajero("Maria Cervantes", "mariacervantes@gmail.com", "094583728", "25");
        Pasajero pasajero2 = new Pasajero("Manuel Rivas", "manuelrivas@gmail.com", "095382937", "30");
        Pasajero pasajero3 = new Pasajero("Carolina Rivas", "carolinaperez@gmail.com", "094382738", "5");
        Pasajero pasajero4 = new Pasajero("Franco Rivas", "francorivas@gmail.com", "099382758", "10");

        // PRODUCTOS
        Producto producto1 = new Producto("prod01", TipoProducto.VUELO, "vuelo a Qatar", 5000, 3000);
        Producto producto2 = new Producto("prod02", TipoProducto.HOTEL, "hotel Time Rako en Doha", 300, 220);
        Producto producto3 = new Producto("prod03", TipoProducto.TRASLADO, "traslado de aeropuerto de Qatar a hotel Time Rako en Doha", 20, 10);

        Map<String, String> mensajes = Map.of(
                EstadoReserva.CONFIRMADA.name(), "Genial! Tu reserva está confirmada",
                EstadoReserva.EN_PROCESO.name(), "Tu reserva está en proceso",
                EstadoReserva.CANCELADA.name(), "Tu reserva fue cancelada. Puedes intentarlo denuevo más tarde");

        // RESERVAS
        Reserva reserva1 = new Reserva("res01",
                "01-12-2023",
                "AR",
                "ES",
                "iphone",
                EstadoReserva.CONFIRMADA,
                List.of(producto1, producto2, producto3),
                List.of(descuento1),
                List.of(pasajero1, pasajero2, pasajero3, pasajero4));


        // TODO: TAREAS

        // TODO: Determinar cantidad total de pasajeros
        int cantidadPasajeros = reserva1.getPasajeros().size();
        System.out.println("Cantidad de pasajeros: " + cantidadPasajeros);

        // TODO: Determinar cantidad de menores de 18
        int cantidadMenores = (int) reserva1.getPasajeros()
                .stream()
                .filter(pasajero -> Integer.parseInt(pasajero.getEdad()) < 18)
                .count();
        System.out.println("Cantidad de pasajeros menores de 18: " + cantidadMenores);

        // TODO: Determinar si la reserva consiste de un pruducto único o un paquete (al menos 2 tipos de productos distintos)
        int productosDistintos = (int) reserva1.getProductos()
                .stream()
                .map(Producto::getTipoProducto)
                .distinct().count();

        boolean esPaquete = productosDistintos > 1;
        System.out.println("Es paquete: " + esPaquete);

        // TODO: Determinar si la reserva presenta algún descuento por puntos
        boolean tieneDescuentoPuntos = reserva1.getDescuentos()
                .stream()
                .anyMatch(Descuento::getPuntos);

        System.out.println("Tiene descuento por puntos: " + tieneDescuentoPuntos);

        // TODO: Determinar si la reserva presenta algún descuento por cupón
        boolean tieneDescuentoCupon = reserva1.getDescuentos()
                .stream()
                .anyMatch(Descuento::getCupon);

        System.out.println("Tiene descuento por cupón: " + tieneDescuentoCupon);

        // TODO: Determinar el mensaje para mostrar al pasajero según el estado de su reserva
        String mensaje = mensajes.get(reserva1.getEstadoReserva().name());

        System.out.println("Mensaje: " + mensaje);


        // TODO: Determinar costo total de la reserva, teniendo en cuenta que:
        //      Si la reserva no está confirmada, se devuelve 0
        //      Si el país de origen es Argentina, se cobra un impuesto adicional del 3%

        double resultado = 0;

        if ("CONFIRMADA".equals(reserva1.getEstadoReserva().name())){

            int cantidadAdultos = reserva1.getPasajeros().size() - cantidadMenores;

            List<Integer> costosAdultos = reserva1.getProductos()
                    .stream()
                    .map(Producto::getCostoPorAdulto)
                    .collect(Collectors.toList());

            List<Integer> costosMenores = reserva1.getProductos()
                    .stream()
                    .map(Producto::getCostoPorMenor)
                    .collect(Collectors.toList());

            double costoTotalAdultos = costosAdultos
                    .stream()
                    .reduce(0, Integer::sum);

            double costoTotalMenores = costosMenores
                    .stream()
                    .reduce(0, Integer::sum);

            resultado = costoTotalAdultos * cantidadAdultos + costoTotalMenores * cantidadMenores;

            if ("AR".equals(reserva1.getPaisOrigen())){
                resultado = resultado * 1.03;
            }

            int porcentajeDescuento = reserva1.getDescuentos()
                    .stream()
                    .filter(descuento -> descuento.getCupon() || descuento.getPuntos())
                    .map(Descuento::getPorcentajeDescuento)
                    .reduce(0, (acumulador, elemento) -> acumulador + elemento);

            System.out.println("Porcentaje de descuento: " + porcentajeDescuento);
            resultado -= resultado * porcentajeDescuento/100;
        }

        System.out.println("COSTO TOTAL: " + resultado);
    }
}
