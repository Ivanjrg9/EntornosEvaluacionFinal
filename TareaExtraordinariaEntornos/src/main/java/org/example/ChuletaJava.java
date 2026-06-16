package org.example;

import java.util.*;

/**
 * ============================================================
 *  CHULETA JAVA — PROGRAMACIÓN 1º DAW (versión fácil)
 * ============================================================
 *  Clase de repaso con TODO explicado paso a paso.
 *  Cada bloque es un método. El main() ejecuta los ejemplos
 *  que NO piden datos por teclado, para que veas la salida.
 *  Los que usan teclado están al final y comentados en el main
 *  (quita el "//" para probarlos).
 *
 *  IDEA: abre la consola y ve leyendo el código a la vez que
 *  ves lo que imprime cada bloque.
 * ============================================================
 */
public class ChuletaJava {



    public static void main(String[] args) {
        HashMap<String,Integer> goleadores = new HashMap<>();
        goleadores.put("ANDRÉ SILVA",6);
        goleadores.put("RONALDO NAZARIO",156);

        Iterator<Map.Entry<String,Integer>> itmapita = goleadores.entrySet().iterator();

        while(itmapita.hasNext()){
            Map.Entry<String,Integer> goleadorGol = itmapita.next();
            System.out.println(goleadorGol.getKey() + " ha marcado " + goleadorGol.getValue() + " goles.");
            if (goleadorGol.getValue()<100){
                itmapita.remove();
            }
        }

        TreeSet<String> peliculas = new TreeSet();

        peliculas.add("SCREAM");
        peliculas.add("CARS");
        peliculas.add("TOY STORY");
        peliculas.add("BOLT");

        Iterator<String> it = peliculas.iterator();

        peliculas.remove("BOLT");

        while (it.hasNext()){

            String peli = it.next();

            if (peli.equals("BOLT")){
                it.remove();
            }

        }

        System.out.println(peliculas);
        System.out.println(goleadores.entrySet());
        titulo("1. VARIABLES Y TIPOS");           bloqueVariables();
        titulo("2. OPERADORES");                  bloqueOperadores();
        titulo("3. CONDICIONALES (if / switch)"); bloqueCondicionales();
        titulo("4. BUCLES (for / while)");        bloqueBucles();
        titulo("5. ARRAYS (vectores)");           bloqueArrays();
        titulo("6. SPLIT + PARSEINT");            bloqueSplit();
        titulo("7. FORMATOS con matches");        bloqueFormatos();
        titulo("8. VALIDAR DATOS (bucle)");       bloqueValidacionSimulada();
        titulo("9. METODOS (crear y llamar)");    bloqueMetodos();
        titulo("10. LISTAS (ArrayList)");         bloqueListas();
        titulo("11. RECORRER LISTAS");            bloqueRecorrerListas();
        titulo("12. COLA FIFO");                  bloqueColaFifo();
        titulo("13. PILA LIFO");                  bloquePilaLifo();
        titulo("14. MAPAS (HashMap)");            bloqueMapas();
        titulo("15. RECORRER MAPAS");             bloqueRecorrerMapas();
        titulo("16. CLASES, HERENCIA, ENUM...");  bloquePoo();
        titulo("17. CARGAR DATOS EN EL MAIN");    bloqueCargarDatos();
        titulo("18. SALIDA Y FORMATOS");          bloqueSalida();
        titulo("19. CADENAS (String)");           bloqueCadenas();

        // --- Interactivos: quita el "//" para probarlos con teclado ---
        // bloqueTeclado();
        // bloqueValidacionReal();
    }

    /** Imprime un separador bonito con el título del bloque. */
    static void titulo(String texto) {
        System.out.println("\n========== " + texto + " ==========");
    }

