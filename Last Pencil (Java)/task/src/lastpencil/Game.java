package lastpencil;

public class Game {
    static GameInput input;
    private int pencilCount;
    static String firstPlayer;
    static String secondPlayer;

    static Player player1;

    static Player player2;

    static String nextPlayer;

    public Game(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
        input = new GameInput(this);
    }

    public int getPencilCount() {
        return pencilCount;
    }

    public void prepare() {
        System.out.println("How many pencils would you like to use:");
        pencilCount = input.askPencilCount("");
        player1.setName("John");
        nextPlayer = input.askFirstGoer();
        player2.setName("Jack");
    }
    public void start() {

        while(pencilCount > 0) {
            playTurn();
            nextPlayer = switchPlayer();
            if (pencilCount == 0) {
                return;
            }
        }
    }

    public void drawPencils() {
        for (int i = 0; i < pencilCount; ++i) {
            System.out.print("|");
        }
        System.out.println();
    }

    public void playTurn() {
        drawPencils();
        System.out.println(nextPlayer + "'s turn!");

        if (nextPlayer.equals(player1.getName())) {
            pencilCount -= input.askPencilCount("player");
        } else if (isLosingPosition()) {
            if (this.getPencilCount() == 1) {
                System.out.println(1);
                pencilCount -= 1;
            } else {
                int pencilsTaken = (int) (Math.random() * 3 + 1);
                System.out.println(pencilsTaken);
                pencilCount -= pencilsTaken;
            }
        } else {
            int rest = pencilCount % 4;

            switch(rest) {
                case 0:
                    System.out.println(3);
                    pencilCount -= 3;
                    break;
                case 2:
                    System.out.println(1);
                    pencilCount -= 1;
                    break;
                case 3:
                    System.out.println(2);
                    pencilCount -= 2;
                    break;
            }
        }
    }

    public String switchPlayer() {
        return nextPlayer.equals(player1.getName()) ? player2.getName() : player1.getName();
    }

    public void winnerMsg() {
        System.out.println(nextPlayer + " won!");
    }

    public boolean isLosingPosition() {
        return this.getPencilCount() % 4 == 1;
    }
}
