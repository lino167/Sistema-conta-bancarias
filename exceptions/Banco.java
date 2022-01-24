package exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaPoupanca;
import Contas.ContaSalario;

public class Banco {

    
    private static Scanner ler;
    private String nomeBanco;
    private ArrayList <Conta> banco = new ArrayList<>();
    
    

    public Banco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }

    public String getNomeBanco(){
        return nomeBanco;
    }

    public ArrayList<Conta> getBanco() {
        return banco;
    }

    public Conta criarConta(String nome, String CPF) {
        ler = new Scanner(System.in);
        Random random;
        int numero, opcao;
        Conta auxiliar, conta;
        LocalDateTime dataAtual = LocalDateTime.now();

        if(!this.validarCliente(nome, CPF)){
            System.out.println("Cliente ja possui cadastro com outros dados");
            return null;
        }
        random = new Random();
        numero = random.nextInt(10000)+1;
        auxiliar = this.procurarConta(numero);
        while(auxiliar != null){
            numero = random.nextInt(10000)+1;
            auxiliar = this.procurarConta(numero);
        }

        do {
            System.out.println("0- Voltar ao Menu Principal");
            System.out.println("1- Conta Corrente");
            System.out.println("2- Conta Poupanca");
            System.out.println("3- Conta Salário");
            try (Scanner scanner = new Scanner(System.in)) {
            }
            System.out.print("Digite a opção desejada: ");
            opcao = ler.nextInt();

            if(opcao == 1){
                conta = new ContaCorrente(numero,0, CPF, nome, dataAtual, 100);
                break;
            }else if(opcao == 2){
                conta = new ContaPoupanca(numero, 0, CPF, nome, dataAtual, 1.5, 10);
                break;
            }else{
                conta = new ContaSalario(numero, 0, CPF, nome, dataAtual, 3);
                break;
            }
            

        }while(opcao != 1 && opcao != 2);

        this.inserir(conta);
        return conta;
    }

   
    public boolean validarCliente(String nome, String CPF){
        for(Conta conta : banco){
            if(conta.getCPF().equals(CPF)) {
                if(!conta.getNome().equals(nome)){
                    return false;
                }
                return true;
            }
        }
        return true;
    }
    public boolean inserir(Conta conta){
        if(!this.getBanco().contains(conta)){
            this.getBanco().add(conta);
            System.out.println("Conta cadastrada com sucesso!");
            System.out.println();
            return true;
        }
        System.out.println("Conta já cadastrada");
        System.out.println();
        return false;
    }


    public Conta procurarConta(int numero){
        for(Conta conta : banco){
            if(conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
    }


    public void mostrarDados(){
        System.out.println(" -----------------------------------");
        System.out.println("| ***Clientes do Banco " + this.getNomeBanco() + "*** |  ");
        System.out.println(" -----------------------------------");

        for(Conta x : banco){
            x.mostrarDados();
            System.out.println();
        }
        for (Conta m : banco) {
            m.getSaldo();
            System.out.println();  
     }
    }

	public void getSaldo() {
	}


}
