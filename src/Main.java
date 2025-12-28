import javax.swing.SwingUtilities;
import ui.DashboardUI;

public class Main {
    public static void main(String[] args) {

        // Start Swing application on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new DashboardUI().setVisible(true);
        });

    }
}
