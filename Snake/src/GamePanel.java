import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private static final int TILE_SIZE = 30;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(game.getBoard().COL_COUNT * TILE_SIZE, game.getBoard().ROW_COUNT * TILE_SIZE));
        setBackground(Color.BLACK);

        // Add key listener to capture key events
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W && game.getDirection() != Game.DIRECTION_DOWN) {
                    game.setDirection(Game.DIRECTION_UP);
                } else if (e.getKeyCode() == KeyEvent.VK_A && game.getDirection() != Game.DIRECTION_RIGHT) {
                    game.setDirection(Game.DIRECTION_LEFT);
                } else if (e.getKeyCode() == KeyEvent.VK_S && game.getDirection() != Game.DIRECTION_UP) {
                    game.setDirection(Game.DIRECTION_DOWN);
                } else if (e.getKeyCode() == KeyEvent.VK_D && game.getDirection() != Game.DIRECTION_LEFT) {
                    game.setDirection(Game.DIRECTION_RIGHT);
                }
            }
        });
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        Board board = game.getBoard();
        Snake snake = game.getSnake();

        // Draw the game cells: empty cells, food, and snake
        for (int row = 0; row < board.ROW_COUNT; row++) {
            for (int col = 0; col < board.COL_COUNT; col++) {
                Cell cell = board.getCells()[row][col];

                // Draw empty cells (white)
                if (cell.getCellType() == CellType.EMPTY) {
                    g.setColor(Color.WHITE); // Empty cells color
                    g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }

        // Now draw the snake on the board (green)
        for (Cell cell : snake.getSnakePartList()) {
            g.setColor(Color.GREEN); // Snake color
            g.fillRect(cell.getcol() * TILE_SIZE, cell.getRow() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Draw food after snake (so it isn't overwritten) - set food color to blue
        for (int row = 0; row < board.ROW_COUNT; row++) {
            for (int col = 0; col < board.COL_COUNT; col++) {
                Cell cell = board.getCells()[row][col];
                if (cell.getCellType() == CellType.FOOD) {
                    g.setColor(Color.BLUE); // Food color is blue
                    g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }

        // Game Over message (red text)
        if (game.isGameOver()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", getWidth() / 4, getHeight() / 2);
        }
    }
}
