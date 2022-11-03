
public class Main {

	public static void main(String[] args) {
		Conta cc = new ContaCorrente(new Cliente("Cliente Teste Conta Corrente"));
		cc.depositar(150);
		cc.pagarBoleto(200);

		System.out.println("=-=-=-==-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=");

		Conta poupanca = new ContaPoupanca(new Cliente("Cliente Teste Conta Poupança"));
		cc.transferir(100, poupanca);
		poupanca.sacar(25);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}
}
