package Contas;


import java.time.LocalDateTime;




public class ContaPoupanca extends Conta{

    private double taxaDeJuros = 2.0;
    private int diaAniversario = 10;
    
    public ContaPoupanca(int numero, double saldo, String cPF, String nome, LocalDateTime dataAbertura,
        double taxaDeJuros, int diaAniversario) {
        super(numero, saldo, cPF, nome, dataAbertura);
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


    @Override
    public void mostrarDados() {
        
    }


    @Override
    public void configurarConta(String nome, String CPF) {
        this.setDataDeAbertura(LocalDateTime.now());
        this.setCPF(CPF);
        this.setNome(nome);
        
    }
   
    
   
}
