package cn.mljia.ddddemo.application.representation;

import java.io.Serializable;

import cn.mljia.ddddemo.domain.UserAccount;
import cn.mljia.ddddemo.exception.NegativeCode;
import cn.mljia.ddddemo.exception.NegativeException;

public class UserInfoRepresentation implements Serializable
{
    
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;
    
    private String accountId;
    
    private String userName;
    
    private Integer age;
    
    public UserInfoRepresentation(UserAccount userAccount)
        throws NegativeException
    {
        super();
        initializeFrom(userAccount);
    }
    
    private void initializeFrom(UserAccount userAccount)
        throws NegativeException
    {
        
        try
        {
            this.accountId = userAccount.accountId();
            this.age = userAccount.age();
            this.userName = userAccount.userName();
        }
        catch (Exception e)
        {
            throw new NegativeException(NegativeCode.LOGIN_USERINFO_INIT_ERROR,
                "initializeFrom user account info is Exception", e);
        }
        
    }
    
    @Override
    public String toString()
    {
        return "UserInfoRepresentation [accountId=" + accountId + ", userName=" + userName + ", age=" + age + "]";
    }
    
}
