package NumeroRandom;

import java.util.Random;

public class NumeroRandom {
        public static int generarRandom() {
        Random random = new Random();
        int r = random.nextInt(array.length - 1);
        return r;
    }
}
