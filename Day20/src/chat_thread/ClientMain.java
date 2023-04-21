package chat_thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private Socket socket;
	String ip = "127.0.0.1";
	int port = 19876;

	ClientMain() {
		startClient(ip, port);
	}

	public void startClient(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			receive();
			send();
		} catch (Exception e) {
		}
	}

	public void receive() {
		new Thread(new Runnable() {
			boolean isThread = true;

			@Override
			public void run() {
				while (isThread) {
					try {
						String recvData = dataInputStream.readUTF();
						if (recvData.equals("/quit"))
							isThread = false;
						else
							System.out.println("[메세지] : " + recvData);
					} catch (Exception e) {
					}
				}
			}
		}).start();

	}

	public void send(String message) {

		new Thread(new Runnable() {
			Scanner in = new Scanner(System.in);
			boolean isThread = true;

			@Override
			public void run() {
				while (isThread) {
					try {
						String sendData = in.nextLine();
						if (sendData.equals("/quit"))
							isThread = false;
						else
							dataOutputStream.writeUTF(sendData);
					} catch (Exception e) {
					}
				}
			}
		}).start();
	}
	public void send() {
		new Thread(new Runnable() {
			Scanner in = new Scanner(System.in);
			boolean isThread = true;
			@Override
			public void run() {
				while (isThread) {
					try {
						String sendData = in.nextLine();
						if (sendData.equals("/quit"))
							isThread = false;
						else
							dataOutputStream.writeUTF(sendData);
					} catch (Exception e) {
					}
				}
			}
		}).start();
	}
	public static void main(String[] args) {
		new ClientMain();
	}
}
