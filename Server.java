package L09;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public Server() {}

    public String sayHello() {
        return "OLÁ, MUNDO!";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);

            System.err.println("SERVIDOR PRONTO");
        } catch (Exception e) {
            System.err.println("EXCEÇÃO NO SERVIDOR: " + e.toString());
            e.printStackTrace();
        }
    }
}

