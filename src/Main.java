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

            while(!gameOver)
            {
                display();

                int row;
                int col;

                do
                {
                    row = SafeInput.getRangedInt(in,player + " enter row (1-3): ", 1, 3)-1;
                    col = SafeInput.getRangedInt(in,player + " enter column (1-3): ", 1, 3)-1;
                } while(!isValidMove(row, col));

                board[row][col] = player;
                moveCount++;

                if(moveCount >= 5) {
                    if (isWin(player)) {
                        display();
                        System.out.println(player + "wins!");
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

            playAgain = SafeInput.getYNConfirm(in, "Play again? (Y/N): ");

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

    }

    private static boolean isValidMove(int row, int col)
    {
        return false;
    }

    private static boolean isWin(String player)
    {
        return false;
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
