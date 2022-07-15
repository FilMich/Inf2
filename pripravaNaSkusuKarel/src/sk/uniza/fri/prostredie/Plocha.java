package sk.uniza.fri.prostredie;

/**
 * 24. 5. 2021 - 13:29
 *
 * @author Filip
 */
public class Plocha {
    private String[][] plocha;
    private Robot robot;

    public Plocha() {
        this.plocha = new String[10][10];
        this.robot = new Robot();
    }

    public Robot dajRobota() {
        return this.robot;
    }

    public void vypis() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x == dajRobota().getX() && y == dajRobota().getY()) {
                    System.out.print(dajRobota().toString());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public String toString() {
        String retazec = "";
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                retazec += ".";
            }
            retazec += "\n";
        }
        return retazec;
    }
}
