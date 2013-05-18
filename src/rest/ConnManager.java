package rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

public class ConnManager implements IConnManager {
	
	private String login=null;
	private String password=null;
	private final static String serverName="afaneor-comp";
	private java.util.List<String> sessionMessage=new ArrayList<String>();
	private java.util.List<String> users=new ArrayList<String>();

	public Connection connection=null;
	
	public ConnManager(){
//		sessionMessage.add("first");
	}

	@Override
	public void Init() throws XMPPException {
		connection = new XMPPConnection("localhost");
	}

	@Override
	public void LoginUser(String user, String pass) throws XMPPException {
		if (connection==null) {
			try {
				this.Init();
			} catch (XMPPException e) {
				throw e;
			}
		}
		//if (connection.isAuthenticated() == true) return;

			this.login=user;
			this.password=pass;
			connection.connect();
			connection.login(user+"@afaneor-comp", pass);
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
	public void GetMessage(String from,String mess){
		this.sessionMessage.add("recive from:`"+from+"` message:"+mess);
	}
	@Override
	public void LogoffUser() {
		if (connection == null) return;
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

	@Override
	public List<String> GetUsers() {
		if (connection == null) return users;
		Roster roster = connection.getRoster();
		Collection<RosterEntry> entries = roster.getEntries();
		users=new ArrayList<String>();
		for (RosterEntry entry : entries) {
			users.add(entry.getUser());
		    System.out.println(entry);
		}
		return users;
	}

	@Override
	public void DeleteHistory() {
		sessionMessage=new ArrayList<String>();
	}

	@Override
	public boolean IsConnect() {
		if (connection == null) return false;
		if (connection.isAuthenticated()==false) return false;
		return true;//connection.isConnected();
	}

}
