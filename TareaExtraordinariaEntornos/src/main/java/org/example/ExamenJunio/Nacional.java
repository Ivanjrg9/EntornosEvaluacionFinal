package org.example.ExamenJunio;

public class Nacional extends Peregrino{
    private String provincia;

    public Nacional(Integer numReserva, String nombre, EstadoPeregrino estado, String provincia) {
        super(numReserva, nombre, estado);
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Nacional{" +
                "provincia='" + provincia + '\'' +
                '}';
    }

    @Override
    public void recibirBesico() {
        System.out.println("El papa le da un besico en la frente a " + getNombre() + " y l@ despacha con una sonrisa" );

    }
}
