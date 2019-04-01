/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import login.Login;

/**
 *
 * @author jscal
 */
public abstract class Usuario {
    String nome;
    int idade;
    String endereco;
    Login login;
    String generoFuncionario;
    boolean funcionario = false;
    boolean cliente = false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getLogin(){
        return this.login.getUsuario();
    }
    
    public String getSenha(){
        return this.login.getSenha();
    }
    
    public void setLogin(Login login){
        this.login = login;
    }
    
    public boolean getFuncionario(){
        return funcionario;
    }
    
    public void setFuncionario(){
        this.funcionario = true;
    }
    
    public boolean getCliente(){
        return cliente;
    }
    
    public void setCliente(){
        this.cliente = true;
    }

    public String getGeneroFuncionario() {
        return generoFuncionario;
    }

    public void setGeneroFuncionario(String generoFuncionario) {
        this.generoFuncionario = generoFuncionario;
    }
    
}
