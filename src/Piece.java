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
            if (column + 1 >= boardPieces.length || column - 1 < 0)
                return -1;

            if (boardPieces[column][0] != 0 || boardPieces[column - 1][0] != 0 || boardPieces[column + 1][0] != 0)
                return -1;

            for (int i = 0; i < boardPieces[column].length; i++) {
                if (boardPieces[column][i] != 0)
                    return i - 2;

                if (boardPieces[column + 1][i] != 0)
                    return i - 2;

                if (boardPieces[column - 1][i] != 0)
                    return i - 2;
            }

            return boardPieces[column].length - 2;
        } else {
            if (boardPieces[column][0] != 0)
                return -1;

            for (int i = 0; i < boardPieces[column].length; i++) {
                if (boardPieces[column][i] != 0)
                    return i - 1;
            }

            return boardPieces[column].length - 1;
        }
    }
    public int getCol() {
        return column;
    } //FIXME
    public int getRow() {
        return row;
    }
    public int getColor() {
        return color;
    }
}
