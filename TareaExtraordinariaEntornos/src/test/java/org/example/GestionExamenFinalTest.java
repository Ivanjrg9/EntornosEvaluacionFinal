package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionExamenFinalTest {

    private GestionExamenFinal alumno;

    @BeforeEach
    void setUp() {
        alumno = new GestionExamenFinal("Ivan", 4.0, 3, true);
    }

    @Test
    void devuelveNotable(){
     assertEquals("Notable",alumno.clasificarResultado(8.0));
    }

    @Test
    void calcularNotaFinal(){
        assertEquals(6.3,alumno.calcularNotaFinal(7.0),0.001);
    }

    @Test
    void asistenciaMinima(){
        alumno.setAsistenciaMinima(false);
        assertFalse(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void calcularPuntosDevuelve4(){
        assertEquals(4,alumno.calcularPuntosExtra(3));
    }

    @Test
    void testExcepciones(){
        assertThrows(ArithmeticException.class,()->{ int resulado = 1/0;});
    }

    @Test
    void devuelveSuspenso(){
        assertEquals("Suspenso",alumno.clasificarResultado(3.0));
    }

    @Test
    void asistenciasNotasRecuperacion(){
        assertTrue(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void calcularPorcentaje(){
        assertEquals(50.0,alumno.calcularPorcentajeTareas(5,10),0.001);
    }

    @Test
    void alumnoNota(){
        alumno.setNotaExamen(2);
        alumno.setTareasEntregadas(3);
        assertEquals(2.3,alumno.calcularNotaFinal(3.0),0.001);
    }

    @Test
    void norecupera(){
        alumno.setNotaExamen(7);
        assertFalse(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void calcPuntExtr(){
        assertEquals(0,alumno.calcularPuntosExtra(0),0.001);
    }

    @Test
    void testConstructor() {
        assertEquals("Ivan", alumno.getNombreAlumno());
        assertEquals(4.0, alumno.getNotaExamen(), 0.001);
        assertEquals(3, alumno.getTareasEntregadas());
        assertTrue(alumno.isAsistenciaMinima());
    }

    @Test
    void testSetNombre() {
        alumno.setNombreAlumno("Pedro");
        assertEquals("Pedro", alumno.getNombreAlumno());
    }

    @Test
    void testSetNota() {
        alumno.setNotaExamen(9.0);
        assertEquals(9.0, alumno.getNotaExamen(), 0.001);
    }

    @Test
    void testSetTareas() {
        alumno.setTareasEntregadas(7);
        assertEquals(7, alumno.getTareasEntregadas());
    }

    @Test
    void testSetAsistencia() {
        alumno.setAsistenciaMinima(false);
        assertFalse(alumno.isAsistenciaMinima());
    }

    @Test
    void testEntregaCorrecta() {
        assertTrue(alumno.entregarTarea());
        assertEquals(4, alumno.getTareasEntregadas());
    }

    @Test
    void testEntregaVarias() {
        alumno.entregarTarea();
        alumno.entregarTarea();
        assertEquals(5, alumno.getTareasEntregadas());
    }

    @Test
    void testEntregaConCero() {
        alumno.setTareasEntregadas(0);
        assertTrue(alumno.entregarTarea());
        assertEquals(1, alumno.getTareasEntregadas());
    }

    @Test
    void testEntregaNegativa() {
        alumno.setTareasEntregadas(-1);
        assertFalse(alumno.entregarTarea());
        assertEquals(-1, alumno.getTareasEntregadas());
    }

    @Test
    void testRecuperacionSi() {
        assertTrue(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void testRecuperacionSinAsistencia() {
        alumno.setAsistenciaMinima(false);
        assertFalse(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void testRecuperacionAprobado() {
        alumno.setNotaExamen(6.0);
        assertFalse(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void testRecuperacionPocasTareas() {
        alumno.setTareasEntregadas(2);
        assertFalse(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void testRecuperacionNotaCinco() {
        alumno.setNotaExamen(5.0);
        assertFalse(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void testRecuperacionNotaUno() {
        alumno.setNotaExamen(1.0);
        assertTrue(alumno.puedePresentarseRecuperacion());
    }

    @Test
    void testNotaFinalNormal() {
        alumno.setNotaExamen(6.0);
        alumno.setTareasEntregadas(3);
        assertEquals(6.3, alumno.calcularNotaFinal(7.0), 0.001);
    }

    @Test
    void testNotaFinalConBonus() {
        alumno.setNotaExamen(6.0);
        alumno.setTareasEntregadas(5);
        assertEquals(6.8, alumno.calcularNotaFinal(7.0), 0.001);
    }

    @Test
    void testNotaFinalMaximo10() {
        alumno.setNotaExamen(10.0);
        alumno.setTareasEntregadas(5);
        assertEquals(10.0, alumno.calcularNotaFinal(10.0), 0.001);
    }

    @Test
    void testNotaFinalProyectoCero() {
        alumno.setNotaExamen(8.0);
        alumno.setTareasEntregadas(3);
        assertEquals(5.6, alumno.calcularNotaFinal(0.0), 0.001);
    }

    @Test
    void testNotaFinalExamenCero() {
        alumno.setNotaExamen(0.0);
        alumno.setTareasEntregadas(3);
        assertEquals(2.4, alumno.calcularNotaFinal(8.0), 0.001);
    }

    @Test
    void testClasificarSuspenso() {
        assertEquals("Suspenso", alumno.clasificarResultado(4.0));
    }

    @Test
    void testClasificarAprobado() {
        assertEquals("Aprobado", alumno.clasificarResultado(6.0));
    }

    @Test
    void testClasificarNotable() {
        assertEquals("Notable", alumno.clasificarResultado(8.0));
    }

    @Test
    void testClasificarSobresaliente() {
        assertEquals("Sobresaliente", alumno.clasificarResultado(9.5));
    }

    @Test
    void testPuntosCero() {
        assertEquals(0, alumno.calcularPuntosExtra(0));
    }

    @Test
    void testPuntosUno() {
        assertEquals(1, alumno.calcularPuntosExtra(1));
    }

    @Test
    void testPuntosTres() {
        assertEquals(4, alumno.calcularPuntosExtra(3));
    }

    @Test
    void testPuntosCinco() {
        assertEquals(6, alumno.calcularPuntosExtra(5));
    }

    @Test
    void testPuntosValorElevado() {
        assertEquals(13, alumno.calcularPuntosExtra(10));
    }

    @Test
    void testMatriculaSi() {
        alumno.setTareasEntregadas(5);
        assertTrue(alumno.tieneDerechoMatriculaHonor(9.5));
    }

    @Test
    void testMatriculaNotaBaja() {
        alumno.setTareasEntregadas(5);
        assertFalse(alumno.tieneDerechoMatriculaHonor(9.0));
    }

    @Test
    void testMatriculaSinAsistencia() {
        alumno.setTareasEntregadas(5);
        alumno.setAsistenciaMinima(false);
        assertFalse(alumno.tieneDerechoMatriculaHonor(9.5));
    }

    @Test
    void testMatriculaPocasTareas() {
        alumno.setTareasEntregadas(4);
        assertFalse(alumno.tieneDerechoMatriculaHonor(9.5));
    }

    @Test
    void testPorcentajeCero() {
        assertEquals(0.0, alumno.calcularPorcentajeTareas(0, 10), 0.001);
    }

    @Test
    void testPorcentaje50() {
        assertEquals(50.0, alumno.calcularPorcentajeTareas(5, 10), 0.001);
    }

    @Test
    void testPorcentaje100() {
        assertEquals(100.0, alumno.calcularPorcentajeTareas(10, 10), 0.001);
    }

    @Test
    void testPorcentajeMasDe100() {
        assertEquals(120.0, alumno.calcularPorcentajeTareas(12, 10), 0.001);
    }

    @Test
    void testPorcentajeDivisionCero() {
        assertEquals(0.0, alumno.calcularPorcentajeTareas(5, 0), 0.001);
    }

    @Test
    void testAssertThrows() {
        assertThrows(ArithmeticException.class, () -> {
            int resultado = 1 / 0;
        });
    }
}