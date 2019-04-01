/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import filme.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import login.Login;
import org.postgresql.util.PSQLException;
import usuario.Usuario;
import usuario.cliente.Cliente;
import usuario.cliente.Favoritos;
import usuario.cliente.HistoricoCliente;
import usuario.funcionario.Funcionario;

/**
 *
 * @author jscal
 */
public class ClienteController {
    private final Connection conexao;
    private final String QUERY_INSERT
            = "INSERT INTO usuario"
            + "(nome, idade, endereco, login, senha, tipodousuario, hist)"
            + " VALUES (?,?,?,?,?, 0, 0)";
    private final String QUERY_LISTAR 
            = "SELECT * FROM usuario";
    private final String QUERY_LISTAR_CLIENTE
            = "SELECT * FROM usuario WHERE tipodousuario = 0";
    private final String QUERY_EXCLUIR 
            = "DELETE FROM usuario WHERE login = ?";
    private final String QUERY_EDITAR
            = "UPDATE usuario SET nome = ?"
            + ", idade = ?, endereco = ?, senha = ?"
            + " WHERE login = ?";
    private final String QUERY_GET_USUARIO
            = "SELECT * FROM usuario WHERE login = ?";
    private final String QUERY_ATIVAR_HIST
            = "UPDATE usuario SET hist = 1 WHERE login = ?";
    private final String QUERY_HISTORICO 
            = "SELECT * FROM historico WHERE login = ?";
    private final String QUERY_ADD_HIST
            = "INSERT INTO historico"
            + "(login, filmeassistido, movimentacao, horario)"
            + "VALUES(?, ?, ?, ?)"; 
    private final String QUERY_FAVORITAR
            = "INSERT INTO favoritos"
            + "(login, titulo)"
            + "VALUES(?, ?)";
    private final String QUERY_LISTA_FAV
            = "SELECT * FROM favoritos"
            + "WHERE login = ?";
    private final String QUERY_FILMES_FAVS
            = "SELECT * FROM filme INNER JOIN favoritos "
            + "ON filme.titulo = favoritos.titulo "
            + "WHERE favoritos.login = ? ";
    private final String QUERY_DELETAR_FAV
            = "DELETE FROM favoritos WHERE login = ? AND titulo = ?";
    private final String QUERY_RECOMENDADOS
            = "SELECT f2.titulo, f2.duracao, f2.genero, f2.produtora, f2.elenco, f2.av_media "
            + "FROM favoritos AS fav "
            + "INNER JOIN filme AS f1 ON f1.titulo = fav.titulo "
            + "INNER JOIN filme AS f2 ON f1.elenco = f2.elenco OR f1.produtora = f2.produtora "
            + "WHERE fav.login = ? "
            + "GROUP BY f2.titulo";

