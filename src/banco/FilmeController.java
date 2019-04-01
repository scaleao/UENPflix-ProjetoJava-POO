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

/**
 *
 * @author ramon
 */
public class FilmeController {
    private final Connection conexao;
    private final String QUERY_INSERIR = "INSERT INTO filme "
            + "(titulo, duracao, genero, produtora, elenco, assistido, av_total, av_media)"
            + "VALUES(?, ?, ?, ?, ?, 0, 0, 0)";
    private final String QUERY_LISTAR 
            = "SELECT * FROM filme";
    private final String QUERY_EXCLUIR 
            = "DELETE FROM filme WHERE titulo = ?";
    private final String QUERY_EDITAR
            = "UPDATE filme SET duracao = ?, genero = ?, "
            + "produtora = ?, elenco = ?"
            + " WHERE titulo = ?";
    private final String QUERY_ASSISTIR
            = "UPDATE filme SET assistido = assistido + 1 WHERE titulo = ?";
    private final String QUERY_GET
            = "SELECT * FROM filme "
            + "WHERE titulo = ? ";
    private final String QUERY_BUSCA
            = "SELECT * FROM filme WHERE titulo ILIKE ? OR genero ILIKE ? "
            + "OR produtora ILIKE ? OR elenco ILIKE ? ";
    private final String QUERY_AVALIAR
            = "UPDATE filme SET av_total = av_total + ? WHERE titulo = ? ;"
            + "UPDATE filme SET av_media = (av_total / assistido) WHERE titulo = ?"; 
    
    public FilmeController(){
        conexao = Conexao.getConexao();
    }
    public int avaliar(String titulo, int avaliacao) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_AVALIAR);
        ps.setInt(1, avaliacao);
        ps.setString(2, titulo);
        ps.setString(3, titulo);
        return ps.executeUpdate();
    }
    public Filme getFilme(String titulo) throws SQLException{
        Filme temp = new Filme();
        PreparedStatement ps = conexao.prepareStatement(QUERY_GET);
        ps.setString(1, titulo);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            temp.setTitulo(rs.getString("titulo"));
            temp.setDuracao(rs.getString("duracao"));
            temp.setGenero(rs.getString("genero"));
            temp.setProdutora(rs.getString("produtora"));
            temp.setElenco("assistido");
            temp.setPontuacao(rs.getFloat("av_media"));
        }
        return temp;
    } 
    
    public ArrayList<Filme> buscar(String busc) throws SQLException{
        ArrayList<Filme> lista = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement(QUERY_BUSCA);
        ps.setString(1, '%' + busc + '%');
        ps.setString(2, '%' + busc + '%');
        ps.setString(3, '%' + busc + '%');
        ps.setString(4, '%' + busc + '%');
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Filme temp = new Filme();
            temp.setTitulo(rs.getString("titulo"));
            temp.setDuracao(rs.getString("duracao"));
            temp.setGenero(rs.getString("genero"));
            temp.setProdutora(rs.getString("produtora"));
            temp.setElenco(rs.getString("elenco"));
            temp.setAssistido(rs.getInt("assistido"));
            temp.setPontuacao(rs.getFloat("av_media"));
            lista.add(temp);
        }
        return lista;
    }
    
    public int assistirFilme(String titulo) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_ASSISTIR);
        ps.setString(1, titulo);
        return ps.executeUpdate();
    }
    
    public int inserir(Filme filme) throws SQLException, PSQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_INSERIR);
        ps.setString(1, filme.getTitulo());
        ps.setString(2, filme.getDuracao());
        ps.setString(3, filme.getGenero());
        ps.setString(4, filme.getProdutora());
        ps.setString(5, filme.getElenco());
        return ps.executeUpdate();
    }
    
    public int editar(Filme filme) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_EDITAR);
        ps.setString(1, filme.getDuracao());
        ps.setString(2, filme.getGenero());
        ps.setString(3, filme.getProdutora());
        ps.setString(4, filme.getElenco());
        ps.setString(5, filme.getTitulo());
        return ps.executeUpdate();
    }
    
    public int excluir(String titulo) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_EXCLUIR);
        ps.setString(1, titulo);
        return ps.executeUpdate();
    }

    public ArrayList<Filme> listar() throws SQLException{
        ArrayList<Filme> lista = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement(QUERY_LISTAR);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Filme temp = new Filme();
            temp.setTitulo(rs.getString("titulo"));
            temp.setDuracao(rs.getString("duracao"));
            temp.setGenero(rs.getString("genero"));
            temp.setProdutora(rs.getString("produtora"));
            temp.setElenco(rs.getString("elenco"));
            temp.setAssistido(rs.getInt("assistido"));
            temp.setPontuacao(rs.getFloat("av_media"));
            lista.add(temp);
        }
        return lista;
    }
}
