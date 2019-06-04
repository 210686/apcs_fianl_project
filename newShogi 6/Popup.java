import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Popup{
    private boolean isYes;
    private JFrame f;
    private JButton b1, b2;
    public Popup(String str){
        f = new JFrame(str);
        Runnable r = new Runnable()
            {
                @Override
                public void run() {
                    f.setLayout(null);

                    b1 = new JButton("Yes");
                    b1.setSize(100, 30);
                    b2 = new JButton("No");
                    b2.setBounds(100, 0, 100, 30);
                    f.add(b1);
                    f.add(b2);

                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            isYes = true;
                            f.setVisible(false);
                        }
                    });
                    b2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            isYes = false;
                            f.setVisible(false);
                        }
                    });
                    
                    f.setSize(200, 50);
                    f.setMinimumSize(f.getSize());
                    f.setMaximumSize(f.getSize());
                    f.pack();
                    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                }
            };
        SwingUtilities.invokeLater(r);
    }
    
    public boolean getResult(){
        return isYes;
    }
    
    public void disposeWindow(){
        f.dispose();
    }
}