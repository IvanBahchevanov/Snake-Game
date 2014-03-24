
package mysnake;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;


public class InfoPanel extends JPanel {
    public InfoPanel() {
        setPreferredSize(new Dimension(200, 300));
        setBackground(Color.white);
        add(GameBoard.scoreLabel);
    }
}
