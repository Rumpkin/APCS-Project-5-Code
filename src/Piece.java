public class Piece {
    // instance variables go here!
    private int row;
    private int column;
    private int color;

    public Piece(int col, int color, Board board) { // constructor!
        column = col;
        row = findRow(col, board);
        System.out.println("row: " + row);
        this.color = color;
    }

    private int findRow(int column, Board board) { // given the state of the board, and a column, it returns the row
        int[][] boardPieces = board.getBoardPieces();

        if (this instanceof MegaPiece) {
            //FIX EL MEGA PIECE
            if (column + 1 >= boardPieces.length || column - 1 < 0)
                return -1;

            if (boardPieces[column][0] != 0 || boardPieces[column - 1][0] != 0 || boardPieces[column + 1][0] != 0)
                return -1;

            for (int i = 0; i < boardPieces[0].length; i++) {
                System.out.println("AHJ : " + i);
                if (boardPieces[i][column] != 0)
                    return i - 2;

                if (boardPieces[i + 1][column] != 0)
                    return i - 2;

                if (boardPieces[i + 2][column] != 0)
                    return i - 2;
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