    // ============================================================
    // 1. VARIABLES Y TIPOS DE DATOS
    //    Una variable es una "caja" con nombre donde guardas un valor.
    // ============================================================
    static void bloqueVariables() {
        int edad = 26;                 // número entero (sin decimales)
        double altura = 1.78;          // número con decimales
        char inicial = 'I';            // un solo carácter (comillas simples)
        boolean esMayorDeEdad = true;  // solo puede ser true o false
        String nombreCompleto = "Ivan";// texto (comillas dobles)

        System.out.println("edad = " + edad);
        System.out.println("altura = " + altura);
        System.out.println("inicial = " + inicial);
        System.out.println("esMayorDeEdad = " + esMayorDeEdad);
        System.out.println("nombreCompleto = " + nombreCompleto);

        // Convertir de un tipo a otro:
        String edadComoTexto = String.valueOf(edad);   // número -> texto
        int textoComoNumero = Integer.parseInt("100");  // texto -> número
        System.out.println("convertidos: " + edadComoTexto + " y " + textoComoNumero);
    }

    // ============================================================
    // 2. OPERADORES
    // ============================================================
    static void bloqueOperadores() {
        int a = 7;
        int b = 2;

        System.out.println("suma  a+b = " + (a + b));
        System.out.println("resta a-b = " + (a - b));
        System.out.println("mult  a*b = " + (a * b));
        System.out.println("divis a/b = " + (a / b) + "  (division ENTERA: tira decimales)");
        System.out.println("resto a%b = " + (a % b) + "  (% = lo que sobra; sirve para par/impar)");

        // Comparaciones (devuelven true/false):
        System.out.println("a > b ? " + (a > b));
        System.out.println("a == b ? " + (a == b));   // == compara si son iguales
        System.out.println("a != b ? " + (a != b));   // != compara si son distintos

        // Lógicos: && (Y, las dos), || (O, al menos una), ! (NO, lo contrario)
        boolean tieneDinero = true;
        boolean tieneHambre = false;
        System.out.println("compra comida (dinero && hambre)? " + (tieneDinero && tieneHambre));
        System.out.println("hace algo (dinero || hambre)? " + (tieneDinero || tieneHambre));
        System.out.println("NO tiene hambre? " + (!tieneHambre));
    }

    // ============================================================
    // 3. CONDICIONALES: if / else if / else  y  switch
    // ============================================================
    static void bloqueCondicionales() {
        int nota = 7;

        // if / else if / else
        if (nota >= 9) {
            System.out.println("Sobresaliente");
        } else if (nota >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Suspenso");
        }

        // switch: elige entre varios casos concretos
        int diaDeLaSemana = 3;
        switch (diaDeLaSemana) {
            case 1: System.out.println("Lunes"); break;     // ojo al break
            case 2: System.out.println("Martes"); break;
            case 3: System.out.println("Miercoles"); break;
            default: System.out.println("Otro dia");          // si no coincide ninguno
        }
    }

    // ============================================================
    // 4. BUCLES: for, while, do-while
    // ============================================================
    static void bloqueBucles() {
        // for: cuando SABES cuántas veces (de 0 a 4)
        System.out.print("for: ");
        for (int contador = 0; contador < 5; contador++) {
            System.out.print(contador + " ");
        }
        System.out.println();

        // while: repite MIENTRAS se cumpla la condición (puede no entrar nunca)
        System.out.print("while: ");
        int numero = 0;
        while (numero < 5) {
            System.out.print(numero + " ");
            numero++;   // MUY IMPORTANTE: cambiar la variable o bucle infinito
        }
        System.out.println();

        // do-while: igual que while PERO entra al menos UNA vez (comprueba al final)
        System.out.print("do-while: ");
        int valor = 0;
        do {
            System.out.print(valor + " ");
            valor++;
        } while (valor < 5);
        System.out.println();
    }

