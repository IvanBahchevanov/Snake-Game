
package mysnake;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;


public class MySnake extends JFrame {

    public MySnake(){
        setLayout(new FlowLayout());
        add(new GameBoard());
        add(new InfoPanel());
        setTitle("My Snake");
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                    JFrame game = new MySnake();
                    game.setVisible(true);
                
            }
        });
        
         
    }

}
