package L09;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("INICIANDO CLIENTE");

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            System.out.println("REGISTRO LOCALIZADO");

            Hello stub = (Hello) registry.lookup("Hello");
            System.out.println("SERVIDOR ENCONTRADO");

            String response = stub.sayHello();
            System.out.println("RESPOSTA: " + response.toUpperCase());

            int resp = stub.soma(100,1000);
            System.out.println("RESPOSTA DA SOMA: " + resp);

        } catch (Exception e) {
            System.err.println("EXCEÇÃO NO CLIENTE: " + e.toString());
            e.printStackTrace();
        }
    }
}
