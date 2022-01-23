package Contas;

import java.time.LocalDateTime;

public abstract class Conta {

    private int numero;
    protected double saldo;
    private String CPF;
    private String nome;
    private LocalDateTime dataDeAbertura;
    

    public Conta(int numero, double saldo, String cPF, String nome, LocalDateTime dataDeAbertura) {
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
    

    
    
}
