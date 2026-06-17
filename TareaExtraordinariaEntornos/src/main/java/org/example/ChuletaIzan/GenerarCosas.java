package org.example.ChuletaIzan;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerarCosas {
    static final String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String NUMEROS = "0123456789";

    public static void main(String[] args) {
        numeroAleatorioEnRango();
        generarDniAleatorio();
        generarTextoAleatorio();
        dnisSinRepetir();
        validarConMatches();
    }

    static void numeroAleatorioEnRango() {
        System.out.println("===== Número aleatorio entre 1 y 8 =====");
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int dias = random.nextInt(8) + 1;
            System.out.println("   Días de huelga: " + dias);
        }
        System.out.println();
    }

    static String crearDni(Random random) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int pos = random.nextInt(NUMEROS.length());
            sb.append(NUMEROS.charAt(pos));
        }
        int posLetra = random.nextInt(LETRAS.length());
        sb.append(LETRAS.charAt(posLetra));
        return sb.toString();
    }

    static void generarDniAleatorio() {
        System.out.println("===== DNI aleatorio (8 números + 1 letra) =====");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            System.out.println("   " + crearDni(random));
        }
        System.out.println();
    }

    static void generarTextoAleatorio() {
        System.out.println("===== Texto aleatorio de 20 caracteres =====");
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            int pos = random.nextInt(LETRAS.length());
            sb.append(LETRAS.charAt(pos));
        }
        System.out.println("   " + sb.toString());
        System.out.println();
    }

    static void dnisSinRepetir() {
        System.out.println("===== Generar 5 DNI sin repetir (Set) =====");
        Random random = new Random();
        Set<String> dnis = new HashSet<>();
        while (dnis.size() < 5) {
            dnis.add(crearDni(random));
        }
        System.out.println("   " + dnis);
        System.out.println("   Cantidad (siempre 5): " + dnis.size());
        System.out.println();
    }

    static void validarConMatches() {
        System.out.println("===== Validar formato con .matches() (8 números + letra) =====");
        String[] pruebas = {"12345678X", "hola", "1234567A", "12345678x", "00000000Z"};
        String patron = "[0-9]{8}[A-Z]";
        for (String p : pruebas) {
            boolean valido = p.matches(patron);
            System.out.println("   '" + p + "' -> " + (valido ? "VÁLIDO" : "no válido"));
        }
        System.out.println();
    }
}
