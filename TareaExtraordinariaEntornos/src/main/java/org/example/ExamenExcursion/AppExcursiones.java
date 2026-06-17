package org.example.ExamenExcursion;

import java.util.Scanner;

public class AppExcursiones {
    static void main() {
        Excursion terramitica = new Excursion("Terra mitica",30.0,"Benidorm");
        terramitica.insertarProfesor();

        terramitica.inscribirAsistente();
        terramitica.inscribirAsistente();
        terramitica.inscribirAsistente();
        terramitica.inscribirAsistente();

        terramitica.verAsistentes();

        terramitica.eliminarAsistentesPorEdad(16);
        System.out.println("Despues de eliminar los asistentes por edad:");
        terramitica.verAsistentes();

        System.out.println("Importe a ingresar para la actividad: " + terramitica.getNombre_actividad() + " en " + terramitica.getLocalidad() + ": " + terramitica.calcularImporteIngreso() + "€");

    }
}
