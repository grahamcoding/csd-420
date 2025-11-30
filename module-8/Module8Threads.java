/**
 * Daniel Graham
 * Module: 8 - Java Threads
 * 11/30/2025
 */
 
public class Module8Threads {

    public static void main(String[] args) {

        Thread lettersThread = new Thread(new LettersTask());
        Thread numbersThread = new Thread(new NumbersTask());
        Thread symbolsThread = new Thread(new SymbolsTask());

        // Start the threads
        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();

        // Test code using join()
        try {
            lettersThread.join();
            numbersThread.join();
            symbolsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nAll threads completed successfully.");
    }

    // Thread #1 — prints random letters
    static class LettersTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                char letter = (char) ('a' + (int) (Math.random() * 26));
                System.out.print(letter);
            }
        }
    }

    // Thread #2 — prints random digits
    static class NumbersTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                int num = (int) (Math.random() * 10);
                System.out.print(num);
            }
        }
    }

    // Thread #3 — prints random symbols
    static class SymbolsTask implements Runnable {
        private final char[] symbols = { '!', '@', '#', '$', '%', '&', '*' };

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                char symbol = symbols[(int)(Math.random() * symbols.length)];
                System.out.print(symbol);
            }
        }
    }
}