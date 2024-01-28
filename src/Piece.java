public class Piece {
    // instance variables go here!
    private int row;
    private int column;
    private int color;

    public Piece(int col, int color, Board board) { // constructor!
        column = col;
        row = findRow(col, board);
        this.color = color;
    }

    private int findRow(int column, Board board) { // given the state of the board, and a column, it returns the row
        int[][] boardPieces = board.getBoardPieces();

        if (this instanceof MegaPiece) {
            for (int j = -1; j < boardPieces.length - 2; j++) {
                if (boardPieces[j + 2][column - 1] != 0 || boardPieces[j + 2][column] != 0 || boardPieces[j + 2][column + 1] != 0) {
                    return j;
                }
            }
            return boardPieces.length - 2;
        } else {
            for (int i = 0; i < boardPieces.length; i++) {
                if (boardPieces[i][column] != 0)
                    return i - 1;
            }

            return boardPieces.length - 1;
        }
    }
    public int getCol() {
        return column;
    }
    public int getRow() {
        return row;
    }
    public int getColor() {
        return color;
    }
}
