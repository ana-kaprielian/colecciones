public class Pasajero {
    private final String nombreCompleto;
    private final String email;
    private final String telefono;
    private final String edad;

    public Pasajero(String nombreCompleto, String email, String telefono, String edad) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEdad() {
        return edad;
    }
}
