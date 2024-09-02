/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Veiculo;

/**
 *
 * @author aluno
 */
public class VeiculoDAO {
    Connection con= null;
    
    public void inserirVeiculo(Veiculo v) throws SQLException, ClassNotFoundException{
      con = new Conexao().getConnection();
      String sql = "Insert Into Veiculo (placa, marca, modelo, cor, anoFabricacao) values (?,?,?,?,?)";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1,v.getMarca());
      stmt.setString(2,v.getModelo());
      stmt.setString(3,v.getPlaca());
      stmt.setString(4,v.getCor());
      stmt.setInt(5,v.getAnoFabricacao());
      stmt.execute();
      stmt.close();
      con.close();    
    }
    
    public void excluir(Veiculo v) throws SQLException, ClassNotFoundException{
        con = new Conexao().getConnection();
        String sql = "DELETE FROM Veiculo WHERE placa = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,v.getPlaca());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public ArrayList<Veiculo> buscarAno(/*String anoFabricacaoV*/) throws ClassNotFoundException, SQLException{
        ResultSet rs;
        ArrayList<Veiculo> listaAno = new ArrayList();
        con = new Conexao().getConnection();
        String sql = "SELECT * FROM Veiculo";
        PreparedStatement stmt = con.prepareStatement(sql);
        //stmt.setString(5, anoFabricacaoV);  
        rs = stmt.executeQuery();
        while(rs.next()){
            String marca = rs.getString("MARCA");
            String modelo = rs.getString("MODELO");
            String placa = rs.getString("PLACA");
            String cor = rs.getString("COR");
            int anoFabricacao = rs.getInt("ANO FABRICACAO");
            Veiculo vA = new Veiculo(marca, modelo, placa, cor,anoFabricacao);
            listaAno.add(vA);
        }
        stmt.close();
        con.close();
        return listaAno;
    }
}
