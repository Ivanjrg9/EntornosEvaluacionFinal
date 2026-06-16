package org.example.ExamenPiscina;

import java.util.Objects;

public abstract class Bañista {
    private Integer numero;
    private String nombre;
    private int edad;
    private TipoUsuario tipo;

    abstract void pagar();


    public Bañista(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad<0){
            System.out.println("Error edad menor que 0");
        }else {
            this.edad= edad;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Bañista{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bañista bañista = (Bañista) o;
        return edad == bañista.edad && Objects.equals(numero, bañista.numero) && Objects.equals(nombre, bañista.nombre) && tipo == bañista.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nombre, edad, tipo);
    }
}
