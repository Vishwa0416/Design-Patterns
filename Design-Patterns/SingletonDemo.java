class ConfigurationManager {

    // Private static instance of the same class, this is the only instance
    private static ConfigurationManager instance;

    // Private constructor to prevent instantiation
    private ConfigurationManager() {
        // Load configuration settings from a file
        System.out.println("Loading configuration settings...");
    }

    // Public method to provide access to the instance
    public static ConfigurationManager getInstance() {
        if (instance == null) {// Ensure thread safety
            instance = new ConfigurationManager();
        }
        return instance;
    }

    // Example method to get a configuration value
    public String getConfigValue(String key) {
        // Normally, you'd fetch this from loaded configurations
        return "SomeValue";
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        ConfigurationManager configManager1 = ConfigurationManager.getInstance();
        ConfigurationManager configManager2 = ConfigurationManager.getInstance();

        System.out.println(configManager1.getConfigValue("exampleKey"));
        System.out.println(configManager1 == configManager2); // Should print true
    }
}