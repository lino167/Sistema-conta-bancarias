package Contas;

import java.util.Random;

import exceptions.Data;

public abstract class Conta {

    private Random numero;
    protected double saldo;
    private String CPF;
    private String nome;
    protected Data dataDeAbertura;
    

    public Conta(Random numero, double saldo, String cPF, String nome, Data dataDeAbertura) {
        this.numero = numero;
        this.saldo = saldo;
        CPF = cPF;
        this.nome = nome;
        this.dataDeAbertura = dataDeAbertura;
    }


    public  boolean transferir(Conta conta, double valor){
        if(this.sacar(valor)){
            conta.depositar(valor);
            return true;
        }
        System.out.println("Nao foi possivel fazer a transferencia");
        return false;
    }

    public abstract boolean sacar(double valor);
   
    public void depositar(double valor){
        this.saldo += valor;

}

    @Override
    public String toString() {
        return "Conta [CPF=" 
        + CPF + ", dataDeAbertura=" 
        + dataDeAbertura 
        + ", nome=" 
        + nome 
        + ", numero=" 
        + numero
                
        + ", saldo=" + saldo + "]";
    }
    
public String mostraDados(){
    String dados = "Titular: " + this.nome;
    dados += "\nCPF: " + this.CPF;
    dados += "\nNúmero da conta: " + this.numero;
    dados += "\nSaldo disponível: " + this.saldo;
    dados += "Dia: "+"/" + this.dataDeAbertura.dia;
    dados += "Mês: "+"/" + this.dataDeAbertura.mes;
    dados += "Ano: " + this.dataDeAbertura.ano;
    return dados;
    
}
    
    
}
