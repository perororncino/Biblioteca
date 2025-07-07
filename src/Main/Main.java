
package Main;

import javax.swing.SwingUtilities;
import Vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
    

