package restaurant.pizza.validation;

import java.util.regex.Pattern;

public class Validation {
    public static boolean isValidProductName(String productName) {
        return productName != null && !productName.isEmpty();
    }

    public static boolean isValidPrice(String priceStr) {
        try {
            double price = Double.parseDouble(priceStr);
            return price >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
