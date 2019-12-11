package utils;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class GameLoggerTest {

    @Test
    void getInstance() {
        assert GameLogger.getInstance() != null;
    }

    @Test
    void log() {
    }
}