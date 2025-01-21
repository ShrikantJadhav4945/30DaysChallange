import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids); // Sort the asteroids in ascending order
        long currentMass = mass; // Use long to avoid overflow

        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false; // Cannot destroy this asteroid
            }
            currentMass += asteroid; // Absorb the asteroid's mass
        }
        return true; // Successfully destroyed all asteroids
    }
}
