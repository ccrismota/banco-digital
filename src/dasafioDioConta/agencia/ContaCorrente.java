package dasafioDioConta.agencia;

public class ContaCorrente extends Conta{

	public ContaCorrente(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println();
		System.out.println("=== Extrato conta Corrente ===");
		super.imprimirInfoComuns();
		for (String operacao : historicoDeOperacoes) {
            System.out.println(operacao);
        }
        System.out.println("Saldo atual: " + String.format("%.2f", saldo));
		System.out.println();
	}
	
}
