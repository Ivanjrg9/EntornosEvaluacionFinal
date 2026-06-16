package org.example.ExamenPiscina;

import java.time.LocalDate;

public class Invitado extends Bañista{
    private LocalDate fecha_visita;

    public Invitado(Integer numero, String nombre, int edad, TipoUsuario tipo, LocalDate fecha_visita) {
        super(numero, nombre, edad, tipo);
        this.fecha_visita = fecha_visita;
    }

    public LocalDate getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(LocalDate fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    @Override
    void pagar() {
        System.out.println("Invitado (bono invitado) pagando 3.5€");
    }
}
