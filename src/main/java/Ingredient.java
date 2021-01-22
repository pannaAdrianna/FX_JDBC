public class Ingredient {
    private int id;
    private String name;
    private double pricePLN;

    public Ingredient(int id, String name) {
        this.id = id;
        this.name = name;
        this.pricePLN=2.00;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePLN() {
        return pricePLN;
    }

    public void setPricePLN(double pricePLN) {
        this.pricePLN = pricePLN;
    }
}
