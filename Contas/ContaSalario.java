package Contas;


import java.time.LocalDateTime;




public class ContaSalario extends Conta implements Tributaveis {

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


public double getSaldo(){
    return this.saldo;
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
