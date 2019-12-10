package utils.enums;

import org.junit.jupiter.api.Test;

/**
 * The type Card color test.
 */
class CardColorTest {

    /**
     * Stream test method.
     */
    @Test
    void stream() {
        assert CardColor.stream().filter(cardColor -> cardColor instanceof CardColor).toArray().length == CardColor.values().length;
    }
}