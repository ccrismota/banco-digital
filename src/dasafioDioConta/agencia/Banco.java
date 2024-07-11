package dasafioDioConta.agencia;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banco {
	
	private String nome;
	private List<Conta> contas = new ArrayList<>();
			
	public void listarClientes() {
		System.out.println("=== Clientes do " +this.nome+" ===");
		for(Conta conta : contas) {
			Cliente cliente = conta.getCliente();
			System.out.println(cliente.getNome());
		}
	}
	
}
