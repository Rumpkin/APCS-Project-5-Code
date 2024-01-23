import java.util.Locale;
import java.util.Scanner;
public class Main {
    static final int BOARDX = 7;
    static final int BOARDY = 15;
    public static void main(String[] args) {
        System.out.println("Welcome to MEGA Connect 5!");
        System.out.println("You may choose to place one 3x3 MegaPiece");
        System.out.println();
        Board board = new Board(BOARDX, BOARDY);
        Scanner input = new Scanner(System.in); //creates scanner obj
        int player = 1;
        int[] remainingMegaPiece = new int[2];
        remainingMegaPiece[0] = 1;
        remainingMegaPiece[1] = 1;

        while (true) {
            board.displayAll();
            System.out.println("Player: " + player + ":");

            Piece piece = null;
            boolean megaPiece = false;

            // Stuff should go here, probably
            if (remainingMegaPiece[player - 1] != 0){
                System.out.println("Use MegaPiece? (Y/N)?");

                String answer = input.nextLine();
                while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                    System.out.println("Please enter a valid answer.");
                    answer = input.nextLine();
                }

                if (answer.equalsIgnoreCase("y")) {
                    megaPiece = true;
                    remainingMegaPiece[player - 1] = 0;
                }
                else if (answer.equalsIgnoreCase("n"))
                    megaPiece = false;
            }

            if (megaPiece) {
                System.out.println("Enter the column you would like to place your Piece at.");
                int dropLocation = input.nextInt() - 1;
                if (dropLocation <= 1 && dropLocation >= board.getBoardPieces().length - 2)
                    break;

                piece = new MegaPiece(dropLocation, player, board);
                System.out.println(piece.getCol());
                System.out.println(piece.getRow());
                board.placePiece(piece);
            }
            else {
                System.out.println("Enter the column you would like to place your Piece at.");
                int dropLocation = input.nextInt() - 1;
                if (dropLocation <= 0 && dropLocation >= board.getBoardPieces().length - 1)
                    break;

                piece = new Piece(dropLocation, player, board);
                board.placePiece(piece);
            }

            if (board.checkForWin(player)) {
                System.out.println("player: " + player + " has won!");
                board.displayAll();
                break;
            }
            player = player % 2 + 1;
        }



    }
}
