/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.*;
import Modelo.*;
import vista.PanelBuscarProducto;
import vista.PanelHistorial;


import modelo.AVLTree;
public class VentanaPrincipal extends JFrame {
    private AVLTree arbolInventario = new AVLTree();
    private HistorialMovimiento historial = new HistorialMovimiento();

    public VentanaPrincipal() {
        setTitle("Sistema de Inventario");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

  
        JButton btnAgregar = new JButton("Agregar Producto");
        JButton btnVer = new JButton("Ver Inventario");
        JButton btnBuscar = new JButton("Buscar Producto");
        JButton btnEntrada = new JButton("Registrar Entrada");
        JButton btnSalida = new JButton("Registrar Salida");
        JButton btnHistorial = new JButton("Ver Historial");

        
        add(btnAgregar);
        add(btnVer);
        add(btnBuscar);
        add(btnEntrada);
        add(btnSalida);
        add(btnHistorial);

        // Acciones de botones
        btnAgregar.addActionListener(e -> new PanelAgregarProducto(this, arbolInventario));
        btnVer.addActionListener(e -> new PanelInventario(this, arbolInventario));
        btnBuscar.addActionListener(e -> new PanelBuscarProducto(this, arbolInventario));
        btnEntrada.addActionListener(e -> new PanelEntradaSalida(this, arbolInventario, historial, true));
        btnSalida.addActionListener(e -> new PanelEntradaSalida(this, arbolInventario, historial, false));
        btnHistorial.addActionListener(e -> new PanelHistorial(this, historial));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
