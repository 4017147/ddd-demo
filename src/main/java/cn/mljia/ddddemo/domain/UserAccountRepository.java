package cn.mljia.ddddemo.domain;

import cn.mljia.ddddemo.exception.NegativeException;


/**
 * Created by Administrator on 2016/9/7.
 */
public interface UserAccountRepository {

	public void add(UserAccount userAccount) throws NegativeException;

	public void remove(UserAccount userAccount) throws NegativeException;

	public UserAccount accountOfId(String id) throws NegativeException;
	
	public UserAccount accountOfUserName(String userName) throws NegativeException;

}
