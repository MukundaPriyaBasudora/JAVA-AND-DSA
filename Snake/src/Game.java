import javax.swing.*;
import java.util.LinkedList;

public class Game {
    public static final int DIRECTION_NONE = 0,
            DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1,
            DIRECTION_UP = 2, DIRECTION_DOWN = -2;

    private Snake snake;
    private Board board;
    private int direction;
    private boolean gameOver;
    private Timer gameTimer;

    public Game(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Update the game state
    public void update() {
        if (!gameOver) {
            if (direction != DIRECTION_NONE) {
                Cell nextCell = getNextCell(snake.getHead());

                // If next cell is invalid or out of bounds, the game ends
                if (nextCell == null || snake.checkCrash(nextCell)) {
                    gameOver = true;
                    return;
                }

                if (nextCell.getCellType() == CellType.FOOD) {
                    snake.grow();
                    board.generateFood();  // Generate a new food location
                } else {
                    snake.move(nextCell);  // Move the snake if it hasn't eaten food
                }

                adjustSpeed();  // Adjust speed as snake grows
            }
        }
    }

    // Determine the next cell based on the snake's current direction
    private Cell getNextCell(Cell currentPosition) {
        int row = currentPosition.getRow();
        int col = currentPosition.getcol();

        if (direction == DIRECTION_RIGHT) {
            col++;
        } else if (direction == DIRECTION_LEFT) {
            col--;
        } else if (direction == DIRECTION_UP) {
            row--;
        } else if (direction == DIRECTION_DOWN) {
            row++;
        }

        // Check if the new cell is within the bounds of the board
        if (row < 0 || row >= board.ROW_COUNT || col < 0 || col >= board.COL_COUNT) {
            return null; // Out of bounds, return null
        }

        return board.getCells()[row][col];
    }

    // The main game loop
    public void startGame() {
        JFrame frame = new JFrame("Snake Game");
        GamePanel panel = new GamePanel(this);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Adjust the Timer delay to slow down the game (starting at 200ms)
        gameTimer = new Timer(400, e -> {
            update(); // Update the game state
            panel.repaint(); // Repaint the game panel
        });
        gameTimer.start();
    }

    // Adjust speed based on the snake's size (increase difficulty)
    public void adjustSpeed() {
        // Cap the speed increase to avoid it getting too fast
        gameTimer.setDelay(Math.max(100, 200 - (snake.getSnakePartList().size() * 5)));
    }

    public static void main(String[] args) {
        Cell initPos = new Cell(0, 0);
        Snake initSnake = new Snake(initPos);
        Board board = new Board(10, 10);
        Game newGame = new Game(initSnake, board);
        newGame.setGameOver(false);
        newGame.setDirection(DIRECTION_RIGHT);
        newGame.startGame(); // Start the game with the GUI
    }
}
