package cn.mljia.ddddemo.application.command;

import java.io.Serializable;

import cn.mljia.ddd.common.AssertionConcern;

public class LoginCommand extends AssertionConcern implements Serializable 
{
    
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;
    
    private String userName;
    
    private String password;
    
    public LoginCommand(String userName, String password)
    {
        super();
        assertArgumentNotNull(userName, "login userName is not be null.");
        assertArgumentNotNull(password, "login password is not be null.");
        this.userName = userName;
        this.password = password;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public String toString()
    {
        return "LoginCommand [userName=" + userName + ", password=" + password + "]";
    }
    
}