    // ============================================================
    // 5. ARRAYS (vectores): muchos valores del mismo tipo, tamaño FIJO
    // ============================================================
    static void bloqueArrays() {
        int[] notas = {5, 7, 9, 3};          // crear y rellenar de golpe
        String[] nombres = new String[3];    // crear vacío de tamaño 3
        nombres[0] = "Ana";                  // rellenar por posición
        nombres[1] = "Luis";
        nombres[2] = "Marta";

        System.out.println("notas[0] = " + notas[0]);
        System.out.println("tamaño del array notas = " + notas.length);

        // Recorrer un array sumando:
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        System.out.println("suma de notas = " + suma);

        // for-each (más cómodo si no necesitas la posición):
        System.out.print("nombres: ");
        for (String unNombre : nombres) {
            System.out.print(unNombre + " ");
        }
        System.out.println();
    }

    // ============================================================
    // 6. TROCEAR TEXTO (split) + CONVERTIR A NÚMERO (parseInt)
    // ============================================================
    static void bloqueSplit() {
        String entrada = "54-12-25-8";

        // split parte el texto cada vez que encuentra el separador
        String[] trozos = entrada.split("-");          // por guion
        String[] trozosEspacio = "54 12 25 8".split(" ");// por espacio
        String[] trozosComa = "1,2,3".split(",");        // por coma

        System.out.println("primer trozo = " + trozos[0]);
        System.out.println("cuantos trozos = " + trozos.length);

        // Cada trozo es TEXTO; para sumarlo hay que pasarlo a número:
        int primerNumero = Integer.parseInt(trozos[0]);
        System.out.println("primer trozo como numero +1 = " + (primerNumero + 1));

        // Patrón típico: sumar todos los trozos
        int sumaTotal = 0;
        for (String unTrozo : trozos) {
            sumaTotal += Integer.parseInt(unTrozo);
        }
        System.out.println("suma total = " + sumaTotal + "  ->  100 - suma = " + (100 - sumaTotal));
    }

    // ============================================================
    // 7. COMPROBAR FORMATOS con matches (expresiones regulares)
    //    matches devuelve true si TODO el texto cumple el patrón.
    // ============================================================
    static void bloqueFormatos() {
        System.out.println("formato N-N-N-N? " + "54-12-25-8".matches("\\d+-\\d+-\\d+-\\d+"));
        System.out.println("separado por espacios? " + "54 12 25 8".matches("\\d+ \\d+ \\d+ \\d+"));
        System.out.println("solo numeros? " + "12345".matches("\\d+"));
        System.out.println("solo letras? " + "Hola".matches("[a-zA-Z]+"));
        System.out.println("entre 1 y 2 digitos? " + "7".matches("\\d{1,2}"));
        System.out.println("email basico? " + "yo@correo.com".matches("\\S+@\\S+\\.\\S+"));

        // CHULETA de símbolos:
        //   \\d  = un dígito (0-9)         \\d+ = uno o más dígitos
        //   \\d{1,2} = entre 1 y 2 dígitos [a-zA-Z]+ = una o más letras
        //   .*  = cualquier cosa           \\s = espacio    \\S = NO espacio
    }

    // ============================================================
    // 8. VALIDAR DATOS: repetir hasta que sean correctos (do-while)
    //    Versión simulada (sin teclado) para que veas la lógica.
    // ============================================================
    static void bloqueValidacionSimulada() {
        // Simulamos lo que escribiría el usuario: la 1ª suma 105 (mal), la 2ª 35 (bien)
        String[] loQueEscribeElUsuario = {"40-30-25-10", "10-10-10-5"};
        int posicion = 0;
        int suma;

        do {
            String lineaIntroducida = loQueEscribeElUsuario[posicion]; // en real: teclado.nextLine()
            posicion++;
            System.out.println("Introduce los datos: " + lineaIntroducida);

            String[] trozos = lineaIntroducida.split("-");
            suma = 0;
            for (String unTrozo : trozos) {
                suma += Integer.parseInt(unTrozo);
            }

            if (suma >= 100) {
                System.out.println("ERROR. La suma es mayor a 100. Repite.");
            }
        } while (suma >= 100);   // repite MIENTRAS la suma sea 100 o más

        System.out.println("Datos correctos. Resultado: " + (100 - suma));
    }

