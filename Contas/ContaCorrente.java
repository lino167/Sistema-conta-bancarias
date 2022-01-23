package Contas;

import java.time.LocalDateTime;

public class ContaCorrente extends Conta implements Tributaveis{

    private double chequeEspecial;

    public ContaCorrente(int numero, double saldo, String cPF, String nome, LocalDateTime dataDeAbertura,
            double chequeEspecial) {
        super(numero, saldo, cPF, nome, dataDeAbertura);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return super.toString() 
        + "ContaCorrente [chequeEspecial=" 
        + chequeEspecial + "]";
    }

    @Override
    public double getValorImposto() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean sacar(double valor) {
        double disponivel = this.chequeEspecial 
        + this.saldo;
        if (valor > disponivel) {
            System.out.println("Saldo insuficiente");
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }

    }
    
public double getSaldo(){
    return this.chequeEspecial + this.saldo;
}
    
    
}
