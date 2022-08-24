import enums.TipoProducto;

public class Producto {
    private final String prodID;
    private final TipoProducto tipoProducto;
    private final String descripcionProducto;
    private final int costoPorAdulto; //sin descuentos, total estadía, mayores 18
    private final int costoPorMenor; //sin descuentos, total estadía, menores 18

    public Producto(String prodID, TipoProducto tipoProducto, String descripcionProducto, int costoPorAdulto, int costoPorMenor) {
        this.prodID = prodID;
        this.tipoProducto = tipoProducto;
        this.descripcionProducto = descripcionProducto;
        this.costoPorAdulto = costoPorAdulto;
        this.costoPorMenor = costoPorMenor;
    }

    public String getProdID() {
        return prodID;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public int getCostoPorAdulto() {
        return costoPorAdulto;
    }

    public int getCostoPorMenor() {
        return costoPorMenor;
    }
}
