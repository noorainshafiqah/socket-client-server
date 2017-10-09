import java.io.*;
import java.net.*;

class server
{
public static void main(String argv[])throws Exception
	{
	String clientSentence;
	String capitalizedSentence;
	ServerSocket welcomeSocket = new ServerSocket(6789);

	while(true)
	{
	Socket connectionSocket = welcomeSocket.accept();

	System.out.println("Starting the Connection:");

	BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	clientSentence = inFromClient.readLine();
	System.out.println("Message from Client: " + clientSentence);

	capitalizedSentence = clientSentence.toUpperCase()+ '\n';
	outToClient.writeBytes(capitalizedSentence);
	}
	}
}
