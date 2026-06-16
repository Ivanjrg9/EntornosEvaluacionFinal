package org.example.ExamenPiscina;

public class EdadNinyo extends RuntimeException {
    public EdadNinyo() {
        super("Error al crear el niño, edad no permitida" );
    }
}
