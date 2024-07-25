import com.hazelcast.core.*;
import com.hazelcast.map.IMap;

import java.util.Random;

public class HazelCastMain {
    public static void main(String[] args) {
        // Create Hazelcast Instance
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        // Create Hazelcast map using IMap
        IMap<Integer, Integer> map = hazelcastInstance.getMap("randomNumbers");

        // Creating random number
        Random random = new Random();

        // Put 20,000 random numbers and measure time
        long startTime = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            map.put(i, random.nextInt());
        }
        long endTime = System.nanoTime();
        System.out.println("Time to put 20.000 numbers: " + (endTime - startTime) / 1_000_000 + " ms");

        // 	Get 20,000 random numbers and measure time
        startTime = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            map.get(random.nextInt(20000));
        }
        endTime = System.nanoTime();
        System.out.println("Time to get 20.000 numbers: " + (endTime - startTime) / 1_000_000 + " ms");

        // Put 100,000 random numbers and measure time
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            map.put(i, random.nextInt());
        }
        endTime = System.nanoTime();
        System.out.println("Time to put 100.000 numbers: " + (endTime - startTime) / 1_000_000 + " ms");

        // Get 100,000 random numbers and measure time
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            map.get(random.nextInt(100000));
        }
        endTime = System.nanoTime();
        System.out.println("Time to get 100.000 numbers: " + (endTime - startTime) / 1_000_000 + " ms");

        // Close Hazelcast Instance
        hazelcastInstance.shutdown();
    }
}
