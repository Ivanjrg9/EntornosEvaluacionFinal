package org.example.ChuletaIzan;

import java.util.*;

public class olecciones {
    public static void main(String[] args) {
        hashSet();
        linkedHashSet();
        treeSet();
        arrayList();
        linkedList();
        queue();
        deque();
        hashMap();
        linkedHashMap();
        treeMap();
        mapInterfaz();
    }

    static void hashSet() {
        System.out.println("===== HashSet (sin orden, sin duplicados) =====");
        Set<String> set = new HashSet<>();
        set.add("rojo");
        set.add("verde");
        set.add("azul");
        set.add("rojo");
        System.out.println("Contenido: " + set);
        System.out.println("¿Contiene 'verde'? " + set.contains("verde"));
        System.out.println("Tamaño: " + set.size());
        System.out.println();
    }

    static void linkedHashSet() {
        System.out.println("===== LinkedHashSet (mantiene orden de inserción) =====");
        Set<String> set = new LinkedHashSet<>();
        set.add("lunes");
        set.add("martes");
        set.add("miércoles");
        set.add("lunes");
        System.out.println("Contenido: " + set);
        System.out.println();
    }

    static void treeSet() {
        System.out.println("===== TreeSet (ordenado de forma natural) =====");
        TreeSet<Integer> set = new TreeSet<>();
        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);
        System.out.println("Contenido ordenado: " + set);
        System.out.println("Primero (menor): " + set.first());
        System.out.println("Último (mayor): " + set.last());
        System.out.println();
    }

    static void arrayList() {
        System.out.println("===== ArrayList (lista indexada, acceso rápido por índice) =====");
        List<String> lista = new ArrayList<>();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add(1, "X");
        System.out.println("Contenido: " + lista);
        System.out.println("Elemento en índice 2: " + lista.get(2));
        lista.remove("X");
        System.out.println("Tras eliminar 'X': " + lista);
        System.out.println();
    }

    static void linkedList() {
        System.out.println("===== LinkedList (lista enlazada, rápida al insertar/borrar en extremos) =====");
        LinkedList<String> lista = new LinkedList<>();
        lista.add("centro");
        lista.addFirst("inicio");
        lista.addLast("final");
        System.out.println("Contenido: " + lista);
        System.out.println("Primero: " + lista.getFirst());
        System.out.println("Último: " + lista.getLast());
        System.out.println();
    }

    static void queue() {
        System.out.println("===== Queue (FIFO: primero en entrar, primero en salir) =====");
        Queue<String> cola = new LinkedList<>();
        cola.offer("cliente1");
        cola.offer("cliente2");
        cola.offer("cliente3");
        System.out.println("Cola: " + cola);
        System.out.println("Atiende (peek): " + cola.peek());
        System.out.println("Saca (poll): " + cola.poll());
        System.out.println("Cola tras poll: " + cola);
        System.out.println();
    }

    static void deque() {
        System.out.println("===== Deque (doble extremo: pila o cola) =====");
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("B");
        deque.offerFirst("A");
        deque.offerLast("C");
        System.out.println("Deque: " + deque);
        System.out.println("Saca por delante: " + deque.pollFirst());
        System.out.println("Saca por detrás: " + deque.pollLast());
        System.out.println("Deque restante: " + deque);
        System.out.println();
    }

    static void hashMap() {
        System.out.println("===== HashMap (clave-valor, sin orden) =====");
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("manzanas", 5);
        mapa.put("peras", 3);
        mapa.put("plátanos", 8);
        System.out.println("Contenido: " + mapa);
        System.out.println("Valor de 'peras': " + mapa.get("peras"));
        System.out.println("¿Tiene clave 'uvas'? " + mapa.containsKey("uvas"));
        System.out.println();
    }

    static void linkedHashMap() {
        System.out.println("===== LinkedHashMap (clave-valor, mantiene orden de inserción) =====");
        Map<String, Integer> mapa = new LinkedHashMap<>();
        mapa.put("primero", 1);
        mapa.put("segundo", 2);
        mapa.put("tercero", 3);
        System.out.println("Contenido: " + mapa);
        System.out.println();
    }

    static void treeMap() {
        System.out.println("===== TreeMap (clave-valor, ordenado por clave) =====");
        TreeMap<String, Integer> mapa = new TreeMap<>();
        mapa.put("Carlos", 30);
        mapa.put("Ana", 25);
        mapa.put("Beatriz", 28);
        System.out.println("Contenido ordenado: " + mapa);
        System.out.println("Primera clave: " + mapa.firstKey());
        System.out.println("Última clave: " + mapa.lastKey());
        System.out.println();
    }

    static void mapInterfaz() {
        System.out.println("===== Map (interfaz: recorrer claves y valores) =====");
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("X", 10);
        mapa.put("Y", 20);
        mapa.put("Z", 30);
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            System.out.println("   " + entrada.getKey() + " -> " + entrada.getValue());
        }
        System.out.println("Solo claves: " + mapa.keySet());
        System.out.println("Solo valores: " + mapa.values());
        System.out.println();
    }
}
