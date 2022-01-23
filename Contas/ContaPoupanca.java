package Contas;

import java.util.Random;

import exceptions.Data;

public class ContaPoupanca extends Conta{

    private double taxaDeJuros;
    private int diaAniversario;
    
    public ContaPoupanca(Random numero, double saldo, String cPF, String nome, Data dataDeAbertura,
        double taxaDeJuros, int diaAniversario) {
        super(numero, saldo, cPF, nome, dataDeAbertura);
        this.taxaDeJuros = taxaDeJuros;
        this.diaAniversario = diaAniversario;
    }
    

    @Override
    public boolean sacar(double valor) {
        this.saldo -= valor;
        return true;
    }

 

    public double getSaldo(int dia){
        if (dia >= this.diaAniversario) {
            return this.saldo + this.taxaDeJuros * this.saldo;
            
        } else {
            return this.saldo;
        }
    }

    @Override
    public String toString() {
        return super.toString() 
        + "ContaPoupanca [diaAniversario=" 
        + diaAniversario 
        + ", taxaDeJuros=" 
        + taxaDeJuros + "]";
    }
   
    
   
}
