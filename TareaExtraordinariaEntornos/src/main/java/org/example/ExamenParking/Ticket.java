package org.example.ExamenParking;

import java.util.Random;

public class Ticket implements Acciones {
    private String matricula;
    private Integer minutos;
    private Estado estado;


    public Ticket(String matricula, Integer minutos, Estado estado) {
        this.matricula = matricula;
        this.minutos = minutos;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "matricula='" + matricula + '\'' +
                ", minutos=" + minutos +
                ", estado=" + estado +
                '}';
    }

    @Override
    public void generar() {
        String matricula = "";
        String letras = "BCDFGHJKLMNÑPQRSTVWXYZ";
        String numeros = "0123456789";
        Random aleatorio = new Random();

        for (int j = 0; j < 4; j++) {
            int random = aleatorio.nextInt(letras.length());
            matricula += letras.charAt(random);

        }
        for (int j = 0; j < 3; j++) {
            int numerosRandom = aleatorio.nextInt(numeros.length());
            matricula+= numeros.charAt(numerosRandom);
        }
        setMatricula(matricula);
        setEstado(Estado.GENERADO);

        matricula = "";
    }

    @Override
    public void recoger() {
        System.out.println("Recoja su ticket...");
        setEstado(Estado.RECOGIDO);
    }

    @Override
    public void pagar() {


    }
}
