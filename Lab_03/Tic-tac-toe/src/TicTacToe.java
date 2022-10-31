import java.util.Scanner;

public class TicTacToe {

    private final String[][] board;
    static int ROWS = 3;
    static int COLUMNS = 3;
    static String player1 = "x";
    static String player2 = "o";

    public TicTacToe() {
        board = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = " ";
    }

    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            r.append("|");
            for (int j = 0; j < COLUMNS; j++)
                r.append(board[i][j]);
            r.append("|\n");
        }
        return r.toString();
    }

    public void set(int i, int j, String player) {
        if (board[i][j].equals(" "))
            board[i][j] = player;
    }

    public String getWinner() {
        int player1Streak = 0;
        int player2Streak = 0;
        int i, j;
        for (i = 0; i < ROWS; i++) {
            for (j = 0; j < COLUMNS; j++) {
                if (player1.equals(board[i][j])) {
                    player1Streak++;
                    if (player1Streak == 3) return player1;
                }
                else {
                    if (player2.equals(board[i][j]))
                        player2Streak++;
                }
                if(player2Streak == 3) return player2;
                }
            }
        player1Streak = 0;
        player2Streak = 0;

        for(i = 0; i<COLUMNS;i++)
        {
            for(j = 0; j<ROWS;j++)
            {
                if(player1.equals(board[j][i])) {
                    player1Streak++;
                    if (player1Streak == 3) return player1;
                }
                else {
                    if (player2.equals(board[j][i])) {
                        player2Streak++;
                        if (player2Streak == 3) return player2;
                    }
                }

            }
        }

        player1Streak = 0;
        player2Streak = 0;

        for(i = 0; i < ROWS;i++)
        {
            if(player1.equals(board[i][i])){
                player1Streak++;
                if(player1Streak == 3) return player1;
            }
            else
            {
                if(player2.equals(board[i][i]))
                    player2Streak++;
                if(player2Streak == 3) return player2;
            }
        }

        player1Streak = 0;
        player2Streak = 0;
        j = 0;
        for(i = 2; i >= 0; i--)
        {
            if(player1.equals(board[i][j])){
                player1Streak++;
                if(player1Streak == 3) return player1;
            }
            else
            {
                if(player2.equals(board[i][i]))
                    player2Streak++;
                if(player2Streak == 3) return player2;
            }
            j++;
        }
        return "no winner";
    }

    public static void main(String[] args) {
        String player = player1;
        TicTacToe game = new TicTacToe();
        Scanner in = new Scanner(System.in);
        int row, column;
        System.out.println(game);

        do {

            if (game.getWinner().equals(player1) || game.getWinner().equals(player2)) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci riga per " + player + " (-1 per uscire):");
            row = in.nextInt();

            if (row == -1) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci colonna per " + player + ":");
            column = in.nextInt();

            if (row >= ROWS || column >= COLUMNS) {
                System.out.println("Combinazione non valida");
            } else {
                game.set(row,column,player);

                System.out.println(game);

                if(player.equals(player1))
                    player = player2;
                else
                    player = player1;
            }



        } while (row < ROWS && column < COLUMNS);
    }

}