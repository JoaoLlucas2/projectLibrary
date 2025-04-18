package org.classes.testes;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//Classe Demo para testar consultas no Banco de Dados (Básico)
public class ServerDemo1 {
    public static void main(String[] args) {

        Properties prop = new Properties();
        String sql = "SELECT * FROM person";

        //Carregando o arquivo Properties para dentro do código usando o caminho absoluto
        try(InputStream fileIn = ServerDemo1.class.getClassLoader().getResourceAsStream("flyway.conf")) {

            //verificando se o arquivo foi encontrado ou não (Lançando Exceção)
            if(fileIn == null) {
                throw new IllegalArgumentException("Arquivo especificado não encontrado. ");
            }

            //Lendo o fluxo de Input usando o obejeto Properties
            prop.load(fileIn);

            String url = prop.getProperty("db.url");
            String userName = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            //Estabelecendo conexão com um Banco de Dados
            try(Connection conn = DriverManager.getConnection(url, userName, password)) {
                System.out.println("Conexão Estabelecida. ");

                //Definindo um Statement, Executando uma query e armazenando o retorno num ResultSet
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                //Leitura e Print das Rows da Tabela no terminal
                while(rs.next()) {

                    System.out.println("Coluna 1: " + rs.getInt("id") +
                            ", Coluna 2: " + rs.getString("first_name") +
                            ", Coluna 3: " + rs.getString("last_name") +
                            ", Coluna 4: " + rs.getString("email"));

                }

            }catch(SQLException e) { //exceção SQL
                System.out.println("Erro ao conectar com o Banco de Dados: " + e.getMessage());
            }

        }catch (Exception e) { //exceção genérica para falha no carregamento do arquivo
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
        }

    }
}
