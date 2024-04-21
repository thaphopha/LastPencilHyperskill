package lastpencil;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameInput {
    Game game;
    private final Scanner scanner = new Scanner(System.in);

    public GameInput(Game g) {
        this.game = g;
    }
    public int askPencilCount(String _for) {
        String count = "";
        boolean isValid = false;

        while(!isValid) {

            count = scanner.nextLine();

            if (_for.equals("player")) {
                if (!isNumeric(count)) {
                    System.out.println("Possible values: '1', '2' or '3'");
                    continue;
                }

                if (!isPossibleValue(count)) {
                    System.out.println("Possible values: '1', '2' or '3'");
                    continue;
                }

                if (Integer.parseInt(count) > game.getPencilCount()) {
                    System.out.println("Too many pencils were taken");
                    continue;
                }
            } else {
                if (!isNumeric(count)) {
                    System.out.println("The number of pencils should be numeric");
                    continue;
                }
                if (!isGreaterZero(count)) {
                    System.out.println("The number of pencils should be positive");
                    continue;
                }
            }

            isValid = true;
        }

        return Integer.parseInt(count);
    }

    public String askFirstGoer() {
        System.out.println("Who will be the first (John, Jack):");
        String patternString = "^(John|Jack)$";
        Pattern pattern = Pattern.compile(patternString);
        String name = "";
        boolean isValid = false;

        while(!isValid) {
            name = scanner.nextLine();

            Matcher matcher = pattern.matcher(name);
            if (!matcher.matches()) {
                System.out.println("Choose between 'John' and 'Jack'");
                continue;
            }
            isValid = true;
        }

        return name;
    }

    public boolean isNumeric(String count) {
        String patternString = "^-?\\d+$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(count);

        return matcher.matches();
    }

    public boolean isGreaterZero(String count) {
        return Integer.parseInt(count) > 0;
    }

    public boolean isPossibleValue(String count) {
        int value = Integer.parseInt(count);

        return (value > 0 && value < 4);
    }

    public boolean tookTooMany(String count) {
        int value = Integer.parseInt(count);
        return value <= game.getPencilCount();
    }
}



