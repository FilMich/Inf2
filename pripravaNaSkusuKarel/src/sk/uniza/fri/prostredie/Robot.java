package sk.uniza.fri.prostredie;

/**
 * 24. 5. 2021 - 13:29
 *
 * @author Filip
 */
public class Robot {
    private int x;
    private int y;
    private String otoceny;

    public Robot() {
        this.x = 0;
        this.y = 9;
        this.otoceny = ">";
    }

    public void vlavo() {
        switch (this.otoceny) {
            case ">":
                this.otoceny = "A";
                break;
            case "A":
                this.otoceny = "<";
                break;
            case "<":
                this.otoceny = "V";
                break;
            case "V":
                this.otoceny = ">";
                break;
        }
    }

    public void vpravo() {
        switch (this.otoceny) {
            case ">":
                this.otoceny = "V";
                break;
            case "A":
                this.otoceny = ">";
                break;
            case "<":
                this.otoceny = "A";
                break;
            case "V":
                this.otoceny = "<";
                break;
        }
    }

    public void krok() {
        switch (this.otoceny) {
            case ">":
                this.x += 1;
                break;
            case "A":
                this.y -= 1;
                break;
            case "<":
                this.x -= 1;
                break;
            case "V":
                this.y += 1;
                break;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        String retazec = this.otoceny;
        return retazec;
    }
}
