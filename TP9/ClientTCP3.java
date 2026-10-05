import java.io.*;
import java.net.*;

public class ClientTCP3
{
	public static void main(String[] args)
	{
		try
		{
			if (args.length ==0) 
			{
				System.out.println("Erreur: Vous devez mettre un message."); 
				return; 
			}
			Socket socket = new Socket( "localhost", 2016);
			DataOutputStream dOut = new DataOutputStream( socket.getOutputStream() );
			dOut.writeUTF(args[0]);

			DataInputStream dIn = new DataInputStream(socket.getInputStream());
			String reponse = dIn.readUTF();
			System.out.println("Message inversé renvoyé par le serveur : " + reponse);

			socket.close();
		}
		catch(Exception ex)
		{
			System.out.println("erreur I/O");
			ex.printStackTrace();
		}
	}
}
