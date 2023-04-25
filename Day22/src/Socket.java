import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Socket {
	private ServerSocket mServerSocket;
	private Socket mSocket;
	
	private BufferedReader mIn;
	private PrintWriter mOut;
	
	public Socket() {
		try {
			mServerSocket = new ServerSocket(5555);
			
			
			mSocket = m.ServerSoc
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}

















