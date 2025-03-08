import java.util.List;
import java.util.ArrayList;
public class Board {
    final int ROW_COUNT;
    final int COL_COUNT;
    private Cell[][] cells;

    public Board(int rowcount, int colcount) {
        ROW_COUNT = rowcount;
        COL_COUNT = colcount;
        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT; column++) {
                cells[row][column] = new Cell(row, column);
                cells[row][column].setCellType(CellType.EMPTY);  // Set all cells to EMPTY by default
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generateFood() {
        List<Cell> emptyCells = new ArrayList<>();
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                if (cells[row][col].getCellType() == CellType.EMPTY) {
                    emptyCells.add(cells[row][col]);
                }
            }
        }
        if (!emptyCells.isEmpty()) {
            Cell randomCell = emptyCells.get((int) (Math.random() * emptyCells.size()));
            randomCell.setCellType(CellType.FOOD);
            System.out.println("Food generated at: " + randomCell.getRow() + ", " + randomCell.getcol());  // Debug line
        }
    }
}
