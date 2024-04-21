package lastpencil;

public class Main {
    static Game game = null;

    public static void main(String[] args) {
        Player p1 = new Player("John");
        Player p2 = new Player("Jack");
        game = new Game(p1, p2);
        game.prepare();
        game.start();
        game.winnerMsg();
    }
}
