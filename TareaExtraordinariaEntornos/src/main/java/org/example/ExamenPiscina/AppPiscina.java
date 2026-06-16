package org.example.ExamenPiscina;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.TreeSet;

public class AppPiscina {

    static TreeSet<Bañista>listaBanyistas;
    static int numero;
    static void main() {
        System.out.println("App de mantenimiento de la piscina");
        altaUsuario();

    }
    static void altaUsuario(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Alta de usuarios...");
        System.out.println("1. Adulto");
        System.out.println("2. Niño (<= 16 años)");
        System.out.println("3. Invitados (pase diario)");
        System.out.println("-----------------------------------");
        System.out.println("Elige un tipo:");
        int eleccion = teclado.nextInt();

        switch (eleccion){
            case 1:
                System.out.println("Introduce el nombre del nuevo adulto bañista:");
                String nombre = teclado.next();
                System.out.println("Introduce la edad:");
                int edad = teclado.nextInt();
                Adulto nuevo = new Adulto(numero,nombre,edad,TipoUsuario.ADULTO);
                listaBanyistas.add(nuevo);
                System.out.println("Bañista creado con exito");
                break;
            case 2:
                System.out.println("Introduce el nombre del nuevo niño bañista:");
                String nombreNinyo = teclado.next();
                System.out.println("Introduce la edad:");
                int edadNinyo = teclado.nextInt();
                if (edadNinyo>16){
                    throw new EdadNinyo();
                }else {
                    System.out.println("Telefono de adulto de contacto:");
                    String telefono = teclado.next();
                    Niño nuevoNinyo = new Niño(numero,nombreNinyo,edadNinyo, TipoUsuario.NINYO, telefono);
                    listaBanyistas.add(nuevoNinyo);
                    System.out.println("Bañista niño creeado correctamente");
                }
                break;
            case 3:
                System.out.println("Introduce nombre del invitado:");
                String nombreInvitado = teclado.next();
                System.out.println("Introduce la edad:");
                int edadInvitado = teclado.nextInt();
                Invitado nuevoInvitado = new Invitado(numero,nombreInvitado,edadInvitado,TipoUsuario.INVITADO, LocalDate.now());
                listaBanyistas.add(nuevoInvitado);
                System.out.println("Bañista creado con exito");
                break;
            default:
                System.out.println("Seleccion incorrecta...");
                break;
        }
    }
    public static void cobrar(Bañista bañista){
        bañista.pagar();
    }
}
