package org.example.ExamenExcursion;

import java.util.*;

public class Excursion {
    private String nombre_actividad;
    private String localidad;
    private double precio;
    private Set<String>profesores;
    private Set<Estudiante>listaEstudiantes;

    public Excursion(String nombre_actividad, double precio, String localidad) {
        this.nombre_actividad = nombre_actividad;
        this.listaEstudiantes = new HashSet<>();
        this.profesores = new HashSet<>();
        this.precio = precio;
        this.localidad = localidad;
    }

    public void insertarProfesor(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del profesor:");
        String nombre = teclado.next();
        profesores.add(nombre);
        System.out.println("Profesor añadido correctamente a la lista");
    }

    public void inscribirAsistente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Edad del asistente");
        int edad = teclado.nextInt();
        System.out.println("Apellidos");
        String apellidos = teclado.next();
        System.out.println("Nombre");
        String nombre = teclado.next();
        System.out.println("Curso");
        String curso = teclado.next();
        Estudiante estudiante = new Estudiante(apellidos,nombre,curso,edad);

        for (Estudiante estudiante1 : listaEstudiantes){
            if (estudiante1.getApellidos().equals(estudiante.getApellidos()) && estudiante1.getNombre().equals(estudiante.getNombre())&& estudiante1.getCurso().equals(estudiante.getCurso())){
                System.out.println("El estudiante ya existe...");
                return;
            }
        }
        listaEstudiantes.add(estudiante);
    }

    public double calcularImporteIngreso(){
        double importeExcursion =getPrecio() * listaEstudiantes.size();

        return importeExcursion;
    }

    public void verAsistentes(){
        for (Estudiante estudiante : listaEstudiantes){
            System.out.println("Curso: " + estudiante.getCurso() + " Apellidos: " + estudiante.getApellidos());
        }
    }

    public void eliminarAsistentesPorEdad(int edad){
        Iterator<Estudiante>it= listaEstudiantes.iterator();
        while (it.hasNext()){
            Estudiante siguiente = it.next();
            if (siguiente.getEdad()<edad){
                it.remove();
            }
        }
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<String> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<String> profesores) {
        this.profesores = profesores;
    }

    public Set<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Set<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Excursion excursion = (Excursion) o;
        return Double.compare(precio, excursion.precio) == 0 && Objects.equals(nombre_actividad, excursion.nombre_actividad) && Objects.equals(localidad, excursion.localidad) && Objects.equals(profesores, excursion.profesores) && Objects.equals(listaEstudiantes, excursion.listaEstudiantes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre_actividad, localidad, precio, profesores, listaEstudiantes);
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "nombre_actividad='" + nombre_actividad + '\'' +
                ", localidad='" + localidad + '\'' +
                ", precio=" + precio +
                ", profesores=" + profesores +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }
}
