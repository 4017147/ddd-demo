package cn.mljia.ddddemo.domain;

import cn.mljia.ddd.common.domain.model.ValueObject;

/**
 * 
 * @ClassName: Address
 * @Description: TODO
 * @author: Administrator
 * @date: 2017年2月14日 上午11:41:38
 */
public class Address extends ValueObject
{
    
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;
    
    private String province;
    
    private String city;
    
    private String area;
    
    public Address(String province, String city, String area)
    {
        super();
        this.setArea(area);
        this.setCity(city);
        this.setProvince(province);
    }
    
    public Address()
    {
        super();
    }
    
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    public String province()
    {
        return province;
    }
    
    public String city()
    {
        return city;
    }
    
    public String area()
    {
        return area;
    }
    
    private void setProvince(String province)
    {
        assertArgumentNotNull(province, "province not be null.");
        this.province = province;
    }
    
    private void setCity(String city)
    {
        assertArgumentNotNull(city, "city not be null.");
        this.city = city;
    }
    
    private void setArea(String area)
    {
        assertArgumentNotNull(area, "area not be null.");
        this.area = area;
    }
    
}
