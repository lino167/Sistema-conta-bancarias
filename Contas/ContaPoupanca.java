package Contas;

import java.time.LocalDateTime;

public class ContaPoupanca extends Conta{

    private double taxaDeJuros;
    private int diaAniversario;
    
    public ContaPoupanca(int numero, double saldo, String cPF, String nome, LocalDateTime dataDeAbertura,
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

    public double getSaldo(){
        return this.saldo + this.taxaDeJuros * this.saldo;
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
