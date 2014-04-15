package mysnake;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameBoard extends JPanel implements ActionListener  {
    
    private final int BOARD_WIDTH = 300;
    private final int BOARD_HEIGHT = 300;
    private final int STEP_SIZE = 10;
    private final int[] x = new int[300];
    private final int [] y = new int[300];
    
    private int body = 3;
    private int appleX;
    private int appleY;
    
    protected static boolean right_direction = false;
    protected static boolean down_direction = false;
    protected static boolean left_direction = false;
    protected  static boolean up_direction = false;
    
    private boolean death = false;
    
    protected static int score = 0;
    
    private int speed = 200;    
    Timer timer ;
    
    static JLabel scoreLabel;
    
    public GameBoard() {
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension( BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        scoreLabel = new JLabel("SCORE : ");
        startGame();
    }
    
   private void startGame(){
       
       for (int i = 0; i < body; i++) {
           x[i] = 100 - i*10;
           y[i] = 100;
       }
       
       dropApple();
       
       timer = new Timer(speed, this);
       timer.start();
   }  
   
    @Override
   public void paintComponent(Graphics gr) {
       super.paintComponent(gr);
       
       doDrowings(gr);
   }
   
   private void doDrowings(Graphics gr){
       if( !death) {
           gr.setColor(Color.red);
           gr.drawString("@", appleX, appleY); // draws the apple
       
           gr.drawString("O", x[0], y[0]);     // draws the snake head
       
                                           // the snake body
           gr.setColor(Color.GREEN);
           for (int i = 1; i < body; i++) {
                gr.drawString("O",  x[i], y[i]);
           }
       }
       else {
           setBackground(Color.red);
           gr.setColor(Color.BLACK);
           gr.drawString("0xDEATHBEEF", 100, 130);
           
       }
       
       Toolkit.getDefaultToolkit().sync();
       gr.dispose();
   }
   
    private void checkApple() {
        if ( (x[0] == appleX )&& (y[0] == appleY) ) {
             body++;
             score++;
             scoreLabel.setText("SCORE : " + score );
             
             dropApple();
        }
    }
    
    private void makeMove() {
        
        for (int i = body; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        
        if ( right_direction ) 
            x[0] += STEP_SIZE; 
            
        if (left_direction) 
            x[0] -= STEP_SIZE;
        
        if (down_direction)
            y[0] += STEP_SIZE;
        
        if (up_direction)
            y[0] -= STEP_SIZE;
        
    }
    
    /*
      generates the apples coordinates within the game field
    */
    private void dropApple(){
       
       appleX = (new Random().nextInt( BOARD_WIDTH / STEP_SIZE)) * STEP_SIZE;
       appleY = new Random().nextInt(BOARD_HEIGHT / STEP_SIZE) * STEP_SIZE;
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkApple();
        makeMove();
        detectCollision();
        repaint();
    }
    
    private void detectCollision() {
        if ( (x[0] >= BOARD_WIDTH ) || ( x[0] < 0 ) ) {
            death = true;
        }
        
        if ( ( y[0] >= BOARD_HEIGHT) || ( y[0] < 0 ) ) {
            
            death = true;
        }
        
        if (score > 2) {
            for (int i = body; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i] ) {
                death = true;
                }
            }
        }
    }
}
