package pages.config;

public class Credentials {
    private static final String USER_NAME = "standard_user",
            USER_PASSWORD = "secret_sauce",
            FIRST_NAME = "Vladik",
            LAST_NAME = "Shpik",
            POSTAL_CODE = "66733";

    public static String getUsername() {
        return USER_NAME;
    }

    public static String getPassword() {
        return USER_PASSWORD;
    }

    public static String getFirstName() {
        return FIRST_NAME;

    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static String getPostalCode() {
        return POSTAL_CODE;
    }
}

