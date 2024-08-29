/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuarios;

/**
 *
 * @author Senai
 */
public class UsuariosDAO {
    
public Usuarios validarLogin (Usuarios user){
Usuarios usuario = new Usuarios();

try{
Connection conexao = Conexao.conectar();
   PreparedStatement stmt = null;
   ResultSet rs = null;
   
   stmt = conexao.prepareStatement("select * from usuarios where email=? and senha=?");
   stmt.setString(1, user.getEmail());
   stmt.setString(2, user.getSenha());
   
   rs = stmt.executeQuery();
   
   if(rs.next()){
   usuario.setId_usuario(rs.getInt("id_usuario"));
   usuario.setNome(rs.getString("nome"));
   usuario.setEmail(rs.getString("email"));
   usuario.setSenha(rs.getString("senha"));
   
   }
   
   rs.close();
   stmt.close();
   conexao.close();
 
}catch(SQLException e){
e.printStackTrace();
}



return usuario;
      
}

public void cadastrarUsuario(Usuarios user){
try{
   Connection conexao = Conexao.conectar();
   PreparedStatement stmt = null;
   
   stmt = conexao.prepareStatement(
   "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)"
   );
   
   stmt.setString(1, user.getNome());
   stmt.setString(2, user.getEmail());
   stmt.setString(3, user.getSenha());
   

   stmt.executeUpdate();
   stmt.close();
   conexao.close();

}catch(SQLException e){
e.printStackTrace();
}
}




}


