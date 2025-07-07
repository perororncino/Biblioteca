package Modelo;


public class AVLNode {
    public Producto producto;
    public AVLNode izquierda, derecha;
    public int altura;

    public AVLNode(Producto producto) {
        this.producto = producto;
        this.izquierda = null;
        this.derecha = null;
        this.altura = 1; // Altura inicial para un nuevo nodo
    }
}