    // ============================================================
    // 9. MÉTODOS: trozos de código con nombre que puedes reutilizar.
    //    "void" = no devuelve nada.  "int/String..." = devuelve ese tipo.
    // ============================================================
    static void bloqueMetodos() {
        saludar("Ivan");                       // llamar a un método sin retorno
        int resultado = sumar(3, 4);           // llamar a uno que devuelve un valor
        System.out.println("sumar(3,4) = " + resultado);
        System.out.println("esPar(10) = " + esPar(10));
    }

    /** Método que NO devuelve nada (void). */
    static void saludar(String nombre) {
        System.out.println("Hola, " + nombre + "!");
    }

    /** Método que DEVUELVE un entero (usa return). */
    static int sumar(int primero, int segundo) {
        return primero + segundo;
    }

    /** Método que DEVUELVE true/false. */
    static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // ============================================================
    // 10. LISTAS (ArrayList): como un array pero que CRECE y MENGUA.
    // ============================================================
    static void bloqueListas() {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("Ana");          // añadir al final
        listaDeNombres.add("Luis");
        listaDeNombres.add(0, "Pepe");      // insertar en la posición 0
        System.out.println("lista: " + listaDeNombres);

        System.out.println("el primero: " + listaDeNombres.get(0));
        listaDeNombres.set(1, "Marta");     // cambiar el de la posición 1
        listaDeNombres.remove("Pepe");      // borrar por valor
        listaDeNombres.remove(0);           // borrar por posición
        System.out.println("tras cambios: " + listaDeNombres);

        System.out.println("cuantos hay = " + listaDeNombres.size());
        System.out.println("esta vacia? " + listaDeNombres.isEmpty());
        System.out.println("contiene 'Luis'? " + listaDeNombres.contains("Luis"));
        System.out.println("posicion de 'Luis' = " + listaDeNombres.indexOf("Luis"));
    }

    // ============================================================
    // 11. RECORRER LISTAS: 3 formas (for-each, for con índice, iterador)
    // ============================================================
    static void bloqueRecorrerListas() {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("Ana");
        listaDeNombres.add("Borrame");
        listaDeNombres.add("Luis");

        // FORMA 1: for-each (la más cómoda para LEER)
        System.out.print("for-each: ");
        for (String unNombre : listaDeNombres) {
            System.out.print(unNombre + " ");
        }
        System.out.println();

        // FORMA 2: for con índice (cuando necesitas saber la posición)
        for (int posicion = 0; posicion < listaDeNombres.size(); posicion++) {
            System.out.println("  posicion " + posicion + " = " + listaDeNombres.get(posicion));
        }

        // FORMA 3: iterador (OBLIGATORIO si quieres BORRAR mientras recorres)
        Iterator<String> recorredor = listaDeNombres.iterator();
        while (recorredor.hasNext()) {        // ¿queda algún elemento?
            String elemento = recorredor.next();  // coge el siguiente
            if (elemento.equals("Borrame")) {
                recorredor.remove();          // borrado seguro
            }
        }
        System.out.println("tras borrar con iterador: " + listaDeNombres);
    }

    // ============================================================
    // 12. COLA FIFO (Queue): el PRIMERO que entra es el PRIMERO que sale.
    //     Como la cola del super.
    // ============================================================
    static void bloqueColaFifo() {
        Queue<String> colaDeEspera = new LinkedList<>();
        colaDeEspera.offer("Ana");   // se ponen en la cola (al final)
        colaDeEspera.offer("Luis");
        colaDeEspera.offer("Marta");
        System.out.println("cola: " + colaDeEspera);
        System.out.println("quien es el primero (sin sacarlo): " + colaDeEspera.peek());

        // Atender a todos en orden de llegada:
        while (!colaDeEspera.isEmpty()) {        // mientras quede gente
            String siguiente = colaDeEspera.poll(); // saca al primero de la cola
            System.out.println("atiendo a: " + siguiente);
        }
        System.out.println("cola vacia? " + colaDeEspera.isEmpty());
    }

