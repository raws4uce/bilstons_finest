package restart;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class ClManager extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;

    public ClManager() {
    	cardLayout = new CardLayout();
        setLayout(cardLayout);
    }

    public void addPanel(String panelName, JPanel panel) {
        add(panel, panelName);
    }

    public void showPanel(String panelName) {
        cardLayout.show(this, panelName);
    }
}
