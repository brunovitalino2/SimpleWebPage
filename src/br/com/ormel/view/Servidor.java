package br.com.ormel.view;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void handlePackets() throws Exception {
	    String pacoteCliente;
	    String pacoteServidor;
	    ServerSocket socketInit = new ServerSocket(1337);

	         System.out.println("Packet receiver initialized!");
//	         while (run) {
	         for(;;) {
	            Socket connectionSocket = socketInit.accept();
	            BufferedReader entrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	            DataOutputStream saida = new DataOutputStream(connectionSocket.getOutputStream());
	            pacoteCliente = entrada.readLine();
	            System.out.println("Received Packet: " + pacoteCliente);


	            System.out.println("Compiling return to client.");
	            pacoteServidor = "";
//	            if (pacoteCliente.startsWith("Handshake-")) {
//	                pacoteServidor = handleHandShake(pacoteCliente);
//	            }

	            saida.writeBytes(pacoteServidor);
	            System.out.println("Sent client response " + pacoteServidor);
	         }
//	         socketInit.close();
	  }
	
}