    // ============================================================
    // 13. PILA LIFO (Deque): el ÚLTIMO que entra es el PRIMERO que sale.
    //     Como un montón de platos.
    // ============================================================
    static void bloquePilaLifo() {
        Deque<String> pilaDePlatos = new ArrayDeque<>();
        pilaDePlatos.push("Plato 1");   // apilar encima
        pilaDePlatos.push("Plato 2");
        pilaDePlatos.push("Plato 3");
        System.out.println("plato de arriba: " + pilaDePlatos.peek());
        System.out.println("quito el de arriba: " + pilaDePlatos.pop()); // sale el último puesto
        System.out.println("pila ahora: " + pilaDePlatos);
    }

    // ============================================================
    // 14. MAPAS (HashMap): pares CLAVE -> VALOR. Como una agenda:
    //     buscas por el nombre (clave) y obtienes el teléfono (valor).
    // ============================================================
    static void bloqueMapas() {
        Map<String, Integer> agendaTelefonica = new HashMap<>();
        agendaTelefonica.put("Ana", 600111222);    // guardar clave -> valor
        agendaTelefonica.put("Luis", 600333444);
        agendaTelefonica.put("Marta", 600555666);

        System.out.println("telefono de Ana = " + agendaTelefonica.get("Ana"));
        System.out.println("telefono desconocido = " + agendaTelefonica.getOrDefault("Pepe", -1));
        System.out.println("esta Luis? " + agendaTelefonica.containsKey("Luis"));
        System.out.println("alguien con ese num? " + agendaTelefonica.containsValue(600555666));

        agendaTelefonica.remove("Marta");           // borrar por clave
        System.out.println("cuantos contactos = " + agendaTelefonica.size());
    }

    // ============================================================
    // 15. RECORRER MAPAS: varias formas
    // ============================================================
    static void bloqueRecorrerMapas() {
        Map<String, Integer> agendaTelefonica = new HashMap<>();
        agendaTelefonica.put("Ana", 600111222);
        agendaTelefonica.put("Luis", 600333444);

        // FORMA 1: recorrer CLAVE y VALOR a la vez (lo más usado)
        System.out.println("-- clave y valor --");
        for (Map.Entry<String, Integer> contacto : agendaTelefonica.entrySet()) {
            System.out.println("  " + contacto.getKey() + " -> " + contacto.getValue());
        }

        // FORMA 2: recorrer solo las CLAVES
        System.out.println("-- solo claves --");
        for (String nombreContacto : agendaTelefonica.keySet()) {
            System.out.println("  " + nombreContacto);
        }

        // FORMA 3: recorrer solo los VALORES
        System.out.println("-- solo valores --");
        for (Integer numeroTelefono : agendaTelefonica.values()) {
            System.out.println("  " + numeroTelefono);
        }

        // FORMA 4: recorrer un mapa con ITERADOR (por si lo piden así)
        System.out.println("-- con iterador --");
        Iterator<Map.Entry<String, Integer>> recorredor = agendaTelefonica.entrySet().iterator();
        while (recorredor.hasNext()) {
            Map.Entry<String, Integer> contacto = recorredor.next();
            System.out.println("  " + contacto.getKey() + " -> " + contacto.getValue());
        }
    }

