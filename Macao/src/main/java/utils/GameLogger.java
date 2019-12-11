package utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The type My logger.
 */
public class GameLogger {
    private Logger logger;
    private FileHandler file;
    private SimpleFormatter formatter;
    private File directory;

    static private GameLogger singleInstance = null;

    private GameLogger() throws IOException {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        directory = new File("D:\\Repos\\Logs.log");
        file = new FileHandler(directory.getAbsolutePath());
        formatter = new SimpleFormatter();
        file.setFormatter(formatter);
        logger.addHandler(file);
    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws IOException the io exception
     */
    static public GameLogger getInstance() throws IOException {
        if (singleInstance == null) {
            singleInstance = new GameLogger();
        }
        return singleInstance;
    }

    /**
     * Log.
     *
     * @param level   the level
     * @param message the message
     */
    public void log(Level level, String message) {
        logger.log(level, message);
    }
}