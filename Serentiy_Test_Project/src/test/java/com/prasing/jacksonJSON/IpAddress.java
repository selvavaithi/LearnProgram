package com.prasing.jacksonJSON;

public class IpAddress
{
    private String ServerIp;

    private String ClientIp;

    public String getServerIp ()
    {
        return ServerIp;
    }

    public void setServerIp (String ServerIp)
    {
        this.ServerIp = ServerIp;
    }

    public String getClientIp ()
    {
        return ClientIp;
    }

    public void setClientIp (String ClientIp)
    {
        this.ClientIp = ClientIp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ServerIp = "+ServerIp+", ClientIp = "+ClientIp+"]";
    }
}
