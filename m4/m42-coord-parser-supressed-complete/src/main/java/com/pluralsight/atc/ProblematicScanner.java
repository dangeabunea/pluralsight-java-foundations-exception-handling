package com.pluralsight.atc;

import java.io.IOException;
import java.util.Scanner;

/**
 * A wrapper around Scanner that simulates problems during resource cleanup.
 * This class demonstrates what happens when close() throws an exception.
 */
public class ProblematicScanner implements AutoCloseable {
    private final Scanner scanner;
    private final boolean shouldFailOnClose;

    public ProblematicScanner(Scanner scanner, boolean shouldFailOnClose) {
        this.scanner = scanner;
        this.shouldFailOnClose = shouldFailOnClose;
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void close() throws IOException {
        // Simulate a problem during close (e.g., flushing buffers, network timeout, etc.)
        if (shouldFailOnClose) {
            throw new IOException("Simulated error while closing scanner - buffer flush failed");
        }
        scanner.close();
    }
}
