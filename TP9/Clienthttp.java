import java.io.*;
import java.net.*;

public class Clienthttp {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Saisir une URL");
			return;
		}
		
		try {
			Socket socket = new Socket(args[0], 80);
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			InputStreamReader isw = new InputStreamReader(socket.getInputStream());

			BufferedWriter bufOut = new BufferedWriter(osw);
			BufferedReader bufIn = new BufferedReader(isw);

			String request = "GET / HTTP/1.1\r\n";
			request+= "Host: " + args[0] + "\r\n";
			request+= "Connection: close\r\n";
			request+= "\r\n";

			bufOut.write(request, 0, request.length());
			bufOut.flush();

			String line = bufIn.readLine();
			while (line != null ) {
				System.out.println(line);
				line = bufIn.readLine();
			}
			bufIn.close();
			bufOut.close();
			socket.close();
		}
		catch(Exception ex){
			System.out.println("erreur I/O");
			ex.printStackTrace();
		}
	}
}
