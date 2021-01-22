import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PizzaDAO {

    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public PizzaDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
    }

    private ObservableList<Pizza> getRacketList(ResultSet rs) throws SQLException {

        ObservableList<Pizza> pizzaList = FXCollections.observableArrayList();

        while (rs.next()) {

            Pizza p= new Pizza();
            p.setId(rs.getInt("id_pizza_typ"));
            p.setName(rs.getString("pizza_name"));
            p.setIngredients(rs.getString("pizza_description"));
            p.setType();
            p.setManufacturer(rs.getString("manufacturer"));
            p.setMass(rs.getInt("mass"));
            p.setHeadSize(rs.getInt("head_size"));
            p.setDominantColor(rs.getString("dominant_color"));
            p.setPriceUSD(rs.getDouble("priceUSD"));
            pizzaList.add(p);



            name = new SimpleStringProperty();
            ingredients = new ArrayList<Ingredient>();
            pricePLN = new SimpleDoubleProperty();
            extra_ingredients = new ArrayList<Ingredient>();
            type = new ArrayList<PizzaType>();
            size = PizzaDiameter.d30;
        }

        return racketList;
    }


    public ObservableList<Racket> searchRackets(String manuf) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM rackets WHERE manufacturer LIKE '%" + manuf + "%';";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Racket> rackets = getRacketList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return rackets;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching a racket from '" + manuf + "' name, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<Racket> showAllRackets() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM rackets;";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Racket> racketList = getRacketList(resultSet);
            consoleTextArea.appendText(selectStmt);

            return racketList;


        } catch (SQLException e) {
            consoleTextArea.appendText("While searching rackets, an error occurred. \n");
            throw e;
        }

    }

    public void insertRacket(String name) throws SQLException, ClassNotFoundException {

        StringBuilder sb = new StringBuilder("INSERT INTO rackets(model) VALUES('");
        sb.append(name);
        sb.append("');");
        String insertStmt = sb.toString();

        try {

            dbUtil.dbExecuteUpdate(insertStmt);
            consoleTextArea.appendText(insertStmt + "\n");

        } catch (SQLException e) {
            consoleTextArea.appendText("Error occurred while INSERT Operation.");
            throw e;
        }

    }


}
