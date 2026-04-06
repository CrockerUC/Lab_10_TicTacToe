import java.util.Scanner;

public class Main
{
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final String[][] board = new String[ROWS][COLUMNS];

    /**
     * Main method for the Tic-Tac-Toe game. The game is played between two players, X and O, on a 3x3 grid.
     * Players take turns entering their moves, and the game ends when a player wins or the board is full.
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean playAgain;

        do
        {
            clearBoard();
            String player = "X";
            int moveCount = 0;
            boolean gameOver = false;

            while(!gameOver)
            {
                display();

                int row;
                int col;

                do
                {
                    row = SafeInput.getRangedInt(in,player + " enter row (1-3)", 1, 3)-1;
                    col = SafeInput.getRangedInt(in,player + " enter column (1-3)", 1, 3)-1;
                } while(!isValidMove(row, col));

                board[row][col] = player;
                moveCount++;

                if(moveCount >= 5) {
                    if (isWin(player)) {
                        display();
                        System.out.println(player + " wins!");
                        gameOver = true;
                    } else if (isTie()) {
                        display();
                        System.out.println("It's a tie!");
                        gameOver = true;
                    }
                }
                if(!gameOver)
                {
                    if(player.equals("X")) player = "O";
                    else player = "X";
                }
            }

            playAgain = SafeInput.getYNConfirm(in, "Play again?");

        }while(playAgain);

        System.out.println("Thanks for playing!");
        in.close();
    }

    /**
     * Clears the game board by setting all cells to an empty space.
     */
    private static void clearBoard()
    {
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLUMNS; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    /**
     * Displays the current state of the game board.
     */
    private static void display()
    {
        System.out.println();
        for (int row = 0; row < ROWS; row++)
        {
            System.out.print(" ");
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(board[row][col]);
                if (col < COLUMNS - 1) System.out.print(" | ");
            }
            System.out.println();
            if(row < ROWS - 1) System.out.println("---+---+---");
        }
        System.out.println();
    }

    /**
     * Checks if a given move is valid by verifying if the specified cell is empty.
     * @param row the row index of the move
     * @param col the column index of the move
     * @return true if the move is valid, false otherwise
     */
    private static boolean isValidMove(int row, int col)
    {
        if(board[row][col].equals(" ")) return true;
        System.out.println("That space is already taken!");
        return false;
    }

    /**
     * Checks if the current player has won the game by checking rows, columns, and diagonals.
     * @param player the current player's symbol (X or O)
     * @return true if the player has won, false otherwise
     */
    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    /**
     * Checks if the current player has won by forming a row of their symbol.
     * @param player the current player's symbol (X or O)
     * @return true if the player has won with a row, false otherwise
     */
    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROWS; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) return true;
        }
        return false;
    }

    /**
     * Checks if the current player has won by forming a column of their symbol.
     * @param player the current player's symbol (X or O)
     * @return true if the player has won with a column, false otherwise
     */
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COLUMNS; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) return true;
        }
        return false;
    }

    /**
     * Checks if the current player has won by forming a diagonal of their symbol.
     * @param player the current player's symbol (X or O)
     * @return true if the player has won with a diagonal, false otherwise
     */
    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    /**
     * Checks if the game has ended in a tie (no more empty spaces on the board).
     * @return true if the game is a tie, false otherwise
     */
    private static boolean isTie()
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLUMNS; col++)
            {
                if(board[row][col].equals(" ")) return false;
            }
        }
        return true;
    }
}
