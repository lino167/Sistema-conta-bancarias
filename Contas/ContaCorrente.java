package Contas;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class ContaCorrente extends ContaBancaria implements Tributaveis{

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
  
    
}
   
@Override
public void mostrarDados(){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
    System.out.println("***Conta Corrente***");
    System.out.println("Cliente: " + this.getNome());
    System.out.println("CPF: " + this.getCPF());
    System.out.println("Numero da Conta: " + this.getNumero());
    System.out.println("Data de Cadastro: " + dtf.format(this.getDataDeAbertura()));
    System.out.println("Saldo: R$ " + this.getSaldo());
    System.out.println("Cheque especial: R$ " + this.getChequeEspecial());
    System.out.println("Imposto: R$ " + this.getValorImposto());
    System.out.println();
}
@Override
public int compareTo(ContaBancaria o) {
    return this.getNome().compareTo(o.getNome());
} 
}
