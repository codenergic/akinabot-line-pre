package org.codenergic.akinabot.line.model.akinator;

import java.io.Serializable;

public class Identification implements Serializable{
	private long channel;
	private String session;
	private String signature;

	public long getChannel() {
		return channel;
	}

	public void setChannel(long channel) {
		this.channel = channel;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}

    @Override
    public String toString() {
        return "Identification{" +
                "channel=" + channel +
                ", session='" + session + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
