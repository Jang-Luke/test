package exan02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) throws Exception {
		int portnumber = 111111;
		Socket client = new Socket("IP 주소", portnumber);
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		while(true) {
			dos.writeUTF(JOptionPane.showInputDialog("서버에게 보낼 메세지"));
			dos.flush();
			
			JOptionPane.showMessageDialog(null, dis.readUTF());
		}
		
		
	}

}
