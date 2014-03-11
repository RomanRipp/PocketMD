package DataTransfer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer implements Runnable {
	
	private static ServerSocket servsock;
	private File myFile;
	private int port;
	
	public FileServer() {
		//Initialize port
		port = 5000;
		//Initialize stuff
		myFile = new File("input.data");
		//initialize socket
		try {
			servsock = new ServerSocket(port);
		} catch (IOException e) {
			servsock = null;
			e.printStackTrace();
		}
	}
	
	/**
	 * run listener in the separate thread
	 * This thing is listening for files.  
	 */
	@Override
	public void run() {
		// Run listener in the separate thread
		int bytesRead;
		int current = 0;
		System.out.println("The port listener started");
	    while (!Thread.currentThread().isInterrupted()) {
	    	try {
	    		Socket sock = servsock.accept();
	    		System.out.println("Connection accepted.");
	    		byte[] mybytearray = new byte[(int) myFile.length()];
	            InputStream is = sock.getInputStream();
	            FileOutputStream fos = new FileOutputStream("data/contributed/data.user"); // destination path and name of file
	            BufferedOutputStream bos = new BufferedOutputStream(fos);
	            bytesRead = is.read(mybytearray,0,mybytearray.length);
	            current = bytesRead;
	            do {
	               bytesRead =
	                  is.read(mybytearray, current, (mybytearray.length-current));
	               if(bytesRead >= 0) current += bytesRead;
	            } while(bytesRead > -1);
	            bos.write(mybytearray, 0 , current);
	            bos.flush();
	            long end = System.currentTimeMillis();
	            bos.close();
	            sock.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }
	}
	
	
	/**
	 * Starting the server
	 */
	public static void start(){
		(new Thread(new FileServer())).start();
	}
	
	/**
	 * Stopping the server
	 */
	public static void stop(){
		Thread.currentThread().interrupt();
		System.out.println("The port listener stopped");
		//TODO Close server socket
		/*try {
			servsock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
