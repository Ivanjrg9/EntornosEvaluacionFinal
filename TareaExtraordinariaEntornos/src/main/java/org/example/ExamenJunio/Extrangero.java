package org.example.ExamenJunio;

public class Extrangero extends Peregrino{
    private String pais;

    public Extrangero(Integer numReserva, String nombre, EstadoPeregrino estado, String pais) {
        super(numReserva, nombre, estado);
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Extrangero{" +
                "pais='" + pais + '\'' +
                '}';
    }

    @Override
    public void recibirBesico() {
        System.out.println("El papa le da un besico en la frente a " + getNombre() + " y l@ despacha con una sonrisa" );

    }
}
