package Contas;

public abstract class Conta {

    private int numero;
    protected double saldo;
    private String CPF;
    private String nome;
    
    public Conta(int numero, double saldo, String cPF, String nome) {
        this.numero = numero;
        this.saldo = saldo;
        CPF = cPF;
        this.nome = nome;
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
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public abstract double getSaldo();

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
    
    
}
