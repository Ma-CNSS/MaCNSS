package application.DAO;

import java.security.SecureRandom;
import org.mindrot.jbcrypt.BCrypt;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class UserDAO<T> {
    private static final SecureRandom random = new SecureRandom();
    public abstract Boolean login(T object);
    public abstract Boolean logout(T object);


        public static int generateRandomCode(int numDigits) {
            if (numDigits <= 0) {
                throw new IllegalArgumentException("Number of digits must be greater than 0");
            }
            int min = (int) Math.pow(10, numDigits - 1);
            int max = (int) Math.pow(10, numDigits) - 1;
            return min + random.nextInt(max - min + 1);
        }


        public static boolean isPhoneNumber(String input) {
            return input.matches("\\d{10}");
        }


        public static String hashPassword(String plainTextPassword) {
            String salt = BCrypt.gensalt();
            return BCrypt.hashpw(plainTextPassword, salt);
        }

        public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
            return BCrypt.checkpw(plainTextPassword, hashedPassword);
        }

        public static boolean isEmail(String input) {
            String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(input);
            return matcher.matches();
        }
}
