public class Board {

    private final int size;
    private int[][] board;

    private int currentPlayer = 1;

    public Board() {
        this.size = 5;
    }

    public Board(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    public void print() {
        System.out.println("===================================================");
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                switch (board[i][j]) {
                    case 0:
                        System.out.print("-");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case -1:
                        System.out.print("O");
                        break;
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    public boolean nextMove(String move) {
        String[] moveArr = move.split(",");
        if (moveArr.length == 2) {
            try {
                int x = Integer.parseInt(moveArr[0]);
                int y = Integer.parseInt(moveArr[1]);
                if (board[x - 1][y - 1] == 0) {
                    board[x - 1][y - 1] = currentPlayer;
                    currentPlayer *= -1;
                } else {
                    System.out.println("This spot already taken! Please try other empty spot!");
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format! Please input 'number,number' => eg. '2,3'");
                return false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Move number is over or under the limit! Please input number between 1 ~ " + size);
                return false;
            }
            return true;
        } else {
            System.out.println("Invalid format! Please input 'number,number' => eg. '2,3'");
            return false;
        }
    }

    public void whoIsNext() {
        switch (currentPlayer) {
            case 1:
                System.out.println("");
                System.out.println("What is your next move 'Player X'?");
                System.out.println("Acceptable value: eg. '1,1' or  '2,3'");
                System.out.print("Your move is : ");
                break;
            case -1:
                System.out.println("");
                System.out.println("What is your next move 'Player O'?");
                System.out.println("Acceptable value: eg. '1,1' or  '2,3'");
                System.out.print("Your move is : ");
                break;
        }
    }
}
