/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.cliente;

import filme.Filme;

/**
 *
 * @author jscal
 */
public class HistoricoCliente {
    private String login;
    private String filmeAssistidos;
    private String movimentacao;
    private String horario;

    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getFilmeAssistidos() {
        return filmeAssistidos;
    }

    public void setFilmeAssistidos(String filmeAssistidos) {
        this.filmeAssistidos = filmeAssistidos;
    }

    public String getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(String movimentacao) {
        this.movimentacao = movimentacao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
}
