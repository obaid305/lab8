public class GameSettings {

    // Step 1: Private static instance (eager initialization or lazy)
    private static GameSettings instance;

    // Step 2: Global settings
    private int volume;
    private String resolution;

    // Step 3: Private constructor to prevent instantiation
    private GameSettings() {
        // Default values
        this.volume = 50; // default volume level
        this.resolution = "1920x1080"; // default resolution
    }

    // Step 4: Public static method to provide access to the instance (Lazy initialization)
    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    // Method to adjust volume
    public void setVolume(int level) {
        if (level >= 0 && level <= 100) {
            this.volume = level;
            System.out.println("Volume set to: " + this.volume);
        } else {
            System.out.println("Volume must be between 0 and 100.");
        }
    }

    // Method to adjust screen resolution
    public void setResolution(String resolution) {
        this.resolution = resolution;
        System.out.println("Resolution set to: " + this.resolution);
    }

    // Getter methods
    public int getVolume() {
        return this.volume;
    }

    public String getResolution() {
        return this.resolution;
    }
}
