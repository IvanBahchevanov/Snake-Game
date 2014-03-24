

package mysnake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class TAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        
        if ( e.getKeyCode() == KeyEvent.VK_RIGHT &&  !GameBoard.left_direction ) {
            GameBoard.right_direction = true;
            GameBoard.up_direction = false;
            GameBoard.down_direction = false;
        }
        
        if ( e.getKeyCode() == KeyEvent.VK_LEFT && !GameBoard.right_direction ) {
            GameBoard.left_direction = true;
            GameBoard.up_direction = false;
            GameBoard.down_direction = false;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP && !GameBoard.down_direction) {
            GameBoard.up_direction = true;
            GameBoard.left_direction = false;
            GameBoard.right_direction = false;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN && !GameBoard.up_direction) {
            GameBoard.down_direction = true;
            GameBoard.left_direction = false;
            GameBoard.right_direction = false;
        }
        
    }
}
