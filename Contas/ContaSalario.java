package Contas;

import java.time.LocalDateTime;

public class ContaSalario extends Conta implements Tributaveis {

private int limiteDeSaques;

public ContaSalario(int numero, double saldo, String cPF, String nome, LocalDateTime dataDeAbertura,
        int limiteDeSaques) {
    super(numero, saldo, cPF, nome, dataDeAbertura);
    this.limiteDeSaques = limiteDeSaques;
}

@Override
public double getValorImposto() {
    // TODO Auto-generated method stub
    return 0;
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
    
}
