package org.example.ExamenParking;

import java.util.ArrayList;
import java.util.Random;

public class Parking {
    private String ciudad;
    private int plazas_totales;
    private double precio_minuto;
    private ArrayList<Ticket>clientesActuales;

    public Parking(String ciudad, int plazas_totales, double precio_minuto) {
        this.ciudad = ciudad;
        this.plazas_totales = plazas_totales;
        this.precio_minuto = precio_minuto;
        this.clientesActuales = new ArrayList<>();
    }

    public void generarClientesAleatorios(){
        String matricula = "";
        String letras = "BCDFGHJKLMNÑPQRSTVWXYZ";
        String numeros = "0123456789";
        Random aleatorio = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                int random = aleatorio.nextInt(letras.length());
                matricula += letras.charAt(random);

            }
            for (int j = 0; j < 3; j++) {
                int numerosRandom = aleatorio.nextInt(numeros.length());
                matricula+= numeros.charAt(numerosRandom);
            }
            clientesActuales.add(new Ticket(matricula,4564,Estado.RECOGIDO));
            matricula = "";
        }
    }

    public void mostrarClientesActuales(){
        for (Ticket ticket : clientesActuales){
            System.out.println("Matricula " + ticket.getMatricula() + " minutos: " + ticket.getMinutos() + " estado: " + ticket.getEstado());
        }

    }

    public void anyadirCliente(Ticket ticket){
        clientesActuales.add(ticket);

    }

    public Ticket validarTicket(String matricula){
        for (Ticket ticket : clientesActuales){
            if (ticket.getMatricula().equals(matricula)){
                double precioPagar = ticket.getMinutos() * precio_minuto;
                System.out.println("Minutos: " + ticket.getMinutos() + " precio: " + getPrecio_minuto() + " Importe a pagar: " + precioPagar + " €" );
                return ticket;
            }
        }
        return null;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPlazas_totales() {
        return plazas_totales;
    }

    public void setPlazas_totales(int plazas_totales) {
        this.plazas_totales = plazas_totales;
    }

    public double getPrecio_minuto() {
        return precio_minuto;
    }

    public void setPrecio_minuto(double precio_minuto) {
        this.precio_minuto = precio_minuto;
    }

    public ArrayList<Ticket> getClientesActuales() {
        return clientesActuales;
    }

    public void setClientesActuales(ArrayList<Ticket> clientesActuales) {
        this.clientesActuales = clientesActuales;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "ciudad='" + ciudad + '\'' +
                ", plazas_totales=" + plazas_totales +
                ", precio_minuto=" + precio_minuto +
                ", clientesActuales=" + clientesActuales +
                '}';
    }
}
