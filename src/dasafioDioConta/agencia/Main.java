package dasafioDioConta.agencia;

public class Main {

	public static void main(String[] args) {

		Banco BBrasil = new Banco();
		Banco bradesco = new Banco();
		BBrasil.setNome("Banco do Brasil");
		bradesco.setNome("Bradesco");

		Cliente cristiano = new Cliente();
		Cliente cesar = new Cliente();
		Cliente natal = new Cliente();

		
		cristiano.setNome("Cristiano");
		cesar.setNome("Cesar");
		natal.setNome("Natal");
		
		Conta cc = new ContaCorrente(natal, BBrasil);
		Conta cp = new ContaPoupanca(cristiano, bradesco);
		Conta cc1 = new ContaCorrente(cesar, BBrasil);
			
		cc.depositar(100);
		cc1.depositar(102);
		
		cc.imprimirExtrato();
		
		cc.transferir(100, cp);
		cc.imprimirExtrato();
		cp.imprimirExtrato();
		
		
		BBrasil.listarClientes();
		bradesco.listarClientes();
	}

}
