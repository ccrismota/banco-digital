package dasafioDioConta.agencia;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;

	protected Banco banco;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	List<String> historicoDeOperacoes = new ArrayList<String>();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public Conta(Cliente cliente, Banco banco) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.banco = banco;
		banco.getContas().add(this);
	}

	public void sacar(double valor) {
		if (valor > this.saldo) {
			System.out.println("Saldo insuficiente");
			return;
		}
		this.saldo -= valor;
		historicoDeOperacoes.add("Saque de R$ " + valor + " Realizado em: " + java.time.LocalDateTime.now().format(formatter));
	}

	public void depositar(double valor) {
		this.saldo += valor;
		historicoDeOperacoes.add("Depósito de R$ "+ valor + " Realizado em: " + java.time.LocalDateTime.now().format(formatter));
	}

	public void transferir(double valor, Conta contaDestino) {
		if (valor > this.saldo) {
			System.out.println("Saldo insuficiente");
			return;
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
		historicoDeOperacoes.add("\n"
        + "Transferência de R$ " + valor +"\n"
        + "\t" + " Para: "+ contaDestino.cliente.getNome() +"\n"
        + "\t" + " Agencia: "+ contaDestino.banco.getNome() +"\n"
        + "\t" + " Agencia: "+ contaDestino.getAgencia() +"\n"
        + "\t" + " Conta: "+ contaDestino.getNumero() +"\n"
		+ "\t" + " Realizada em: " + java.time.LocalDateTime.now().format(formatter) +"\n");
	}

	protected void imprimirInfoComuns() {
		System.out.println(String.format("=== Banco: %s", this.banco.getNome()));
		System.out.println(String.format("=== Agendia: %d", this.agencia));
		System.out.println(String.format("=== Numero: %d", this.numero));
		System.out.println(String.format("=== Saldo: %.2f", this.saldo));
		System.out.println(String.format("=== Cliente: %s", this.cliente.getNome()));
	}

}
