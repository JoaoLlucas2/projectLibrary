package org.classes.testes;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresTest {
    public static void main(String[] args) {

        Properties props = new Properties();

        try (InputStream fileIn = PostgresTest.class.getClassLoader().getResourceAsStream("flyway.conf")) {

            if(fileIn == null) {
                throw new IllegalArgumentException("Arquivo especificado não encontrado. ");
            }

            props.load(fileIn);
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            try (Connection connect = DriverManager.getConnection(url, username, password)) {
                System.out.println("Conexão com o Banco de Dados bem sucedida. ");
            }catch (SQLException e) {
                System.out.println("Erro ao conectar com o Banco de Dados: " + e.getMessage());
            }

        }catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo de configuração: " + e.getMessage());
        }
    }
}
