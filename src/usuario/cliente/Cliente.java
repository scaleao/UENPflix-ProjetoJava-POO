/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.cliente;

import filme.Filme;
import java.util.ArrayList;
import usuario.Usuario;


/**
 *
 * @author jscal
 */
public class Cliente extends Usuario{
    private ArrayList<HistoricoCliente> historico = new ArrayList<>();
    private ArrayList<Filme> favoritos = new ArrayList<>();
    private boolean habilitarHistorico = false;

    public ArrayList<HistoricoCliente> getHistorico() {
        return this.historico;
    }

    public void setHistorico(ArrayList<HistoricoCliente> historico) {
        this.historico = historico;
    }

    public boolean getHabilitarHistorico() {
        return this.habilitarHistorico;
    }

    public void setHabilitarHistorico(int histHabilitado) {
        if (histHabilitado == 1){
            this.habilitarHistorico = true;
        }
        else{
            this.habilitarHistorico = false;
        }
    }

    public ArrayList<Filme> getFavoritos() {
        return this.favoritos;
    }

    public void setFavoritos(ArrayList<Filme> favoritos) {
        this.favoritos = favoritos;
    }

}
