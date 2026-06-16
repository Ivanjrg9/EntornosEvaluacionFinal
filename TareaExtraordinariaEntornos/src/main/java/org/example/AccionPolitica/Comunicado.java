package org.example.AccionPolitica;

import java.util.Objects;

public abstract class Comunicado {
    private String id;
    private String texto;
    private Integer valoracionPrioridad;
    private EstadoMensaje estado;

    abstract void leer();

    public Comunicado(String id, String texto, Integer valoracionPrioridad, EstadoMensaje estado) {
        this.id = id;
        this.texto = texto;
        this.valoracionPrioridad = valoracionPrioridad;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getValoracionPrioridad() {
        return valoracionPrioridad;
    }

    public void setValoracionPrioridad(Integer valoracionPrioridad) {
        this.valoracionPrioridad = valoracionPrioridad;
    }

    public EstadoMensaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoMensaje estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Comunicado{" +
                "id='" + id + '\'' +
                ", texto='" + texto + '\'' +
                ", valoracionPrioridad=" + valoracionPrioridad +
                ", estado=" + estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comunicado that = (Comunicado) o;
        return Objects.equals(id, that.id) && Objects.equals(texto, that.texto) && Objects.equals(valoracionPrioridad, that.valoracionPrioridad) && estado == that.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, texto, valoracionPrioridad, estado);
    }
}
