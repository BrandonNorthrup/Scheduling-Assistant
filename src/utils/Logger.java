/*
Brandon Northrup
Student ID #001177877
Software II - Java - C195
*/

package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;

public class Logger {
    private static final String FILENAME = "log.txt";
    
    public Logger() {}
    
    public static void log (String username, boolean success) {
        try (FileWriter fw = new FileWriter(FILENAME, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)) {
            pw.println(ZonedDateTime.now() + " " + username + (success ? " successfully logged in." : " failed to log in."));
        } 
        catch (IOException e) {
            System.out.println("Log Error: " + e.getMessage());
        }
    }
}