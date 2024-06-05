package logging;

import utils.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

import static java.io.File.separator;

public class CVLogging {
    static Logger logger;
    public static final String LOG_FILE = "CustomerVerticalUITestsuite.log";
    public static Logger getLogger() {
        if (logger == null) {
            try {
                logBackUp();
                logger = Logger.getLogger(CVLogging.class.getName());
                LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
                logger.setLevel(Level.INFO);
                logger.addHandler(new ConsoleHandler());
                //FileHandler file name with max size and number of log files limit
                String logDir = "src" + separator + "test" + separator + "log";
                FileUtil.createDirectoryInPath(logDir);
                Handler fileHandler = new FileHandler(logDir + separator + LOG_FILE, 2000000, 1);
                fileHandler.setFormatter(new LogFormatter());
                //setting custom filter for FileHandler
                fileHandler.setFilter(new LogFilter());
                logger.addHandler(fileHandler);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return logger;
    }

    private static void logBackUp() {

        //FileHandler file name with max size and number of log files limit
        String testDir = "src" + separator + "test" ;
        String archiveDir = testDir + separator + "Archive" ;
        String archiveLogDir = archiveDir + separator + "log";
        String logDir = testDir + separator + "log";
        String lastLogBackupDir = archiveLogDir + separator + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_SSS"));

        FileUtil.createDirectoryInPath(lastLogBackupDir);
        FileUtil.createDirectoryInPath(logDir);
        FileUtil.copyFilesTo(logDir, lastLogBackupDir);
        FileUtil.deleteDirectoryContent(new File(logDir));
    }
}