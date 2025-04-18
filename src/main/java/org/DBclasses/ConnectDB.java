package org.DBclasses;
import org.classes.Book;

import java.io.IOException;
import java.sql.*;
import java.io.InputStream;
import java.util.Properties;

public class ConnectDB {

    public Connection connectionDB() {

        Properties props = new Properties();
        Connection conn = null;

        try(InputStream fileIn = ConnectDB.class.getClassLoader().getResourceAsStream("flyway.conf")) {

            if (fileIn == null) {
                throw new IllegalArgumentException("Arquivo não localizado. ");
            }
            props.load(fileIn);

            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Conexão Realizada com Sucesso. ");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o Banco de Dados: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de configuração: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro Inesperado: " + e.getMessage());
        }

        return conn;
    }

    public void insertBook (Connection conn, Book book) {

        String query = "INSERT INTO books VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o livro ao catálogo: " + e.getMessage());
        }
    }
}
