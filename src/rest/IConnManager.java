package rest;

import org.jivesoftware.smack.XMPPException;

public interface IConnManager {
	public void Init()throws XMPPException;
	public void LoginUser(String user,String pass)throws XMPPException;
	public void LogoffUser();
	public void Destroy();
	public java.util.List<String> GetMessages();
	public java.util.List<String> GetUsers();
	public String GetSelfName();
	public void SendMessage(String name,String message);
	public void GetMessage(String from,String mess);
	public void DeleteHistory();
	public boolean IsConnect();

}
