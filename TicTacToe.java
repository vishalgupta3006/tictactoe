import java.util.*;
public class TicTacToe {

    public static void displayBoard(char[][] board){
        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] +" ");
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }

    public static void displayWin(char player){
        System.out.println("---------------------------------");
        System.out.println("congratulations player "+player+", you win");
        System.out.println("---------------------------------");
    }

    public static void displayDraw(){
        System.out.println("---------------------------------");
        System.out.println("--------Match has Drawn----------");
        System.out.println("---------------------------------");
    }

    public static void isWin(char[][] board, boolean[] isAvail){
        int left=0;
        for (int i = 0; i < 3; i++) {
              if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
                  displayWin(board[i][1]);
                isAvail[0]=false;
              }
              if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]){
              displayWin(board[1][i]);
                isAvail[0]=false;
              }
        }

        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
            displayWin(board[1][1]);
            isAvail[0]=false;
          }
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
            displayWin(board[1][1]);
            isAvail[0]=false;
        }
        for(int i = 1;i<10;i++){
            if(isAvail[i]){
                left++;
            }
        }
        if(left==0&&isAvail[0]){
            displayDraw();
            isAvail[0]=false;
        }
    }

    public static void changeBoard(char[][] board,int loc , char player , boolean[] isAvail){
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                if (count == loc) {
                    board[i][j] = player;
                }
            }
        }

        displayBoard(board);
        isAvail[loc]=false;
    }
    public static void main(String args[]) {
        char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
        Scanner sc = new Scanner(System.in);
        int loc;
        boolean flag=true;
        boolean[] isAvail =new boolean[10] ;
        char player='X';

        for(int i =0 ;i<10;i++){
            isAvail[i]=true;
        }

        displayBoard(board);
        while (isAvail[0]) {
            if(flag){
                System.out.print("Player X, choose a number to place your piece? ");
                loc = sc.nextInt();
                if(loc>9||loc<1){
                   System.out.println("Error! Invalid Number.");
                   continue;
                }
                if(isAvail[loc]){
                player='X';
                changeBoard(board, loc, player, isAvail);
                isWin(board, isAvail);
            flag=false;
                }
                else{
                    System.out.println("Error! position already taken.");

                }
            }
            else{
                System.out.print("Player O, choose a number to place your piece? ");
                loc = sc.nextInt();
                if(loc>9||loc<1){
                    System.out.println("Error! Invalid Number.");
                    continue;
                 }
                 if(isAvail[loc]){
                player='O';
                changeBoard(board, loc, player, isAvail);
                isWin(board, isAvail);
            flag=true;
                 }
                 else{
                    System.out.println("Error! Position already Taken.");

                 }
            }
        }
    }
}