import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
		}
		System.out.println("Saldo insuficiente para saque!");
	}
	@Override
	public void depositar(double valor) {	
		this.saldo += valor;
	}
	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(this.saldo >= valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
		System.out.println("Saldo insuficiente para transferência!");
	}

	@Override
	public void imprimirExtrato() {
	}

	@Override
	public String pagarBoleto(double valor) {
		if(saldo >= valor){
			saldo -= valor;
			imprimirExtrato();
			return "Boleto pago com sucesso!";
		}
		imprimirExtrato();
		return "Não foi possível completar sua transação, Saldo Insuficiente!!";
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Tutular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
