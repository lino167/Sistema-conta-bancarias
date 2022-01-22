package Contas;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaPoupanca extends Conta{

    private LocalDateTime dataCadastro;
    private double taxaDeJuros;
    private double Saldo;
    private double getSaldo;
    
    public ContaPoupanca(int numero, double saldo, String cPF, String nome, LocalDateTime dataCadastro, double taxaDeJuros) {
        super(numero, saldo, cPF, nome);
        this.dataCadastro = dataCadastro;
        this.taxaDeJuros = taxaDeJuros;
    }


    public double saldo(int dia){
        if (LocalDate >= this.dataCadastro){
        this.getSaldo = this.getSaldo() + this.getSaldo() * this.taxaDeJuros;
        return this.getSaldo();
        } else {
            return this.getSaldo();
        }
    }


    @Override
    public boolean sacar(double valor) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean depositar(double valor) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public double getSaldo() {
        // TODO Auto-generated method stub
        return 0;
    }
}
