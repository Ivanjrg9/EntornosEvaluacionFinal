package org.example.ExamenParking;

import java.util.Scanner;

public class AppParking {
    static Parking parking = new Parking("Mutxamel",1000,0.025);

    static void main() {
        System.out.println("PARKING MUTXAMEL");
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();
        app1();
        app2();
        app3();
    }

    static void app1(){
       int plazas = parking.getPlazas_totales() - parking.getClientesActuales().size();
       if (plazas == 0){
           System.out.println("Parking completo...");
       }else {
           System.out.println("Puedes pasar hay " + plazas + " libres");
       }

       Ticket ticket = new Ticket(" ",1,Estado.PENDIENTE);
       ticket.generar();
       parking.anyadirCliente(ticket);
       ticket.recoger();
       System.out.println("Bienvenido!");
    }

    static void app2(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("PAGO DE TICKETS");
        System.out.println("INTRODUCE LA MATRICULA:");
        String matricula = teclado.next();
        System.out.println("Validando...");
        Ticket ticket = parking.validarTicket(matricula);

        if (parking.validarTicket(matricula)==null){
            System.out.println("El ticket no existe...");
        }

        ticket.pagar();
        ticket.setEstado(Estado.PAGADO);
        System.out.println("Buen viaje");
    }

    static void app3(){


    }

}
