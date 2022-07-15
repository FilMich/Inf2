package sk.uniza.fri;

public enum Smer {
    RIGHT(1, 0),
    LEFT(-1, 0),
    UP(0, 1),
    DOWN(0, -1);

    private int x;
    private int y;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    Smer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
