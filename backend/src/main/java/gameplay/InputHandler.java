package gameplay;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Scanner;
import javax.inject.Inject;

public class InputHandler {
    private final Scanner scanner;

    @Inject
    public InputHandler() {
        this.scanner = new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    }

    public char getLetter() {
        return this.getLetter((String)null);
    }

    public char getLetter(String message) {
        this.printMessage(message);
        String line = "";

        while(this.scanner.hasNextLine()) {
            line = this.scanner.nextLine();
            line = line.trim();
            if (!line.isEmpty() && line.length() <= 1 && line.matches("[a-zA-Z]")) {
                break;
            }

            System.out.println(String.format("Invalid letter: '%s'.", line));
            this.printMessage(message);
        }

        return line.charAt(0);
    }

    public int getInteger() {
        return this.getInteger((String)null);
    }

    public int getInteger(String message) {
        return this.getInteger(-2147483648, 2147483647, message);
    }

    public int getInteger(int min, int max) {
        return this.getInteger(min, max, (String)null);
    }

    public int getInteger(int min, int max, String message) {
        while(true) {
            this.printMessage(message);
            if (this.scanner.hasNextInt()) {
                int userInput = this.scanner.nextInt();
                this.consumeTrailingNewline();
                if (userInput >= min && userInput <= max) {
                    return userInput;
                }

                System.out.println(String.format("Number not between %d and %d.", min, max));
            } else {
                System.out.println(String.format("Invalid whole number: '%s'.", this.scanner.nextLine()));
            }
        }
    }

    public long getLong() {
        return this.getLong((String)null);
    }

    public long getLong(String message) {
        return this.getLong(-9223372036854775808L, 9223372036854775807L, message);
    }

    public long getLong(long min, long max) {
        return this.getLong(min, max, (String)null);
    }

    public long getLong(long min, long max, String message) {
        while(true) {
            this.printMessage(message);
            if (this.scanner.hasNextLong()) {
                long userInput = this.scanner.nextLong();
                this.consumeTrailingNewline();
                if (userInput >= min && userInput <= max) {
                    return userInput;
                }

                System.out.println(String.format("Number not between %d and %d (%d).", min, max, userInput));
            } else {
                System.out.println(String.format("Invalid whole number: '%s'.", this.scanner.nextLine()));
            }
        }
    }

    public double getDouble() {
        return this.getDouble((String)null);
    }

    public double getDouble(String message) {
        return this.getDouble(-1.0D / 0.0, 1.0D / 0.0, message);
    }

    public double getDouble(double min, double max) {
        return this.getDouble(min, max, (String)null);
    }

    public double getDouble(double min, double max, String message) {
        while(true) {
            this.printMessage(message);
            if (this.scanner.hasNextDouble()) {
                double userInput = this.scanner.nextDouble();
                this.consumeTrailingNewline();
                if (Double.compare(userInput, min) >= 0 && Double.compare(userInput, max) <= 0) {
                    return userInput;
                }

                System.out.println(String.format("Number not between %f and %f (%f).", min, max, userInput));
            } else {
                System.out.println(String.format("Invalid number: '%s'.", this.scanner.nextLine()));
            }
        }
    }

    public BigDecimal getBigDecimal() {
        return this.getBigDecimal((String)null);
    }

    public BigDecimal getBigDecimal(String message) {
        while(true) {
            this.printMessage(message);
            if (this.scanner.hasNextBigDecimal()) {
                BigDecimal nextBigDecimal = this.scanner.nextBigDecimal();
                this.consumeTrailingNewline();
                return nextBigDecimal;
            }

            System.out.println(String.format("Invalid number: '%s'.", this.scanner.nextLine()));
        }
    }

    public BigDecimal getBigDecimal(BigDecimal min, BigDecimal max) {
        return this.getBigDecimal(min, max, (String)null);
    }

    public BigDecimal getBigDecimal(BigDecimal min, BigDecimal max, String message) {
        while(true) {
            this.printMessage(message);
            if (this.scanner.hasNextBigDecimal()) {
                BigDecimal userInput = this.scanner.nextBigDecimal();
                this.consumeTrailingNewline();
                if (userInput.compareTo(min) >= 0 && userInput.compareTo(max) <= 0) {
                    return userInput;
                }

                System.out.println(String.format("Number not between %f and %f (%f).", min, max, userInput));
            } else {
                System.out.println(String.format("Invalid number: '%s'.", this.scanner.nextLine()));
            }
        }
    }

    public boolean getBoolean() {
        return this.getBoolean((String)null);
    }

    public boolean getBoolean(String message) {
        while(true) {
            this.printMessage(message);
            if (this.scanner.hasNextBoolean()) {
                boolean nextBoolean = this.scanner.nextBoolean();
                this.consumeTrailingNewline();
                return nextBoolean;
            }

            System.out.println(String.format("Invalid boolean: '%s'.", this.scanner.nextLine()));
        }
    }

    public String getString() {
        return this.getString((String)null);
    }

    public String getString(String message) {
        return this.getString((String)message, (String)null);
    }

    public String getString(String message, String inlinePrompt) {
        while(true) {
            this.printMessage(message);
            this.printInlinePrompt(inlinePrompt);
            if (this.scanner.hasNextLine()) {
                return this.scanner.nextLine();
            }

            System.out.println(String.format("Invalid entry: '%s'.", this.scanner.nextLine()));
        }
    }

    public String getString(Collection<String> possibleValues) {
        return this.getString(possibleValues, (String)null, (String)null);
    }

    public String getString(Collection<String> possibleValues, String message) {
        return this.getString(possibleValues, message, (String)null);
    }

    public String getString(Collection<String> possibleValues, String message, String inlinePrompt) {
        while(true) {
            this.printMessage(message);
            this.printInlinePrompt(inlinePrompt);
            if (this.scanner.hasNextLine()) {
                String line = this.scanner.nextLine();
                if (possibleValues.contains(line)) {
                    return line;
                }

                System.out.println(String.format("Answer not valid: '%s'.  Valid responses: %s.", line, possibleValues));
            } else {
                System.out.println(String.format("Invalid entry: '%s.'", this.scanner.nextLine()));
            }
        }
    }

    private void printMessage(String message) {
        if (message != null) {
            System.out.println(message);
        }

    }

    private void printInlinePrompt(String prompt) {
        if (prompt != null && !prompt.isEmpty()) {
            System.out.print(prompt);
        }

    }

    private void consumeTrailingNewline() {
        this.scanner.nextLine();
    }

}
