package modelo;
import Modelo.Producto;
import Modelo.AVLNode;
import java.util.function.Consumer;

public class AVLTree {
    private AVLNode raiz;


    public void insertar(Producto producto) {
        raiz = insertar(raiz, producto);
    }

    private AVLNode insertar(AVLNode nodo, Producto producto) {
        if (nodo == null) return new AVLNode(producto);

        if (producto.getId() < nodo.producto.getId())
            nodo.izquierda = insertar(nodo.izquierda, producto);
        else if (producto.getId() > nodo.producto.getId())
            nodo.derecha = insertar(nodo.derecha, producto);
        else return nodo; 

        actualizarAltura(nodo);
        return balancear(nodo);
    }


    public Producto buscar(int id) {
        return buscar(raiz, id);
    }

    private Producto buscar(AVLNode nodo, int id) {
        if (nodo == null) return null;
        if (id == nodo.producto.getId()) return nodo.producto;
        if (id < nodo.producto.getId()) return buscar(nodo.izquierda, id);
        else return buscar(nodo.derecha, id);
    }


    private void actualizarAltura(AVLNode nodo) {
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
    }

    private int altura(AVLNode nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private int getBalance(AVLNode nodo) {
        return (nodo == null) ? 0 : altura(nodo.izquierda) - altura(nodo.derecha);
    }

    private AVLNode rotarDerecha(AVLNode y) {
        AVLNode x = y.izquierda;
        AVLNode T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    private AVLNode rotarIzquierda(AVLNode x) {
        AVLNode y = x.derecha;
        AVLNode T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    private AVLNode balancear(AVLNode nodo) {
        int balance = getBalance(nodo);

      
        if (balance > 1) {
            if (getBalance(nodo.izquierda) < 0)
                nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        
        if (balance < -1) {
            if (getBalance(nodo.derecha) > 0)
                nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    
    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(AVLNode nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.println(nodo.producto);
            inOrden(nodo.derecha);
        }
    }

    
    public void inOrden(Consumer<AVLNode> accion) {
        inOrden(this.raiz, accion);
    }

    private void inOrden(AVLNode nodo, Consumer<AVLNode> accion) {
        if (nodo != null) {
            inOrden(nodo.izquierda, accion);
            accion.accept(nodo);
            inOrden(nodo.derecha, accion);
        }
    }
}