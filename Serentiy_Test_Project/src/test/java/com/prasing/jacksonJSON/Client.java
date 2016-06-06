package com.prasing.jacksonJSON;

public class Client
{
    private String UserAgentId;

    private String DeviceType;

    public String getUserAgentId ()
    {
        return UserAgentId;
    }

    public void setUserAgentId (String UserAgentId)
    {
        this.UserAgentId = UserAgentId;
    }

    public String getDeviceType ()
    {
        return DeviceType;
    }

    public void setDeviceType (String DeviceType)
    {
        this.DeviceType = DeviceType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [UserAgentId = "+UserAgentId+", DeviceType = "+DeviceType+"]";
    }
}