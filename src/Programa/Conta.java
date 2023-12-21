package Programa;

import Utilitarios.Utils;

public class Conta {

	private static int contadorDeContas = 0;
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;
	
	public Conta(Pessoa pessoa) {
		this.pessoa = pessoa;
		setNumeroConta(Pessoa.getContadorDePessoas());
		this.numeroConta = getNumeroConta() + 1000;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public static int getContadorDeContas() {
		return contadorDeContas;
	}

	public static void setContadorDeContas(int contadorDeContas) {
		Conta.contadorDeContas = contadorDeContas;
	}
	
	public String toString() {
		return "Número da Conta: " + this.getNumeroConta() 
		+ "\nNome: " + this.pessoa.getNome()
		+ "\nCpf: " + this.pessoa.getCpf()
		+ "\nEmail: " + this.pessoa.getEmail()
		+ "\nSaldo: " + Utils.doubleParaString(this.getSaldo()) + "\n";
	}
	
	public void depositar(double valor) {
		if(valor > 0 ) {
			setSaldo(getSaldo() + valor);
			System.out.println("Deposito realizado com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar a operação");
		}
	}
	
	public void sacar(double valor) {
		if(valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar a operação");
		}
	}

	public void transferir(Conta contaParaDeposito, double valor) {
		if(valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
			
			System.out.println("Transferência realizada com sucesso!");
			
		}else {
			System.out.println("Não foi possivel realizar a operação");
		}
	}
}
