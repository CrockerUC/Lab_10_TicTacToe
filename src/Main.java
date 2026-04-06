import java.util.Scanner;

public class Main
{
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final String[][] board = new String[ROWS][COLUMNS];

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

    private static boolean isValidMove(int row, int col)
    {
        if(board[row][col].equals(" ")) return true;
        System.out.println("That space is already taken!");
        return false;
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROWS; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) return true;
        }
        return false;
    }

    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COLUMNS; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) return true;
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

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
