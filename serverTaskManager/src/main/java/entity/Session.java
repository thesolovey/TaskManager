package entity;

import java.util.Date;

public class Session {
    private String userId;
    private String signature;
    private Date validPeriod = new Date();

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getSignature() { return signature; }

    public void setSignature(String signature) { this.signature = signature; }

    public Date getValidPeriod() { return validPeriod; }

    public void setValidPeriod(Date validPeriod) { this.validPeriod = validPeriod; }
}
