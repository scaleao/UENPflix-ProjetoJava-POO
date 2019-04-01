/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filme;

/**
 *
 * @author jscal
 */
public class Filme {
    String genero;
    String titulo;
    String duracao;
    String produtora;
    String elenco;
    Float pontuacao;
    int assistido;
    
    public String getGenero(){
        return this.genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produdora) {
        this.produtora = produdora;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public Float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Float pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public int getAssistido(){
        return this.assistido;
    }
    
    public void setAssistido(int assistido){
        this.assistido = assistido;
    }
    
}
