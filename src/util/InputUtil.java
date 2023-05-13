package util;

import java.util.Scanner;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        String data = scanner.nextLine();
        return data;
    }
}
