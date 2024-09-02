/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.ArrayList;
import model.DAO.VeiculoDAO;
import model.Veiculo;

/**
 *
 * @author aluno
 */
public class VeiculoControl {
    private ArrayList<Veiculo> listaVeiculo;
    
    public VeiculoControl(){
        listaVeiculo = new ArrayList<>();
    }
    
    public void cadastrar(String marca, String modelo, String placa, String cor, int anoFabricacao)throws SQLException, ClassNotFoundException{
        Veiculo v = new Veiculo(marca,modelo,placa, cor, anoFabricacao);
        VeiculoDAO vDao = new VeiculoDAO();
        listaVeiculo.add(v);
        vDao.inserirVeiculo(v);
    }

    public ArrayList<Veiculo> mostrar(){
        return listaVeiculo;
    }
    // marca, o modelo, a placa, a cor, e o ano de fabricação do veículo.
    public void remover(String marca, String modelo, String placa, String cor, int anoFabricacao) throws SQLException, ClassNotFoundException{
        Veiculo v = new Veiculo(marca,modelo,placa, cor, anoFabricacao);
        VeiculoDAO vDao = new VeiculoDAO();
        for(Veiculo v1: listaVeiculo){
            if(v1.getPlaca().equals(placa)){
                listaVeiculo.remove(v1);
                break;
            }
        }
        vDao.excluir(v);
    }
    
    public ArrayList buscarAno() throws ClassNotFoundException, SQLException{
        VeiculoDAO vDao = new VeiculoDAO();
        return vDao.buscarAno();
    }
}
