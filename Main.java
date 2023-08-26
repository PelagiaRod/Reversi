import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Reversi Game!\n");
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose a number between 1 and 6 to set the depth of the algorithm: \n");
        int depth = Integer.parseInt(scan.next());
        if (depth < 1 || depth > 6)
        {
            System.out.print("Invalid number. Choose another between 1 and 6: \n");
            depth = Integer.parseInt(scan.next());
        }

        System.out.print("Do you want to play first?(y/n):");
        int playerLetter = 1;       //first player is always X
        if (scan.next().trim().equals("n"))
        {
            playerLetter = -1;
        }

        Board board = new Board();
        Player pcPlayer = new Player(depth, -playerLetter);

        System.out.println();
        board.print();
        System.out.println();
        int playedLast = -1;

        while(!board.isTerminal())
        {
            //pc move
            if (playedLast==playerLetter)
            {
                if (board.hasMoves(-playerLetter))
                {
                    Move move = pcPlayer.MiniMax(board);
                    board.makeMove(-playerLetter,move);
                    System.out.println("I played " + move +"\n");
                    board.print();
                    playedLast = board.getLastLetterPlayer();
                }
                else
                    playedLast = -playedLast;
            }
            //player move
            if (playedLast == -playerLetter)
            {
                if (board.hasMoves(playerLetter))
                {
                    System.out.print("\nIt's your turn! --entry format: row,col--");
                    String input = scan.next().trim();

                    while( input.length()!=3 || !input.contains(","))
                    {
                        System.out.print(" Please check your input format and try again: ");
                        input = scan.next().trim();
                        int x = Integer.parseInt(input.substring(0,1));
                        int y = Integer.parseInt(input.substring(2));

                        while (board.isValidMove(playerLetter, x, y).equals("NOT_VALID"))
                        {
                            System.out.println("Your move is not valid!\nPlease try again: ");
                            input = scan.next().trim();
                            x = Integer.parseInt(input.substring(0,1));
                            y = Integer.parseInt(input.substring(2));
                        }
                    }

                    int x = Integer.parseInt(input.substring(0,1));
                    int y = Integer.parseInt(input.substring(2));

                    board.makeMove(playerLetter, x, y);
                    System.out.println();
                    board.print();
                    System.out.println("\n");
                    playedLast = board.getLastLetterPlayer();
                }
                else
                    playedLast = -playedLast;
            }
        }
        scan.close();

        System.out.println("\nThe game has finished." + board.theWinner());

    }

}
