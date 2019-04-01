/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import login.Login;
import org.postgresql.util.PSQLException;
import usuario.Usuario;
import usuario.cliente.Cliente;
import usuario.funcionario.Funcionario;

/**
 *
 * @author jscal
 */


public class FuncionarioController {
    
    private final Connection conexao;
    private final String QUERY_INSERT
            = "INSERT INTO usuario"
            + "(nome, idade, endereco, login, senha, tipodousuario, hist)"
            + " VALUES (?,?,?,?,?, 1, 0)";
    private final String QUERY_LISTAR 
            = "SELECT * FROM usuario";
    private final String QUERY_EXCLUIR_CLIENTE
            = "DELETE FROM historico WHERE login = ? ;"
            + "DELETE FROM favoritos WHERE login = ? ;"
            + "DELETE FROM usuario WHERE login = ? ";
    private final String QUERY_EDITAR
            = "UPDATE usuario SET nome = ?,"
            + " idade = ?, endereco = ?, login = ?, senha = ?"
            + " WHERE login = ?";
    private final String QUERY_GET = 
            "SELECT * FROM usuario WHERE login = ?";
    private final String QUERY_GET_TIPO = 
            "SELECT tipodousuario FROM usuario "
            + "WHERE login = ? AND senha = ?";
    
    
    public FuncionarioController(){
        conexao = Conexao.getConexao();
    }
//
    
    //
    public ArrayList<Usuario> listarTodos() throws SQLException{
        ArrayList<Usuario> lista = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement(QUERY_LISTAR);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario temp;
            if (rs.getInt("tipodousuario") == 0){
                temp = new Cliente();
                temp.setGeneroFuncionario("Cliente");
                temp.setCliente();
            }
            else{
                temp = new Funcionario();
                temp.setGeneroFuncionario("Funcionario");
                temp.setFuncionario();
            }
            Login log = new Login();
            temp.setNome(rs.getString("nome"));
            temp.setIdade(rs.getInt("idade"));
            temp.setEndereco(rs.getString("endereco"));
            log.setUsuario(rs.getString("login"));
            log.setSenha(rs.getString("senha"));
            temp.setLogin(log);
            lista.add(temp);
        }
        return lista;
    }
    //
    
    public int inserir(Funcionario func) throws SQLException, PSQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_INSERT);
        ps.setString(1, func.getNome());
        ps.setInt(2, func.getIdade());
        ps.setString(3, func.getEndereco());
        ps.setString(4, func.getLogin());
        ps.setString(5, func.getSenha());
        return ps.executeUpdate();
    }
    
    public ArrayList<Usuario> listar() throws SQLException{
        ArrayList<Usuario> lista = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement(QUERY_LISTAR);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Funcionario temp = new Funcionario();
            Login log = new Login();
            temp.setNome(rs.getString("nome"));
            temp.setIdade(rs.getInt("idade"));
            temp.setEndereco(rs.getString("endereco"));
            log.setUsuario(rs.getString("login"));
            log.setSenha(rs.getString("senha"));
            temp.setLogin(log);
            lista.add(temp);
        }
        return lista;
    }
    
    public int excluir(String nome) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_EXCLUIR_CLIENTE);
        ps.setString(1, nome);
        ps.setString(2, nome);
        ps.setString(3, nome);
        ps.executeUpdate();
        return ps.executeUpdate();
    }
    
    public int editar(Usuario us) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_EDITAR);
        ps.setString(1, us.getNome());
        ps.setInt(2, us.getIdade());
        ps.setString(3, us.getEndereco());
        ps.setString(4, us.getLogin());
        ps.setString(5, us.getSenha());
        ps.setString(6, us.getLogin());
        return ps.executeUpdate();
    }
    /*
    public int editar(Funcionario func) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_EDITAR);
        ps.setString(1, func.getNome());
        ps.setInt(2, func.getIdade());
        ps.setString(3, func.getEndereco());
        ps.setString(4, func.getLogin());
        ps.setString(5, func.getSenha());
        ps.setString(6, func.getLogin());
        return ps.executeUpdate();
    }
    */
    
    public int getTipo(String login, String senha) throws SQLException{
        int tipo = -1;
        PreparedStatement ps = conexao.prepareStatement(QUERY_GET_TIPO);
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            tipo = rs.getInt("tipodousuario");
        }
        return tipo;
    }
    
    public Funcionario getFunc(String login) throws SQLException{
        Funcionario temp = new Funcionario();
        Login log = new Login();
        PreparedStatement ps = conexao.prepareStatement(QUERY_GET);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            temp.setNome(rs.getString("nome"));
            temp.setIdade(rs.getInt("idade"));
            temp.setEndereco(rs.getString("endereco"));
            log.setUsuario(rs.getString("login"));
            log.setSenha(rs.getString("senha"));
            temp.setLogin(log);
            temp.setGeneroFuncionario("Funcionario");
        }
        return temp;
    }
}