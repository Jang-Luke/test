package quiz03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import quiz02.Manager;

public class Server {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(25000);
		System.out.println("서버 가동");
		Socket socket = server.accept();
		System.out.println("클라 접속");

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		int id;
		String name, phone;
		int menu;
		Managers managers = Managers.getInstance();
		while(true) {
			menu = dis.readInt();
			if(menu == 1) {
				while(true) {
					id = dis.readInt();
					if(managers.checkID(id) == 1) {dos.writeInt(1); break;} else {dos.writeInt(-1); continue;}
				}
				name = dis.readUTF();
				phone = dis.readUTF();
				managers.addContact(new Contact(id,name,phone));
				dos.writeUTF("ack");
			} else if (menu == 2) {
				int size = managers.getSize();
				dos.writeInt(size);
				for (String s : managers.getConracts(managers.getAll())) {
					dos.writeUTF(s);
				}
			} else if (menu ==3) {
				String searchName = dis.readUTF();
				int size = managers.searchByName(searchName).size();
				dos.writeInt(size);
				for (String s : managers.getConracts(managers.searchByName(searchName))) {
					dos.writeUTF(s);
				}
			} else if (menu == 4) {
				id = dis.readInt();
				if (managers.removeByID(id)) {
					dos.writeUTF("ack");
				} else {dos.writeUTF("");}
			}
		}
	}
}
