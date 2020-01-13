package fr.umontpellier.iut.conquest;

import fr.umontpellier.iut.conquest.strategies.Minmax;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinMaxPerfTest {

    @Test
    void run_time_for_2_AIs_of_level_4_on_board_of_size_5_should_be_less_than_30s() {

        Minmax ai1 = new Minmax(4);
        Minmax ai2 = new Minmax(4);
        Game game = new Game(5, ai1, null, ai2, null);

        long startTime = System.nanoTime();
        game.run(1);
        long endTime = System.nanoTime() - startTime;

        assertTrue(endTime < 30000000000.); //30 000 000 000 nano seconds = 30s
    }
}
