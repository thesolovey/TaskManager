package entity;

import java.util.Date;


public class Session {
    private String userId;
    private String signature;
    private Date startValidPeriod;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getSignature() { return signature; }

    public void setSignature(String signature) { this.signature = signature; }

    public Date getStartValidPeriod() { return startValidPeriod; }

    public void setStartValidPeriod(Date startValidPeriod) { this.startValidPeriod = startValidPeriod; }
}
