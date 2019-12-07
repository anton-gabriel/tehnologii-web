package utils.enums;

import java.util.stream.Stream;

/**
 * The enum Card color.
 */
public enum CardColor {
    /**
     * Black card color.
     */
    BLACK,
    /**
     * Red card color.
     */
    RED;

    /**
     * Stream stream.
     *
     * @return the stream
     */
    public static Stream<CardColor> stream() {
        return Stream.of(CardColor.values());
    }
}