    // ============================================================
    // 16. PROGRAMACIÓN ORIENTADA A OBJETOS
    //     enum + interfaz + clase abstracta + herencia + instanceof
    // ============================================================
    static void bloquePoo() {
        // Creamos objetos de las clases HIJAS (la abstracta no se puede crear)
        Animal miPerro = new Perro("Toby", "Labrador");
        Animal miGato = new Gato("Misi", true);

        miPerro.hacerSonido();   // cada uno suena distinto (polimorfismo)
        miGato.hacerSonido();
        miPerro.serAcariciado(); // método que viene de la interfaz

        System.out.println(miPerro);   // usa el toString()
        System.out.println(miGato);

        // instanceof: saber de qué tipo es realmente un objeto
        if (miGato instanceof Gato) {
            Gato gatoDeVerdad = (Gato) miGato;   // casting para usar sus métodos propios
            System.out.println("Misi es cazador? " + gatoDeVerdad.isCazador());
        }

        // ENUM en acción:
        Estado estadoActual = Estado.EN_COLA;
        System.out.println("estado = " + estadoActual);
        System.out.println("ya bendecido? " + (estadoActual == Estado.BENDECIDO));
    }

    // --- ENUM: una lista CERRADA de valores posibles ---
    enum Estado { SOLICITUD_OK, EN_COLA, BENDECIDO }

    // --- INTERFAZ: dice QUÉ métodos hay, pero no CÓMO (lo rellena cada clase) ---
    interface Acariciable {
        void serAcariciado();
    }

    // --- CLASE ABSTRACTA: plantilla común. NO se puede hacer "new Animal()" ---
    static abstract class Animal implements Acariciable {
        protected String nombre;       // lo comparten todas las hijas
        protected Estado estado;

        // Constructor: se ejecuta al crear el objeto
        public Animal(String nombre) {
            this.nombre = nombre;          // "this" = este objeto
            this.estado = Estado.SOLICITUD_OK;
        }

        // Método abstracto: cada hija ESTÁ OBLIGADA a escribirlo
        public abstract void hacerSonido();

        // Implementación común de la interfaz (las hijas la heredan)
        @Override
        public void serAcariciado() {
            System.out.println(nombre + " disfruta la caricia");
        }

        public String getNombre() { return nombre; }

        // toString: cómo se "imprime" el objeto
        @Override
        public String toString() {
            return getClass().getSimpleName() + ": " + nombre + " [" + estado + "]";
        }
    }

    // --- CLASE HIJA 1: hereda de Animal con "extends" ---
    static class Perro extends Animal {
        private String raza;            // atributo propio de Perro
        public Perro(String nombre, String raza) {
            super(nombre);              // llama al constructor del padre (Animal)
            this.raza = raza;
        }
        @Override
        public void hacerSonido() {
            System.out.println(nombre + " (perro) hace: Guau");
        }
        public String getRaza() { return raza; }
    }

    // --- CLASE HIJA 2 ---
    static class Gato extends Animal {
        private boolean cazador;
        public Gato(String nombre, boolean cazador) {
            super(nombre);
            this.cazador = cazador;
        }
        @Override
        public void hacerSonido() {
            System.out.println(nombre + " (gato) hace: Miau");
        }
        public boolean isCazador() { return cazador; }
    }

