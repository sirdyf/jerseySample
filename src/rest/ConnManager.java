package rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

public class ConnManager implements IConnManager {
	
//	private Map<String, String> sessions = new HashMap<String, String>();
	private String login=null;
	private String password=null;
	private final static String serverName="afaneor-comp";
//	private Map<String, String> sessionMessage = new HashMap<String, String>();
	private java.util.List<String> sessionMessage=new ArrayList<String>();

	public Connection connection=null;
	
	public ConnManager(){
//		sessionMessage.add("first");
//		sessionMessage.add("two");
//		sessionMessage.add("last");
	}

	@Override
	public void Init() throws XMPPException {
		connection = new XMPPConnection("localhost");
	}

	@Override
	public void Connect(String user, String pass) throws XMPPException {
		if (connection.isConnected() == false){
			this.login=user;
			this.password=pass;
			connection.connect();
			connection.login("test@afaneor-comp", "123");
			// Assume we've created a Connection name "connection".
			ChatManager chatmanager = connection.getChatManager();
			chatmanager.addChatListener(
			    new ChatManagerListener() {
			        @Override
			        public void chatCreated(Chat chat, boolean createdLocally)
			        {
			            if (!createdLocally)
			                chat.addMessageListener(new MessageListener(){
		
			            	    public void processMessage(Chat chat, Message message) {
			            	        System.out.println("Received message: " + message + (message != null ? message.getBody() : "NULL"));
			        				ServletContextClass.myManager.GetMessage(message.getFrom(), message.getBody());
			            	    }
			                });
			        }
			    });
		}
	}
	public void GetMessage(String from,String mess){
		this.sessionMessage.add("recive from:`"+from+"` message:"+mess);
	}
	@Override
	public void Disconnect(String user) {
		if (connection.isConnected() == true){
			connection.disconnect();
		}
	}

	@Override
	public void Destroy() {
		if (connection.isConnected() == true){
			connection.disconnect();
		}
	}

	@Override
	public List<String> GetMessages() {
		return sessionMessage;
	}

	@Override
	public String GetSelfName() {
		
		return this.login;
	}

	@Override
	public void SendMessage(String name, String message) {
		if (connection == null) return;
		if (connection.isConnected() == true){
		
			Chat chat = connection.getChatManager().createChat(name+"@"+serverName, new MessageListener() {
	
			    public void processMessage(Chat chat, Message message) {
			        System.out.println("Received message: " + message );
			        System.out.println("message body:"+message != null ? message.getBody() : "NULL");
			    }
			});
			try {
				chat.sendMessage(message);
				this.sessionMessage.add("send to:`"+name+"` message:"+message);
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
