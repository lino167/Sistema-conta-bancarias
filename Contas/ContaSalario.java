package Contas;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class ContaSalario extends ContaBancaria implements Tributaveis {

private int limiteDeSaques = 3;

public ContaSalario(int numero, double saldo, String cPF, String nome, LocalDateTime dataAbertura,
        int limiteDeSaques) {
    super(numero, saldo, cPF, nome, dataAbertura);
    this.limiteDeSaques = limiteDeSaques;
}

@Override
public double getValorImposto() {
    return this.getSaldo()*0.01;
}

@Override
public boolean sacar(double valor) {
    if (valor > saldo) {
        return false;
    } else {
        if (this.limiteDeSaques > 0) {
            this.limiteDeSaques --;
            this.saldo -= valor;
            return true;
        } else {
           System.out.println("Limite de saques exercido");
           return false;
        }
    }
   
}


public int getLimiteDeSaques() {
    return limiteDeSaques;
}

public void setLimiteDeSaques(int limiteDeSaques) {
    this.limiteDeSaques = limiteDeSaques;
}

public double getSaldo(){
    return this.saldo;
}

@Override
public void mostrarDados() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        System.out.println("***Conta Salário***");
        System.out.println("Cliente: " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Numero da Conta: " + this.getNumero());
        System.out.println("Data de Cadastro: " + dtf.format(this.getDataDeAbertura()));
        System.out.println("Saldo: R$ " + this.getSaldo());
        System.out.println("Limite de saques: R$ " + this.getLimiteDeSaques());
        System.out.println("Imposto: R$ " + this.getValorImposto());
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
