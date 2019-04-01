/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.cliente;

/**
 *
 * @author ramon
 */
public class Favoritos {
    private String login;
    private String titulo;
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return this.login;
    }
}
