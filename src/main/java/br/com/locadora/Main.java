package br.com.locadora;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        try {
            Connection conn = DB.getConnection();
            System.out.println(conn.isClosed());
            System.out.println(conn.isReadOnly());
            System.out.println(conn.isValid(0));
            DB.closeConnection();
            System.out.println(conn.isClosed());
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        MenuPrincipal janelaPrincipal = new MenuPrincipal();
        janelaPrincipal.show();
    }
}