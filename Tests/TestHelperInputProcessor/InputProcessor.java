package TestHelperInputProcessor;

import java.util.Scanner;

public class InputProcessor {
    private final Scanner scanner;

    public InputProcessor(Scanner scanner) {
        this.scanner = scanner;
    }
    public String getUserInput() {
        return scanner.nextLine();
    }
}
