package net.ukr.k_lite.task1.instruments.wind;

public final class WindFactory {

    private WindFactory() {
    }

    public static Wind createAccordion() {
        return new Accordion();
    }

    public static Wind createBagpipe() {
        return new Bagpipe();
    }

    public static Wind createDuduk() {
        return new Duduk();
    }
}
