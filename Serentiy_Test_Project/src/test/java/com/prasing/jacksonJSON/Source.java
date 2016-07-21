package com.prasing.jacksonJSON;

public class Source {

	private String TrackingToken;
	private String OriginatingUrl;
	private String ForeignSource;
	private String MediaChannel;
	private String SourceCode;
	private String EmailSubCode;

	public String getTrackingToken() {
		return TrackingToken;
	}

	public void setTrackingToken(String TrackingToken) {
		this.TrackingToken = TrackingToken;
	}

	public String getOriginatingUrl() {
		return OriginatingUrl;
	}

	public void setOriginatingUrl(String OriginatingUrl) {
		this.OriginatingUrl = OriginatingUrl;
	}

	public String getForeignSource() {
		return ForeignSource;
	}

	public void setForeignSource(String ForeignSource) {
		this.ForeignSource = ForeignSource;
	}

	public String getMediaChannel() {
		return MediaChannel;
	}

	public void setMediaChannel(String MediaChannel) {
		this.MediaChannel = MediaChannel;
	}

	public String getSourceCode() {
		return SourceCode;
	}

	public void setSourceCode(String SourceCode) {
		this.SourceCode = SourceCode;
	}

	public String getEmailSubCode() {
		return EmailSubCode;
	}

	public void setEmailSubCode(String EmailSubCode) {
		this.EmailSubCode = EmailSubCode;
	}

	@Override
	public String toString() {
		return "ClassPojo [TrackingToken = " + TrackingToken + ", OriginatingUrl = " + OriginatingUrl
				+ ", ForeignSource = " + ForeignSource + ", MediaChannel = " + MediaChannel + ", SourceCode = "
				+ SourceCode + ", EmailSubCode = " + EmailSubCode + "]";
	}
}