    // ============================================================
    // 17. CARGAR DATOS EN EL MAIN (poblar una lista de objetos)
    //     Esto es lo típico del "carga manual de datos" del examen.
    // ============================================================
    static void bloqueCargarDatos() {
        // 1) Creamos la lista vacía donde guardaremos los objetos
        List<Animal> listaDeAnimales = new ArrayList<>();

        // 2) Creamos varios objetos y los AÑADIMOS a la lista
        listaDeAnimales.add(new Perro("Toby", "Labrador"));
        listaDeAnimales.add(new Perro("Rex", "Pastor"));
        listaDeAnimales.add(new Gato("Misi", true));
        listaDeAnimales.add(new Gato("Felix", false));

        // 3) Recorremos la lista para comprobar que se han metido bien
        System.out.println("--- Contenido de la lista ---");
        for (Animal unAnimal : listaDeAnimales) {
            System.out.println(unAnimal);   // usa toString() de cada objeto
        }

        // EXTRA: filtrar por tipo con instanceof (sin streams, con for normal)
        System.out.println("--- Solo los gatos ---");
        for (Animal unAnimal : listaDeAnimales) {
            if (unAnimal instanceof Gato) {
                System.out.println("  " + unAnimal.getNombre() + " es un gato");
            }
        }

        // EXTRA 2: evitar duplicados antes de añadir (patrón del examen)
        String nombreNuevo = "Toby";
        boolean yaExiste = false;
        for (Animal unAnimal : listaDeAnimales) {
            if (unAnimal.getNombre().equals(nombreNuevo)) {
                yaExiste = true;
                break;   // ya lo encontramos, no hace falta seguir
            }
        }
        System.out.println("¿'Toby' ya existe? " + yaExiste + " (no lo anadimos otra vez)");
    }

    // ============================================================
    // 18. SALIDA POR PANTALLA Y FORMATOS
    // ============================================================
    static void bloqueSalida() {
        System.out.println("println escribe y SALTA de linea");
        System.out.print("print NO salta... ");
        System.out.print("seguimos en la misma linea\n");

        String nombre = "Ivan";
        int porcentaje = 1;
        System.out.println("Hola " + nombre + ", tienes " + porcentaje + "% de culpa");

        // printf: formato controlado.  %d=entero  %s=texto  %f=decimal  %%=signo %  %n=salto
        System.out.printf("Con printf: tienes un %d%% de culpa.%n", porcentaje);
        System.out.printf("Texto y numero: %s tiene %d puntos.%n", nombre, 100);
        System.out.printf("Decimal con 2 cifras: %.2f%n", 3.14159);
    }

    // ============================================================
    // 19. CADENAS (String): métodos útiles
    // ============================================================
    static void bloqueCadenas() {
        String saludo = "Hola Mundo";

        System.out.println("longitud: " + saludo.length());
        System.out.println("mayusculas: " + saludo.toUpperCase());
        System.out.println("minusculas: " + saludo.toLowerCase());
        System.out.println("contiene 'Mundo'? " + saludo.contains("Mundo"));
        System.out.println("primer caracter: " + saludo.charAt(0));
        System.out.println("trozo (0 a 4): " + saludo.substring(0, 4));
        System.out.println("sin espacios extra: '" + "  hola  ".trim() + "'");

        // MUY IMPORTANTE: para comparar textos usa equals, NUNCA ==
        String texto1 = "perro";
        String texto2 = "PERRO";
        System.out.println("equals: " + texto1.equals(texto2));                 // false
        System.out.println("equalsIgnoreCase: " + texto1.equalsIgnoreCase(texto2)); // true
    }

    // ============================================================
    //  MÉTODOS INTERACTIVOS (usan teclado) — descoméntalos en el main
    // ============================================================
    static void bloqueTeclado() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe tu nombre: ");
        String nombre = teclado.nextLine();   // lee una línea entera

        System.out.print("Escribe tu edad: ");
        int edad = teclado.nextInt();         // lee un entero
        teclado.nextLine();                   // limpia el salto de línea pendiente

        System.out.println("Hola " + nombre + ", tienes " + edad + " anos");
    }

    static void bloqueValidacionReal() {
        Scanner teclado = new Scanner(System.in);
        int suma;
        do {
            System.out.print("Introduce 4 numeros con guiones (N-N-N-N): ");
            String linea = teclado.nextLine();
            String[] trozos = linea.split("-");
            suma = 0;
            for (String unTrozo : trozos) {
                suma += Integer.parseInt(unTrozo);
            }
            if (suma >= 100) {
                System.out.println("ERROR. La suma es mayor a 100.");
            }
        } while (suma >= 100);
        System.out.println("Resultado: " + (100 - suma));
    }
}