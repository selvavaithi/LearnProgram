package com.jacksonjson.test;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "TrackingToken", "SourceCode", "ForeignSource", "OriginatingUrl", "MediaChannel", "EmailSubCode" })
public class SourceDto {
	String TrackingToken;
	String SourceCode;
	String ForeignSource;
	String OriginatingUrl;
	String MediaChannel;
	String EmailSubCode;

	public String getTrackingToken() {
		return TrackingToken;
	}

	public void setTrackingToken(String trackingToken) {
		TrackingToken = trackingToken;
	}

	public String getSourceCode() {
		return SourceCode;
	}

	public void setSourceCode(String sourceCode) {
		SourceCode = sourceCode;
	}

	public String getForeignSource() {
		return ForeignSource;
	}

	public void setForeignSource(String foreignSource) {
		ForeignSource = foreignSource;
	}

	public String getOriginatingUrl() {
		return OriginatingUrl;
	}

	public void setOriginatingUrl(String originatingUrl) {
		OriginatingUrl = originatingUrl;
	}

	public String getMediaChannel() {
		return MediaChannel;
	}

	public void setMediaChannel(String mediaChannel) {
		MediaChannel = mediaChannel;
	}

	public String getEmailSubCode() {
		return EmailSubCode;
	}

	public void setEmailSubCode(String emailSubCode) {
		EmailSubCode = emailSubCode;
	}

}
