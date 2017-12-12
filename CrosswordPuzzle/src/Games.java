import java.util.Scanner;

public class Games {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board forGame = new Board();
        System.out.println("Start Game? \n Type yes to begin.");
        String input = scan.nextLine();
        if(input.toLowerCase().equals("yes")) {
            while (!forGame.isGameOver()) {
                forGame.printBoard();
                forGame.printHints();
                System.out.println("Type across or down to choose input");
                input = scan.nextLine();
                if (input.toLowerCase().equals("across")) {
                    System.out.println("Type coordinates infront of hint to input your answer in form a,b");
                    input = scan.nextLine();
                    String[] useful = input.split(",");
                    int a = Integer.parseInt(useful[0]);
                    int b = Integer.parseInt(useful[1]);
                    System.out.println("Type in word for answer");
                    input = scan.nextLine();
                    forGame.inputAcross(a, b, input);
                } else if (input.toLowerCase().equals("down")) {
                    System.out.println("Type coordinates infront of hint to input your answer in the form a,b");
                    input = scan.nextLine();
                    String[] useful = input.split(",");
                    int a = Integer.parseInt(useful[0]);
                    int b = Integer.parseInt(useful[1]);
                    System.out.println("Type in word for answer");
                    input = scan.nextLine();
                    forGame.inputDown(a, b, input);
                } else {System.out.print("error");}
            }
        } else {
            System.out.println("Sorry that you didn't want to play");
        }
        System.out.println("GG. WP.");
        scan.close();
    }

}