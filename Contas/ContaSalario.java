package Contas;

import java.util.Random;

import exceptions.Data;

public class ContaSalario extends Conta implements Tributaveis {

private int limiteDeSaques;

public ContaSalario(Random numero, double saldo, String cPF, String nome, Data dataDeAbertura,
        int limiteDeSaques) {
    super(numero, saldo, cPF, nome, dataDeAbertura);
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
    
}
