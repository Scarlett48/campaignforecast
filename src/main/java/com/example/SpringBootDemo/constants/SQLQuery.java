package com.example.SpringBootDemo.constants;

public class SQLQuery {

    public static String CREATE_TABLE = "CREATE TABLE INVENTORY " +
            "(id INTEGER NOT NULL," +
            "name VARCHAR(255)," +
            "price INTEGER," +
            "quantity INTEGER, " +
            "PRIMARY KEY (id))";

    public static String INSERT_ITEM = "INSERT INTO INVENTORY " +
            "(id, name, price, quantity) VALUES (?, ?, ?, ?)";

    public static String UPDATE_ITEM = "UPDATE INVENTORY SET name = ?, price = ?, " +
            "quantity = ? where id = ?";

    public static String DELETE_ITEM = "DELETE FROM INVENTORY WHERE id = ";

    public static String GET_ITEM = "SELECT * FROM INVENTORY where id = ";

    public static String GET_ALL_ITEMS = "SELECT * FROM INVENTORY";

}
