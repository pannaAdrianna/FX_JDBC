public enum PizzaDiameter implements Labeled {
    d30("30"),
    d45("45"),
    d60("60");

    public final String diameter;

   private PizzaDiameter(String diameter) {
        this.diameter = "30";
    }

    @Override
    public String toString() {
        return this.diameter;
    }

    @Override
    public String label() {
        return diameter;
    }
}
