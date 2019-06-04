import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class Rotation {
    private static class VerticalTextField extends JTextField {

        private static final long serialVersionUID = 1L;

        public VerticalTextField(String text) {
            super(text);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            int cx = getWidth() / 2;
            int cy = getHeight() / 2;
            g2.rotate(Math.PI, cx, cy);
            super.paintComponent(g2);
        }
        public JLabel getLabel(){}
    }
}