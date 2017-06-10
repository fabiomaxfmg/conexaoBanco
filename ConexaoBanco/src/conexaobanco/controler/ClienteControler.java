/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco.controler;


import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ClienteControler {
    
    public boolean inserir (int codigo, String nome){
        String sql = "INSERT INTO cliente (nome, codigo) VALUES (?, ?)"; //define instrução SQL
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql); //prepara instrução SQL
            ps.setString(1, nome);
            ps.setInt(2, codigo);
            ps.execute(); //executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex){
            Logger.getLogger(ClienteControler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void main(String[] args) {
        ClienteControler ctrl = new ClienteControler();
        ctrl.inserir(11, "Creuza");
        ctrl.inserir(12, "Filisbina");
        ctrl.inserir(13, "Juvelina");
        
    }
}
