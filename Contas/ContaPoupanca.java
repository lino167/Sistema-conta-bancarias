package Contas;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class ContaPoupanca extends ContaBancaria{

    private double taxaDeJuros = 2.0;
    private int diaAniversario = 10;
    
    public ContaPoupanca(int numero, double saldo, String cPF, String nome, LocalDateTime dataAbertura,
        double taxaDeJuros, int diaAniversario) {
        super(numero, saldo, cPF, nome, dataAbertura);
        this.taxaDeJuros = taxaDeJuros;
        this.diaAniversario = diaAniversario;
    }
    

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }


    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }


    public int getDiaAniversario() {
        return diaAniversario;
    }


    public void setDiaAniversario(int diaAniversario) {
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        System.out.println("***Conta Poupanca***");
        System.out.println("Cliente: " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Numero da Conta: " + this.getNumero());
        System.out.println("Data de Cadastro: " + dtf.format(this.getDataDeAbertura()));
        System.out.println("Saldo: R$" + this.getSaldo());
        System.out.println("Taxa de juros: R$ " + this.getTaxaDeJuros());
        System.out.println();
    }


    @Override
    public void configurarConta(String nome, String CPF) {
        this.setDataDeAbertura(LocalDateTime.now());
        this.setCPF(CPF);
        this.setNome(nome);
        
    }


    @Override
    public int compareTo(ContaBancaria o) {
        return this.getNome().compareTo(o.getNome());
    }
   
    
   
}
