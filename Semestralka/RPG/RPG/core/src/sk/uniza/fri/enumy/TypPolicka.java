package sk.uniza.fri.enumy;

public enum TypPolicka {
    HERO_1("hero2.png"),
    HERO_2("hero1.png"),
    HERO_3("hero3.png"),
    HERO_4("hero4.png"),
    TREE("tree.png"),
    ENEMY_ZOMBIE("enemy_zombie.png"),
    ENEMY_ROBOT("enemy_robot.png"),
    GREEN("green.png"),
    GREY("grey.png"),
    LIGHT_GREY("light_grey.png"),
    YELLOW("yellow.png"),
    HEALINGPOINT("healingPoint.png"),
    KLUC("kluc.png"),
    PORTAL("portal.png");
    private String fileName;

    TypPolicka(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
