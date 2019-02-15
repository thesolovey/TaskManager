package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session")
@NamedQuery(name = "Session.getAll", query = "SELECT c FROM Session c")
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
