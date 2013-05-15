package rest;

import org.jivesoftware.smack.XMPPException;

public interface IConnManager {
	public void Init()throws XMPPException;
	public void Connect(String user,String pass)throws XMPPException;
	public void Disconnect(String user);
	public void Destroy();
	public java.util.List<String> GetMessages();
	public String GetSelfName();
	public void SendMessage(String name,String message);
	public void GetMessage(String from,String mess);
}
