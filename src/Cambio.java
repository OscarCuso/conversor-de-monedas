import java.time.LocalDateTime;

public class Cambio{
    private String monedaBase, monedaDestino;
    private LocalDateTime fechaCambio;
    private double cantidadBase, cantidadDestino;

    public Cambio(String monedaBase, String monedaDestino, double cantidadBase, double cantidadDestino, LocalDateTime fechaCambio ) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.cantidadBase = cantidadBase;
        this.cantidadDestino = cantidadDestino;
        this.fechaCambio = fechaCambio;
    }


    @Override
    public String toString() {
        return "["+fechaCambio+"] (Moneda base: "+"["+monedaBase+"]"+ ", Moneda destino: "+"["+monedaDestino+"]"
                + ", Cantidad convertida: "+ cantidadBase+ ", El cambio resultante es: "+ cantidadDestino+" "+monedaDestino+" )";
    }
}
