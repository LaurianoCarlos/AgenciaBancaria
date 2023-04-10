package Programa;

import java.util.ArrayList;
import java.util.Scanner;

class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();
		operacoes();

	}

	public static void operacoes() {
		System.out.println();
		System.out.println("AGÊNCIA BANCARIA");
		System.out.println("[1] Criar Conta");
		System.out.println("[2] Depositar");
		System.out.println("[3] Sacar");
		System.out.println("[4] Transferir");
		System.out.println("[5] Listar");
		System.out.println("[0] Sair");

		System.out.print("Opcao: ");
		int opcao = input.nextInt();

		switch (opcao) {

		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 0:
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
		input.nextLine();
		String nome = input.nextLine();

		System.out.println("Insira seu cpf: ");
		String cpf = input.nextLine();

		System.out.println("Insira seu email: ");
		String email = input.nextLine();

		Pessoa pessoa = new Pessoa(nome, cpf, email);
		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);

		System.out.println("Conta criada com Sucesso");
		
		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;

		if (contasBancarias.size() > 0) {
			for (Conta contaVerificar : contasBancarias) {
				if (contaVerificar.getNumeroConta() == numeroConta) {
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

		if (conta != null) {
			System.out.println("Insira Valor para deposito");
			double valorDeposito = input.nextDouble();

			conta.depositar(valorDeposito);
		
		} else {
			System.out.println("Conta não encontrada");
		}
		
		operacoes();
	}

	public static void sacar() {
		System.out.println("Insira numero da Conta: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Insira Valor para saque");
			double valorSaque = input.nextDouble();

			conta.sacar(valorSaque);
		
		} else {
			System.out.println("Conta não encontrada");
		}
		
		operacoes();
	}

	public static void transferir() {
		System.out.println("Insira numero da conta do remetente: ");
		int numeroContaRemetente = input.nextInt();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			System.out.println("Inisra numero da conta do destinatario: ");
			int numeroContaDestinatario = input.nextInt();

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

			if (contaDestinatario != null) {
				System.out.println("Insira valor da transferencia:");
				double valorTransferencia = input.nextDouble();

				contaRemetente.transferir(contaDestinatario, valorTransferencia);

			}
		}
		operacoes();
	}
	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		}else {
			System.out.println("Não possui contas cadastradas");
		}
		operacoes();
	}
}