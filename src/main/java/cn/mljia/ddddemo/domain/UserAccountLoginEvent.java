package cn.mljia.ddddemo.domain;

import java.util.Date;

import cn.mljia.ddd.common.domain.model.DomainEvent;

public class UserAccountLoginEvent implements DomainEvent
{
    private String accountId;
    
    private String userName;
    
    private Date occurredOn;
    
    private int eventVersion;
    
    public UserAccountLoginEvent(String userName, String accountId)
    {
        super();
        this.userName = userName;
        this.accountId = accountId;
        this.occurredOn = new Date();
        this.eventVersion = 1;
    }
    
    @Override
    public int eventVersion()
    {
        return this.eventVersion;
    }
    
    @Override
    public Date occurredOn()
    {
        return this.occurredOn;
    }
    
    @Override
    public String toString()
    {
        return "UserAccountCreatedEvent [accountId=" + accountId + ", userName=" + userName + ", occurredOn="
            + occurredOn + ", eventVersion=" + eventVersion + "]";
    }
    
}