    public ClienteController(){
        conexao = Conexao.getConexao();
    }
    public ArrayList<Filme> getFilmeRecomendado(String login) throws SQLException{
        ArrayList<Filme> lista = new ArrayList();
        PreparedStatement ps = conexao.prepareStatement(QUERY_RECOMENDADOS);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Filme temp = new Filme();
            temp.setTitulo(rs.getString("titulo"));
            temp.setDuracao(rs.getString("duracao"));
            temp.setGenero(rs.getString("genero"));
            temp.setProdutora(rs.getString("produtora"));
            temp.setElenco(rs.getString("elenco"));
            temp.setPontuacao(rs.getFloat("av_media"));
            lista.add(temp);
        }
        return lista;
    }
    
    public int delFav(String login, String titulo) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_DELETAR_FAV);
        ps.setString(1, login);
        ps.setString(2, titulo);
        return ps.executeUpdate();
    }
    
    public int addFavorito(String login, String titulo) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_FAVORITAR);
        ps.setString(1, login);
        ps.setString(2, titulo);
        return ps.executeUpdate();
    }
    
    public ArrayList<Filme> filmesFavoritos(String login) throws SQLException{
        ArrayList<Filme> lista = new ArrayList();
        PreparedStatement ps = conexao.prepareStatement(QUERY_FILMES_FAVS);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Filme temp = new Filme();
            temp.setTitulo(rs.getString("titulo"));
            temp.setDuracao(rs.getString("duracao"));
            temp.setGenero(rs.getString("genero"));
            temp.setProdutora(rs.getString("produtora"));
            temp.setElenco(rs.getString("elenco"));
            temp.setPontuacao(rs.getFloat("av_media"));
            lista.add(temp);
        }
        return lista;
    }
    
    public ArrayList<Favoritos> listarFavs(String login) throws SQLException{
        ArrayList<Favoritos> lista = new ArrayList();
        PreparedStatement ps = conexao.prepareStatement(QUERY_LISTA_FAV);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Favoritos temp = new Favoritos();
            temp.setLogin(rs.getString("login"));
            temp.setTitulo(rs.getString("titulo"));
            lista.add(temp);
        }
        return lista;
    }
    
    public ArrayList<HistoricoCliente> listarHist(String login)throws SQLException{
        ArrayList<HistoricoCliente> lista = new ArrayList();
        PreparedStatement ps = conexao.prepareStatement(QUERY_HISTORICO);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            HistoricoCliente temp = new HistoricoCliente();
            temp.setLogin(rs.getString("login"));
            temp.setFilmeAssistidos(rs.getString("filmeassistido"));
            temp.setMovimentacao(rs.getString("movimentacao"));
            temp.setHorario(rs.getString("horario"));
            lista.add(temp);
        }
        return lista;
    }
    
    public int ativarHist(String login) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_ATIVAR_HIST);
        ps.setString(1, login);
        return ps.executeUpdate();
    }
    public int addHist(String login, HistoricoCliente hist) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_ADD_HIST);
        ps.setString(1, login);
        ps.setString(2, hist.getFilmeAssistidos());
        ps.setString(3, hist.getMovimentacao());
        ps.setString(4, hist.getHorario());
        return ps.executeUpdate();
    }
    
    public int inserir(Cliente cliente) throws SQLException, PSQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_INSERT);
        ps.setString(1, cliente.getNome());
        ps.setInt(2, cliente.getIdade());
        ps.setString(3, cliente.getEndereco());
        ps.setString(4, cliente.getLogin());
        ps.setString(5, cliente.getSenha());
        return ps.executeUpdate();
    }
    
    public ArrayList<Usuario> listar() throws SQLException{
        ArrayList<Usuario> lista = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement(QUERY_LISTAR_CLIENTE);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Cliente temp = new Cliente();
            Login log = new Login();
            temp.setNome(rs.getString("nome"));
            temp.setIdade(rs.getInt("idade"));
            temp.setEndereco(rs.getString("endereco"));
            log.setUsuario(rs.getString("login"));
            log.setSenha(rs.getString("senha"));
            temp.setLogin(log);
            temp.setGeneroFuncionario("Cliente");
            lista.add(temp);
        }
        return lista;
    }
    
    public int excluir(String nome) throws SQLException{
        PreparedStatement ps 
                = conexao.prepareStatement(QUERY_EXCLUIR);
        ps.setString(1, nome);
        return ps.executeUpdate();
    }
    
    public int editar(Cliente func) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_EDITAR);
        ps.setString(1, func.getNome());
        ps.setInt(2, func.getIdade());
        ps.setString(3, func.getEndereco());
        ps.setString(4, func.getSenha());
        ps.setString(5, func.getLogin());
        return ps.executeUpdate();
    }
    
    public Cliente getClient(String login) throws SQLException{
        Cliente temp = new Cliente();
        Login log = new Login();
        PreparedStatement ps = conexao.prepareStatement(QUERY_GET_USUARIO);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            temp.setNome(rs.getString("nome"));
            temp.setIdade(rs.getInt("idade"));
            temp.setEndereco(rs.getString("endereco"));
            log.setUsuario(rs.getString("login"));
            log.setSenha(rs.getString("senha"));
            temp.setHabilitarHistorico(rs.getInt("hist"));
            temp.setLogin(log);
            temp.setGeneroFuncionario("Cliente");
            
        }
        return temp;
    }
}