package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextField;

import java.sql.*;

public class DBControle {
    public Statement database;
    public TextField dataSearch;
    public TextArea dataRecipe;

    private void initializeDB() throws SQLException {
        // Establish a connection
        Connection connection = DriverManager.getConnection
                ("JDBC:sqlite:C:src/Opskrifter/Opskrifter");
        System.out.println("Database connected.");
        // Create a statement
        database = connection.createStatement();

    }
    public void databarOnAction(ActionEvent actionEvent) {

        dataSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    try {
                        initializeDB();
                        String datb = dataSearch.getText();
                        ResultSet datb2 = database.executeQuery("SELECT * FROM main.Name ");
                        dataRecipe.setText(datb2.getString("Navn")
);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }
            }
        }
    });
}
// If you're looking at this text now its not compleeted. Making on it further 26-02-2021
}

