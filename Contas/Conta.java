package Contas;


import java.time.LocalDateTime;




public abstract class Conta {

    private int numero;
    protected double saldo;
    private String CPF;
    private String nome;
    protected LocalDateTime dataDeAbertura;
    

    public Conta(int numero, double saldo, String cPF, String nome, LocalDateTime dataAbetura) {
        this.numero = numero;
        this.saldo = saldo;
        CPF = cPF;
        this.nome = nome;
        this.dataDeAbertura = dataAbetura;
    }

    public abstract void configurarConta(String nome, String CPF);

    

    public void setDataDeAbertura(LocalDateTime dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public double getSaldo() {
        return saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public String getCPF() {
        return CPF;
    }


    public void setCPF(String cPF) {
        CPF = cPF;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDateTime getDataDeAbertura() {
        return dataDeAbertura;
    }


  


    public  boolean transferir(Conta conta, double valor){
        if(this.sacar(valor)){
            conta.depositar(valor);
            return true;
        }
        System.out.println("Nao foi possivel fazer a transferencia");
        return false;
    }

    public abstract boolean sacar(double valor);
   
    public void depositar(double valor){
        this.saldo += valor;

}

    @Override
    public String toString() {
        return "Conta [CPF=" 
        + CPF + ", dataDeAbertura=" 
        + dataDeAbertura 
        + ", nome=" 
        + nome 
        + ", numero=" 
        + numero
                
        + ", saldo=" + saldo + "]";
    }
    

    public abstract void mostrarDados();

    public double motanteBanco(){
        return getSaldo();
    }
    
}
    
    

