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
      String sql = "INSERT INTO Veiculo (marca, modelo, placa, cor, anoFabricacao) values (?,?,?,?,?)";
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
    
    public ArrayList<Veiculo> buscar() throws ClassNotFoundException, SQLException{
        ResultSet rs;
        ArrayList<Veiculo> listaAno = new ArrayList();
        con = new Conexao().getConnection();
        String sql = "SELECT * FROM Veiculo";
        PreparedStatement stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        while(rs.next()){
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            String placa = rs.getString("placa");
            String cor = rs.getString("cor"); 
            int anoFabricacao = rs.getInt("anoFabricacao");
            Veiculo vA = new Veiculo(marca, modelo, placa, cor,anoFabricacao);
            listaAno.add(vA);
        }
        stmt.close();
        con.close();
        return listaAno;
    }
    
    public ArrayList<Veiculo> buscarAno(int anoFabricacaoV) throws ClassNotFoundException, SQLException{
        ResultSet rs;
        ArrayList<Veiculo> listaAno = new ArrayList();
        con = new Conexao().getConnection();
        String sql = "SELECT * FROM Veiculo WHERE anoFabricacao = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, anoFabricacaoV);  
        rs = stmt.executeQuery();
        while(rs.next()){
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            String placa = rs.getString("placa");
            String cor = rs.getString("cor"); 
            int anoFabricacao = rs.getInt("anoFabricacao");
            Veiculo vA = new Veiculo(marca, modelo, placa, cor,anoFabricacao);
            listaAno.add(vA);
        }
        stmt.close();
        con.close();
        return listaAno;
    }
    
    public ArrayList<Veiculo> buscarMarca(String marcaV) throws ClassNotFoundException, SQLException{
        ResultSet rs;
        ArrayList<Veiculo> listaAno = new ArrayList();
        con = new Conexao().getConnection();
        String sql = "SELECT * FROM Veiculo WHERE marca = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, marcaV);
        rs = stmt.executeQuery();
        while(rs.next()){
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            String placa = rs.getString("placa");
            String cor = rs.getString("cor"); 
            int anoFabricacao = rs.getInt("anoFabricacao");
            Veiculo vA = new Veiculo(marca, modelo, placa, cor,anoFabricacao);
            listaAno.add(vA);
        }
        stmt.close();
        con.close();
        return listaAno;
    }
}
