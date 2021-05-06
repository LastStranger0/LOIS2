import config.Config;
import parser.Formula;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public  static void main(String[] args) throws IOException {
        String expression = "";
        StringBuilder builder = new StringBuilder(expression);
        try (FileInputStream fin = new FileInputStream(Config.IN_FILE_PATH)) {
            while (fin.available() > 0) {
                int oneByte = fin.read();
                builder.append(((char) oneByte));
            }
            expression = builder.toString();
        } catch (FileNotFoundException ex) {
            System.out.println("File not find!!!");
        }

        System.out.println(expression);
        System.out.println();
        Formula formula = new Formula(expression);
        if (formula.isResult()) {
            formula.output();
            System.out.println(formula.getResultParser());
            System.out.println("\n");
        }
    }
}
