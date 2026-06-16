package org.example.ExamenPiscina;

import java.util.Scanner;

public class Adulto extends Bañista{

    public Adulto(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        super(numero, nombre, edad, tipo);
    }

    @Override
    void pagar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Adulto (abono tipo ADULTO) pagando 30.0€");
    }
}
