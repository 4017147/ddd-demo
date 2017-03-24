package cn.mljia.ddddemo.application.command;

import java.io.Serializable;

import cn.mljia.ddd.common.AssertionConcern;

public class RegisterCommand extends AssertionConcern implements Serializable
{
    
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;
    
    private String accountId;
    
    private String userName;
    
    private String password;
    
    private Integer age;
    
    private String province;
    
    private String city;
    
    private String area;
    
    public RegisterCommand(String accountId, String userName, String password, Integer age, String province,
        String city, String area)
    {
        super();
        assertArgumentNotNull(accountId, "register accountId is not be null.");
        assertArgumentNotNull(userName, "register userName is not be null.");
        assertArgumentNotNull(password, "register password is not be null.");
        assertArgumentNotNull(age, "register age is not be null.");
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.province = province;
        this.city = city;
        this.area = area;
    }
    
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public Integer getAge()
    {
        return age;
    }
    
    public String getAccountId()
    {
        return accountId;
    }
    
    public String getProvince()
    {
        return province;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getArea()
    {
        return area;
    }
    
    @Override
    public String toString()
    {
        return "RegisterCommand [accountId=" + accountId + ", userName=" + userName + ", password=" + password
            + ", age=" + age + ", province=" + province + ", city=" + city + ", area=" + area + "]";
    }
    
}
