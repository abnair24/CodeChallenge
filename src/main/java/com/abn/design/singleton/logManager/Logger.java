package com.abn.design.singleton.logManager;


import java.util.logging.Level;

public interface Logger {

    void log(Level level, String message);

    void setLogFile(String filePath);

    String getLogFile();

    // Flush the log entries to the file
    void flush();

    // Close the logger and release any resources
    void close();
}
