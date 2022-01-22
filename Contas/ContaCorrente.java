package Contas;

public class ContaCorrente extends Conta implements Tributaveis{

    private double chequeEspecial;
    
    
    public ContaCorrente(int numero, double saldo, String cPF, String nome, double chequeEspecial) {
        super(numero, saldo, cPF, nome);
        this.chequeEspecial = chequeEspecial;
        
    }

    @Override
    public boolean sacar(double valor) {
        double disponivel = this.chequeEspecial + this.saldo;
        if (valor > disponivel) {
            System.out.println("Saldo insuficiente");
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }

    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }

    

    @Override
    public String toString() {
        return "ContaCorrente [chequeEspecial=" + chequeEspecial + "]";
    }

    @Override
    public double getSaldo() {
        return this.chequeEspecial + this.saldo;
    }

    
    
}
