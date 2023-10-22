package restaurant.pizza.util;

import java.sql.Timestamp;
import java.util.Random;

public class RandomDataGenerator {

    private static final String[] PRODUCT_NAMES = {
            "Margherita Pizza", "Pepperoni Pizza", "Hawaiian Pizza",
            "Veggie Pizza", "Cheese Pizza", "BBQ Chicken Pizza"
    };

    private static final Random RANDOM = new Random();

    public static String getRandomProductName() {
        return PRODUCT_NAMES[RANDOM.nextInt(PRODUCT_NAMES.length)];
    }

    public static String getRandomDescription(String productName) {
        return "Delicious " + productName;
    }

    public static double getRandomPrice() {
        return 1 + RANDOM.nextDouble() * 99;
    }

    public static int getRandomCategoryId() {
        return RANDOM.nextInt(4) + 1;
    }

    public static int getRandomStock() {
        return RANDOM.nextInt(10) + 1;
    }

    public static byte[] getRandomImage() {
        return null;  // Assuming no image data for simplicity
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
