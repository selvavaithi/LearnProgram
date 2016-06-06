package com.prasing.jacksonJSON;

public class JSON_jackson {

	private Source Source;

	private String GlobalMemberToken;

	private String Password;

	private Application Application;

	private IpAddress IpAddress;

	private Client Client;

	public Source getSource() {
		return Source;
	}

	public void setSource(Source Source) {
		this.Source = Source;
	}

	public String getGlobalMemberToken() {
		return GlobalMemberToken;
	}

	public void setGlobalMemberToken(String GlobalMemberToken) {
		this.GlobalMemberToken = GlobalMemberToken;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public Application getApplication() {
		return Application;
	}

	public void setApplication(Application Application) {
		this.Application = Application;
	}

	public IpAddress getIpAddress() {
		return IpAddress;
	}

	public void setIpAddress(IpAddress IpAddress) {
		this.IpAddress = IpAddress;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client Client) {
		this.Client = Client;
	}

	@Override
	public String toString() {
		return "ClassPojo [Source = " + Source + ", GlobalMemberToken = " + GlobalMemberToken + ", Password = "
				+ Password + ", Application = " + Application + ", IpAddress = " + IpAddress + ", Client = " + Client
				+ "]";
	}

}
