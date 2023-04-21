package chat_thread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;

	public Client(Socket s) {
		
		try {
			this.clientSocket = s;
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			receive();
		} catch (Exception e) {
		}
		
	}

	public void receive() {
		Runnable thread = new Runnable() {
			public void run() {
				try {
					while (true) {
						String recvData = dataInputStream.readUTF();
						System.out.println("[메세지수신 성공]"  + 
								clientSocket.getRemoteSocketAddress() + ": " + 
										 Thread.currentThread().getName());
						for (Client client : Server.clientList) {
							client.send(Thread.currentThread().getName() + ":" + recvData);
						}
					}
				} catch (Exception e) {}
			}
		};
		Server.threadPool.submit(thread);
	}

	public void send(String message) {
		Runnable thread = new Runnable() {
			public void run(){
				try {
					dataOutputStream.writeUTF(message);
				}catch(Exception e) {}
			}
		};
		Server.threadPool.submit(thread);				
	}
}
