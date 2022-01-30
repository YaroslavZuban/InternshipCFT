package Jaroslav.Zuban;

import com.beust.jcommander.JCommander;

public class Main {
    public static void main(String[] args) {
        ConsoleReading consoleReading=new ConsoleReading();
        JCommander.newBuilder()
                .addObject(consoleReading)
                .build()
                .parse(args);
        consoleReading.readingParameters();
    }
}
