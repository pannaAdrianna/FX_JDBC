import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private IntegerProperty id;
    private StringProperty name;
    private List<Ingredient> ingredients; // Ingredient zmnienic na IngredientName, zrobic klase Ingredient
    private DoubleProperty pricePLN;
    private List<Ingredient> extra_ingredients; // Domyślnie wyzerowane?
    private List<PizzaType> type;
    private Enum<PizzaDiameter> size;

    public Pizza() {
        id = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        ingredients = new ArrayList<Ingredient>();
        pricePLN = new SimpleDoubleProperty();
        extra_ingredients = new ArrayList<Ingredient>();
        type = new ArrayList<PizzaType>();
        size = PizzaDiameter.d30;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getPricePLN() {
        return pricePLN.get();
    }

    public DoubleProperty pricePLNProperty() {
        return pricePLN;
    }

    public void setPricePLN(double pricePLN) {
        this.pricePLN.set(pricePLN);
    }

    public List<Ingredient> getExtra_ingredients() {
        return extra_ingredients;
    }

    public void setExtra_ingredients(List<Ingredient> extra_ingredients) {
        this.extra_ingredients = extra_ingredients;
    }

    public List<PizzaType> getType() {
        return type;
    }

    public void setType(List<PizzaType> type) {
        this.type = type;
    }

    public Enum<PizzaDiameter> getSize() {
        return size;
    }

    public void setSize(Enum<PizzaDiameter> size) {
        this.size = size;
    }
}