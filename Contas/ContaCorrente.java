package Contas;


import java.time.LocalDateTime;




public class ContaCorrente extends Conta implements Tributaveis{

    private double chequeEspecial = 200;

    public ContaCorrente(int numero, double saldo, String cPF, String nome, LocalDateTime dataAbertura,
            double chequeEspecial) {
        super(numero, saldo, cPF, nome, dataAbertura);
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
        return this.getSaldo()*0.01;
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




@Override
public void mostrarDados() {
    
}




public double getChequeEspecial() {
    return chequeEspecial;
}




public void setChequeEspecial(double chequeEspecial) {
    this.chequeEspecial = chequeEspecial;
}




@Override
public void configurarConta(String nome, String CPF) {
    this.setDataDeAbertura(LocalDateTime.now());
    this.setCPF(CPF);
    this.setNome(nome);
    this.setChequeEspecial(chequeEspecial);
    

    
}
    
    
}
