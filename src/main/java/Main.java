import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Start the server in a separate thread
        Thread serverThread = new Thread(new Server());
        serverThread.start();

        // Handle user input in the main thread
        Scanner scanner = new Scanner(System.in);
        boolean isFirst = true;
        Board board = new Board();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                // Stop the server and exit the program
                serverThread.interrupt();
                break;
            }

            if (isFirst) {
                try {
                    int size = Integer.parseInt(input);
                    if (size < 4 || size > 20) {
                        System.out.print("Please input between 5 ~ 20: ");
                    } else {
                        board = new Board(size);
                        isFirst = false;

                        board.print();
                        board.whoIsNext();
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid number! Please try again: ");
                }
            } else {
                board.nextMove(input);
                board.print();
                board.whoIsNext();
            }


        }

    }

    static class Server implements Runnable {
        @Override
        public void run() {
            // Your server logic goes here
            System.out.println("Server started...");

            try {
                // Simulate server activity
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle interruption and perform cleanup
                System.out.println("Server stopped.");
                return;
            }

            // Continue with server logic
            System.out.print("Board size: ");
        }
    }
}
