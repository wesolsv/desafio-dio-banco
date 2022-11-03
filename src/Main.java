
public class Main {

	public static void main(String[] args) {
		Conta cc = new ContaCorrente(new Cliente("NOME"));
		cc.depositar(100);
		Conta poupanca = new ContaPoupanca(new Cliente("nome"));
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}
