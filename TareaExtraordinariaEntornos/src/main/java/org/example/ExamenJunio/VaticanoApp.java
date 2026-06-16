package org.example.ExamenJunio;

import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class VaticanoApp {

    static Set<Peregrino>registrados = new LinkedHashSet<>();
    static Set<Peregrino>fila = new LinkedHashSet<>();

    static void main() {
        Peregrino ivan = new Nacional(1,"Ivan",EstadoPeregrino.SOLICITUD_OK,"Alicante");
        Peregrino Ismael = new Extrangero(2,"Ismael",EstadoPeregrino.SOLICITUD_OK,"Marruecos");
        Peregrino Manuela = new Nacional(3,"Manuela",EstadoPeregrino.SOLICITUD_OK,"Alicante");
        Peregrino Joselu = new Nacional(4,"Joselu",EstadoPeregrino.SOLICITUD_OK,"Alicante");
        Peregrino Paula = new Extrangero(5,"Paula",EstadoPeregrino.SOLICITUD_OK,"Suiza");

        registrados.add(ivan);
        registrados.add(Ismael);
        registrados.add(Manuela);
        registrados.add(Joselu);
        registrados.add(Paula);

        for (Peregrino peregrino : registrados){
            System.out.println("Nombre: " + peregrino.getNombre());
        }
        buscarPeregrino(2);
        llegadaPeregrino();
        bendicionPapal();

    }

    public static void llegadaPeregrino(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el numero de reserva:");
        Integer numeroReserva = teclado.nextInt();

        buscarPeregrino(numeroReserva);
    }

    public static Peregrino buscarPeregrino(Integer numReserva) {
        for (Peregrino peregrino : registrados) {
            if (peregrino.getNumReserva().equals(numReserva)){
                if (peregrino.getEstado() == EstadoPeregrino.BENDECIDO) {
                    System.out.println("[!] ¡Pecador! Ya has recibido tu besico, deja paso a otros.");
                    return null;
                } else {
                    peregrino.setEstado(EstadoPeregrino.EN_COLA);
                    System.out.println("[+] Peregrino " + peregrino.getNombre() + " añadido a la fila.");
                    fila.add(peregrino);
                    return peregrino;
                }
            }
        }
        System.out.println("[!] Error: Reserva no encontrada");
        return null;
    }

    public static void bendicionPapal(){
      if (fila.isEmpty()){
          System.out.println("Su santidad esta descansando, no hay nadie en la cola");
      }else {
          for (Peregrino peregrino : fila){
              peregrino.recibirBesico();
          }
      }
    }
}
