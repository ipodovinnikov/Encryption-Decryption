class ConsoleWriter implements Printer, Notifier {
    @Override
    public void greeting() {
        Printer.super.greeting();
    }
}

interface Notifier {
    default void greeting() {
        System.out.println("Notifier is ready");
    }
}

interface Printer {
    default void greeting() {
        System.out.println("Printer is ready");
    }
}

