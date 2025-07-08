import java.util.*;
class TicTacToe{
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false ;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player "+ player+" enter:");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {

                board[row][col] = player ;
                gameOver = haveWon(board,player);

                if(gameOver){
                    System.out.println("Player " + player + " has won!!! ");
                }else{
                    if (player == 'X') { player = 'O';}
                    else{ player ='X';}
                }

            }else{
                System.out.println("Invalid move . Try again !");
            }
        }
    }

    public static boolean haveWon(char[][] boards , char player ) {
        //check the rows
        for (int row = 0; row < boards.length; row++) { if (boards[row][0] == player && boards[row][1] == player && boards[row][2] == player ) { return true ; } }
        //check for columnes
        for (int col = 0; col < boards.length; col++) { if (boards[0][col] == player && boards[1][col] == player && boards[2][col] == player ) { return true ; } }
        // check for diagonals
        if (boards[0][0]==player && boards[1][1] == player && boards[2][2] == player  ) { return true ; }
        if (boards[0][2]==player && boards[1][1] == player && boards[2][0] == player  ) { return true ; }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length-1; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}