package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "userId")
    private String userId;

    @Column(name = "signature")
    private String signature;

    @Column(name = "startValidPeriod")
    private Date startValidPeriod;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getSignature() { return signature; }

    public void setSignature(String signature) { this.signature = signature; }

    public Date getStartValidPeriod() { return startValidPeriod; }

    public void setStartValidPeriod(Date startValidPeriod) { this.startValidPeriod = startValidPeriod; }
}
