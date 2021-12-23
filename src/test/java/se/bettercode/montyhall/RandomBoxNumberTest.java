package se.bettercode.montyhall;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class RandomBoxNumberTest {

    @Test
    public void generatesNumberBetween1And3() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            final int randomBoxNumber = RandomBoxNumber.generateRandomBoxNumber();
            assertTrue(randomBoxNumber > 0);
            assertTrue(randomBoxNumber < 4);
        });
    }

}
