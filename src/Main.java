import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner can be used for reading input from keyboard
        // or from a file

        // Checked exception - compiler forces us to handle it
        try {
            NumberFormat number = NumberFormat.getInstance();
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            double price, min = Double.MAX_VALUE, max = Double.MIN_VALUE, average, sum = 0;
            int count = 0;
            Scanner file = new Scanner(new File("bitcoin_prices_full.txt"));
            // Skip the heading!
            file.nextLine();

            // Check to make sure we have a double to read
            while (file.hasNextDouble()) {
                // Read the double into the price
                price = file.nextDouble();
                count++;
                sum += price;
                // Check to see if new price is a min or max
                if (price > max) { max = price; }
                if (price < min) { min = price; }
            }

            System.out.println("Number of price quotes: " + number.format(count));
            System.out.println("Average Price: " + currency.format(sum/count));
            System.out.println("Lowest Price: " + currency.format(min));
            System.out.println("Highest Price: " + currency.format(max));

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}