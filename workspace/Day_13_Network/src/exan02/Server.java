package exan02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws Exception {
		int portnum = 111111;
		ServerSocket server = new ServerSocket(portnum);
		Socket socket = server.accept();
		
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		while(true) {
			dos.writeUTF(JOptionPane.showInputDialog("Ŭ���̾�Ʈ���� ���� �޼���"));
			dos.flush();
			
			JOptionPane.showMessageDialog(null, dis.readUTF());
		}
	}
}
