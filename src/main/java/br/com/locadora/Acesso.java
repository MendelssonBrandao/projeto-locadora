package br.com.locadora;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Acesso {

    private static Connection conn = null;

    public boolean conecta() {

        boolean retorno = true;

        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                retorno = false;
                throw new DbException(e.getMessage());
            }
        }
        return retorno;
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public int veExiste(String query) {
        int valor = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SElect count(*) from " + query);
            resultSet.next();
            valor = resultSet.getInt(1);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Problemas na query " + query);
            e.printStackTrace();
        }
        return valor;
    }

    public static void desconecta() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
