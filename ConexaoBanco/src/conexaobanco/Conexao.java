/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edimar
 */
public class Conexao {

    private static Connection conn;
    private final static String driver = "org.postgresql.Driver"; //sempre assim para o PostgreSQL
    private final static String ip = "localhost/"; //Ip que contem o Banco
    public static String dataBase = "aula"; //nome da base de dados no PostgreSQL
    public static String user = "postgres"; //Usuario do Banco de dados
    public static String password = "postgres"; //Senha para o Usuário

    public Conexao(Connection conn) {
        this.conn = conn;
    }

    /*
        Estabelecendo uma conexão com o banco de dados
    */
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        if (conn != null) {
            return conn; //usa
        }

        //cria
        Class.forName(driver); //nao mexer - definindo JDBC utilizado
        conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + dataBase, user, password); //nao mexer - 
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Feito!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
