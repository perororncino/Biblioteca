package Modelo;
import Modelo.Movimiento;

import java.util.function.Consumer;

public class HistorialMovimiento {
    private class Nodo {
        Movimiento movimiento;
        Nodo anterior, siguiente;

        public Nodo(Movimiento movimiento) {
            this.movimiento = movimiento;
        }
    }

    private Nodo cabeza, cola;

    public void agregarMovimiento(Movimiento movimiento) {
        Nodo nuevo = new Nodo(movimiento);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

   
    public void recorrer(Consumer<Movimiento> accion) {
        Nodo actual = cabeza;
        while (actual != null) {
            accion.accept(actual.movimiento);
            actual = actual.siguiente;
        }
    }

    
    public void mostrarHistorial() {
        recorrer(m -> System.out.println(m));
    }
}