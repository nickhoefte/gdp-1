public class TurnCounter {
    private static int counter;

    public static void increment() {
        TurnCounter.counter++;
    }

    public static int getCounter() {
        return TurnCounter.counter;
    }
}
