public class Main {
    public static void main(String[] args) {
        // Accessing Singleton instance
        GameSettings settings = GameSettings.getInstance();

        // Set values
        settings.setVolume(75);
        settings.setResolution("2560x1440");

        // Access from anywhere
        GameSettings anotherRef = GameSettings.getInstance();
        System.out.println("Volume from anotherRef: " + anotherRef.getVolume()); // will still be 75
        System.out.println("Resolution from anotherRef: " + anotherRef.getResolution()); // will be 2560x1440

        // Singleton guarantees that both `settings` and `anotherRef` refer to the same object
    }
}
