package org.example.ExamenPiscina;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AppPiscina {
    static Set<Bañista> listaBanyistas = new HashSet<>();
    static int numero;

    static void main() {
        System.out.println("App de mantenimiento de la piscina");

        Adulto adulto = new Adulto(1,"Isak",23,TipoUsuario.ADULTO);
        Niño ninyo1 = new Niño(2,"Belen",13,TipoUsuario.NINYO,"722645863");
        Adulto adulto2 = new Adulto(3,"Manolo",45,TipoUsuario.ADULTO);
        Invitado adulto3 = new Invitado(4,"Pepe",25,TipoUsuario.INVITADO,LocalDate.now());
        Invitado adulto4 = new Invitado(5,"Ivan",23,TipoUsuario.INVITADO,LocalDate.now());

        listaBanyistas.add(adulto);
        listaBanyistas.add(ninyo1);
        listaBanyistas.add(adulto2);
        listaBanyistas.add(adulto3);
        listaBanyistas.add(adulto4);

        altaUsuario();
        mostrarInvitados();
        eliminarInvitados();

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
                cobrar(nuevo);
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
                    cobrar(nuevoNinyo);
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
                cobrar(nuevoInvitado);
                break;
            default:
                System.out.println("Seleccion incorrecta...");
                break;
        }
    }
    public static void cobrar(Bañista bañista){
        bañista.pagar();
    }

    public static void mostrarInvitados(){
        System.out.println("Lista de bañistas del dia de hoy:");
        for (Bañista bañista : listaBanyistas){
            if (bañista instanceof Invitado){
                System.out.println("Numero: " + bañista.getNumero() + " Nombre: " + bañista.getNombre() + " Edad: " + bañista.getEdad());
            }
        }
    }

    public static void eliminarInvitados(){
        System.out.println("Eliminando Invitados...");
        for (Bañista bañista : listaBanyistas){
            System.out.println("Bañista " + bañista.getNombre() + " tipo " + bañista.getTipo());
        }
        Iterator<Bañista>it = listaBanyistas.iterator();

        while (it.hasNext()){
            Bañista s = it.next();
            if (s.getTipo().equals(TipoUsuario.INVITADO)){
                it.remove();
            }
        }
        System.out.println("----------------------------------");
        for (Bañista bañista : listaBanyistas){
            System.out.println("Bañista " + bañista.getNombre() + " tipo " + bañista.getTipo());
        }
    }
}
