public class Board {
    // declare instance variables here!
    private int[][] boardPieces;

    public Board(int x, int y) { // constructor!
        boardPieces = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                boardPieces[i][j] = 0;
            }
        }
    }
    public void placePiece(Piece p) { // updates the state of the board with the information of the Piece
        if (p instanceof MegaPiece) {
            for (int i = p.getRow() - 1; i < p.getRow() + 2; i++) {
                for (int z = p.getCol() - 1; z < p.getCol() + 2; z++) {
                    boardPieces[i][z] = p.getColor();
                }
            }

        } else {
            boardPieces[p.getRow()][p.getCol()] = p.getColor();
        }
    }


    public int[][] getBoardPieces() { // getter function for boardPieces array
        return boardPieces;
    }

    public void displayAll() { // displays the entire board
        // that's quite a nice display we've got right now (displays nothing)

        System.out.println("   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 ");
        for (int i = 0; i < boardPieces.length; i++) {
            System.out.print("#  ");
            for (int j = 0; j <boardPieces[i].length; j++) {

                switch (boardPieces[i][j]) {
                    case (0):
                        System.out.print(".  ");
                        break;

                    case (1):
                        System.out.print("X  ");
                        break;

                    case (2):
                        System.out.print("O  ");
                        break;
                }
            }
            System.out.print("#\n");
        }
        System.out.println("#  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #");
    }
    public boolean checkForWin(int player) {

        if (checkForWinHorizontal(player))
            return true;

        if (checkForWinVertical(player))
            return true;

        if (checkForWinDiagonalDown(player))
            return true;

        if (checkForWinDiagonalUp(player))
            return true;

        return false;
    }

    public boolean checkForWinHorizontal(int player) {
        for (int i = 0; i < boardPieces.length; i++) {
            for (int j = 0; j < boardPieces[i].length; j++) {
                if (j + 4 < boardPieces[i].length) {
                    if (boardPieces[i][j] == player && boardPieces[i][j + 1] == player && boardPieces[i][j + 2] == player && boardPieces[i][j + 3] == player && boardPieces[i][j + 4] == player)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean checkForWinVertical(int player) {
        for (int i = 0; i < boardPieces.length; i++) {
            for (int j = 0; j < boardPieces[i].length; j++) {
                if (i + 4 < boardPieces.length) {
                    if (boardPieces[i][j] == player && boardPieces[i + 1][j] == player && boardPieces[i + 2][j] == player && boardPieces[i + 3][j] == player && boardPieces[i + 4][j] == player)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean checkForWinDiagonalDown(int player) {
        for (int i = 0; i < boardPieces.length; i++) {
            for (int j = 0; j < boardPieces[i].length; j++) {
                if (i + 4 < boardPieces.length && j + 4 < boardPieces[i].length) {
                    if (boardPieces[i][j] == player && boardPieces[i + 1][j + 1] == player && boardPieces[i + 2][j + 2] == player && boardPieces[i + 3][j + 3] == player && boardPieces[i + 4][j + 4] == player)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean checkForWinDiagonalUp(int player) {
        for (int i = 0; i < boardPieces.length; i++) {
            for (int j = 0; j < boardPieces[i].length; j++) {
                if (i - 4 >= 0 && j + 4 < boardPieces[i].length) {
                    if (boardPieces[i][j] == player && boardPieces[i - 1][j + 1] == player && boardPieces[i - 2][j + 2] == player && boardPieces[i - 3][j + 3] == player && boardPieces[i - 4][j + 4] == player)
                        return true;
                }
            }
        }
        return false;
    }

}
