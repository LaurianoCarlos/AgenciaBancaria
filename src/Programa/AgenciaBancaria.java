package Programa;

import java.util.ArrayList;
import java.util.Scanner;

class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();

	}

	public static void operacoes() {
		System.out.println("AGÊNCIA BANCARIA");
		System.out.println("[1] Criar Conta");
		System.out.println("[2] Depositar");
		System.out.println("[3] Sacar");
		System.out.println("[4] Transferir");
		System.out.println("[5] Listar");
		System.out.println("[0] Sair");
		
		
		int opcao = input.nextInt();
		
		switch(opcao) {
		 
		case 1:
			criarConta();
			break;
		case 2;
		depositar();
		break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break; 
		case 6:
			System.out.println("Obrigado por usar o BANCO BGS");
			System.exit(0);
			default:
				System.out.println("Opção Inválida");
				operacoes();
				break;
		}
	}

	public static void criarConta() {
		System.out.println("Insira seu nome: ");
		String nome = input.nextLine();

		System.out.println("Insira seu cpf: ");
		String cpf = input.nextLine();

		System.out.println("Insira seu email: ");
		String email = input.nextLine();

		Pessoa pessoa = new Pessoa(nome, cpf, email);
		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);

		System.out.println("Conta criada com Sucesso");
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		
		if(contasBancarias.size() > 0) {
		for(Conta contaVerificar : contasBancarias) {
				if(contaVerificar.getNumeroConta() == numeroConta) {
				conta = contaVerificar;
			}
	} 
	}
		return conta;
  }
	public static void depositar() {
		System.out.println("Insira numero da Conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Insira Valor para deposito");
			double valorDeposito = input.nextDouble();
			
			conta.depositar(valorDeposito);
			System.out.println("Deposito realizado com sucesso!");
		}else {
			System.out.println("Conta não encontrada");
		}
	}
}