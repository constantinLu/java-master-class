package MasterClass.TestDB.Model;

import java.sql.*;

/**
 * Created by lunguc on 28.08.2017.
 */
public class Main {

    //creating constants for the variables of the sql project ()

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\lunguc\\Desktop\\J\\xx Tools\\databases\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        //SECOND WAY
//      try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lunguc\\Desktop\\J\\xx Tools\\databases\\testajava.db");
//             Statement statement = conn.createStatement()){
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

        try {
            //ONE WAY


            //SWICHING FROM HARD CODING TO GENERAL!

            //CREATE TABLE
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " " +
                    " (" + COLUMN_NAME + " text, " + COLUMN_PHONE + " integer," + COLUMN_EMAIL + " text " + ")");

            //INSERT
//            statement.execute ("INSERT INTO "  + TABLE_CONTACTS +
//                                " ( " + COLUMN_NAME + ", " +  COLUMN_PHONE + ", " + COLUMN_EMAIL + " )" +
//                                " VALUES ('Tim', 1742085872, 'tim@gmail.com')");
//
//            statement.execute ("INSERT INTO "  + TABLE_CONTACTS +
//                    " ( " + COLUMN_NAME + ", " +  COLUMN_PHONE + ", " + COLUMN_EMAIL + " )" +
//                    " VALUES ('Joe', 17454498224, 'Joe@gmail.com')");
//
//            statement.execute ("INSERT INTO "  + TABLE_CONTACTS +
//                    " ( " + COLUMN_NAME + ", " +  COLUMN_PHONE + ", " + COLUMN_EMAIL + " )" +
//                    " VALUES ('Jane', 1742004887, 'jane@gmail.com')");
//
//            statement.execute ("INSERT INTO "  + TABLE_CONTACTS +
//                    " ( " + COLUMN_NAME + ", " +  COLUMN_PHONE + ", " + COLUMN_EMAIL + " )" +
//                    " VALUES ('Fido', 1724558798, 'fido@gmail.com')");

            //applying the insert method created bellow
            insertContact(statement, "Tim", 1742085872, "tim@gmail.com");
            insertContact(statement, "Jane", 1745449822, "Joe@gmail.com");
            insertContact(statement, "Fido", 1724558798, "fido@gmail.com");
            insertContact(statement, "Joe", 1745449822, "joe@gmail.com");


            //UPDATE
            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + " = 555323234" +
                    " WHERE " + COLUMN_NAME + " ='Jane'");
            //DELETE
            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                    " WHERE " + COLUMN_NAME + " = 'Joe'");

            //QUERY RESULTS
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));

            }

            results.close();
            statement.close();
            conn.close();


            //second statment
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('Joe', 1749617031, 'tim@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES('Catalin', 0735771294, 'tim@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES('Jack', 0722502341, 'tim@gmail.com')");

            //update comands
            //statement.execute("UPDATE contacts SET phone=08989008884 WHERE name ='Joe'");

            //statement.execute("DELETE FROM contacts WHERE name='Catalin'");

            //showing the sql results !
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();

            // showing the 2nd method to perform a query!;
//            //executing the queryMehod of Java
//            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
//            while(results.next()) {
//                System.out.println("Results " + results.getString("name") + " " +
//                                    results.getInt("phone") + " " +
//                                    results.getString("email"));
//
//            }
//            results.close();
//
//            //closing the connection and the statement (order is important); statement first, connection second !
//            statement.close();
//            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());

            //for printing the erros
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " ( " + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL + " )" +
                " VALUES ('" + name + "', " + phone + ", '" + email + "')");
    }
}
