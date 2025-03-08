import java.util.LinkedList;

public class Snake {
    private LinkedList<Cell> snakePartList = new LinkedList<>();
    private Cell head;

    public Snake(Cell initPos) {
        head = initPos;
        snakePartList.add(head);
        head.setCellType(CellType.SNAKE_NODE);
    }

    public void grow() {
        Cell tail = snakePartList.getLast();  // Get the current tail
        Cell newTail = new Cell(tail.getRow(), tail.getcol()); // Create a new cell for the tail
        newTail.setCellType(CellType.SNAKE_NODE); // Set the new cell as a snake node
        snakePartList.addLast(newTail); // Add the new cell to the end of the snake
    }

    public void move(Cell nextCell) {
        // Remove the tail only if the snake doesn't eat food
        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);  // Clear the old tail
        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePartList.addFirst(head);  // Add the new head to the front
    }

    public boolean checkCrash(Cell nextCell) {
        for (Cell cell : snakePartList) {
            if (cell.getRow() == nextCell.getRow() && cell.getcol() == nextCell.getcol()) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Cell> getSnakePartList() {
        return snakePartList;
    }

    public void setSnakePartList(LinkedList<Cell> snakePartList) {
        this.snakePartList = snakePartList;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }
}
