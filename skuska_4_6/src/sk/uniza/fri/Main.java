package sk.uniza.fri;
/**
 * Created by IntelliJ IDEA.
 * User: Filip
 * Date: 7. 6. 2021
 * Time: 15:11
 */
public class Main {

    public static void main(String[] args) {
        boolean zaciatok = true;
        String x = "x";
        String o = "o";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i % 2 == 0) {
                    if (zaciatok && j == 0) {
                        System.out.print(o);
                        zaciatok = false;
                    } else {
                        if (!zaciatok && j == 9) {
                            System.out.print(o);
                            zaciatok = true;
                        } else {
                            System.out.print(x);
                        }
                    }
                } else {
                    System.out.print(o);
                }
            }
            System.out.println();
        }
    }
}
