import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeApp {
    private JFrame window;

    SnakeApp() {
        window = new JFrame("贪吃蛇");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void init() {
        /* 创建grid,  */
        Grid grid = new Grid();

        /* 创建gameVies */
        GameView gameView = new GameView(grid);
        gameView.init();
        JPanel canvas = gameView.getCanvas();

        window.add(canvas, BorderLayout.CENTER);
        window.pack();
        window.setVisible(true);


        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        grid.changeDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        grid.changeDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        grid.changeDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        grid.changeDirection(Direction.RIGHT);
                        break;
                }

                grid.move();
//                gameView.draw();
                canvas.repaint();
            }
        });
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}
