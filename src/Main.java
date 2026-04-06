import java.util.Scanner;

public class Main
{
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static String board [][] = new String[ROWS][COLUMNS];

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







            playAgain = SafeInput.getYNConfirm(in,"Play again? (Y/N): ");
        }while(playAgain);
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

    }

    private static void isValidMove(int row, int col)
    {

    }

    private static boolean isRowWin(String player)
    {
        return false;
    }

    private static boolean isColWin(String player)
    {
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return false;
    }

    private static boolean isTie()
    {
        return false;
    }
}
