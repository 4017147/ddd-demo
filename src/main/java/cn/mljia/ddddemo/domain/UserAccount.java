package cn.mljia.ddddemo.domain;

import java.util.Date;

import cn.mljia.ddd.common.domain.model.ConcurrencySafeEntity;
import cn.mljia.ddd.common.domain.model.DomainEventPublisher;
import cn.mljia.ddddemo.exception.NegativeCode;
import cn.mljia.ddddemo.exception.NegativeException;

/**
 * 
 * @ClassName: UserAccount
 * @Description: TODO 账户
 * @author: Administrator
 * @date: 2017年2月14日 上午9:45:59
 */
public class UserAccount extends ConcurrencySafeEntity
{
    
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;
    
    private String accountId; // ID
    
    private String userName;// 用户名
    
    private Integer age;// 年龄
    
    private String password;// 密码
    
    private Date createTime;// 创建时间
    
    private Date modifyTime;// 修改时间
    
    private Integer loginNum;// 登录次数
    
    private Address address;//地址
    
    
    
    public Address address()
    {
        return address;
    }

    private void setAddress(Address address)
    {
        this.address = address;
    }

    public UserAccount()
    {
        super();
    }
    
    public void register(String accountId, String userName, Integer age, String password,String province, String city, String area)
    {
        this.setAccountId(accountId);
        this.setUserName(userName);
        this.setAge(age);
        this.setPassword(password);
        this.setCreateTime(new Date());
        this.setModifyTime(new Date());
        this.setLoginNum(0);
        this.setAddress(new Address(province, city, area));
        DomainEventPublisher
        .instance()
        .publish(new UserAccountCreatedEvent(this.userName, this.accountId));
        
    }
    
    public UserAccount login(String password, String userName)
        throws NegativeException
    {
        assertArgumentNotEmpty(userName, "login userName is not be empty.");
        assertArgumentNotEmpty(password, "login password is not be empty.");
        
        if (!this.userName.equals(userName))
        {
            throw new NegativeException(NegativeCode.LOGIN_USERNAME_ERROR, "用户登录账户不存在.");
        }
        
        if (!this.password.equals(password))
        {
            throw new NegativeException(NegativeCode.LOGIN_PASSWORD_ERROR, "用户登录密码错误.");
        }
        
        DomainEventPublisher
        .instance()
        .publish(new UserAccountLoginEvent(this.userName, this.accountId));
        
        return this;
        
    }
    
    
    public void statistics(){
    	synchronized (this) {
			this.loginNum++;
		}
    	this.modifyTime =new Date();
    }
    
    
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    public String accountId()
    {
        return accountId;
    }
    
    public String userName()
    {
        return userName;
    }
    
    public Integer age()
    {
        return age;
    }
    
    public String password()
    {
        return password;
    }
    
    public Date createTime()
    {
        return createTime;
    }
    
    public Date modifyTime()
    {
        return modifyTime;
    }
    
    public Integer loginNum()
    {
        return loginNum;
    }
    
    private void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }
    
    private void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    private void setAge(Integer age)
    {
        this.age = age;
    }
    
    private void setPassword(String password)
    {
        this.password = password;
    }
    
    private void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    private void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }
    
    private void setLoginNum(Integer loginNum)
    {
        this.loginNum = loginNum;
    }
    
}
