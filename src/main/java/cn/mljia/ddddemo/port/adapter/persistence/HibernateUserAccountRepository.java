//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package cn.mljia.ddddemo.port.adapter.persistence;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import cn.mljia.ddd.common.port.adapter.persistence.hibernate.HibernateSupperRepository;
import cn.mljia.ddddemo.domain.UserAccount;
import cn.mljia.ddddemo.domain.UserAccountRepository;
import cn.mljia.ddddemo.exception.NegativeException;

@Repository
public class HibernateUserAccountRepository extends HibernateSupperRepository implements UserAccountRepository
{
    
    public HibernateUserAccountRepository()
    {
        super();
    }
    
    @Override
    public void add(UserAccount userAccount)
        throws NegativeException
    {
        // TODO Auto-generated method stub
        try
        {
            this.session().merge(userAccount);
        }
        catch (ConstraintViolationException e)
        {
            throw new IllegalStateException("User is not unique.", e);
        }
    }
    
    @Override
    public void remove(UserAccount userAccount)
        throws NegativeException
    {
        // TODO Auto-generated method stub
        this.session().delete(userAccount);
    }
    
    @Override
    public UserAccount accountOfId(String id)
        throws NegativeException
    {
        UserAccount userAccount =
            (UserAccount)this.session()
                .createQuery(" from UserAccount userAccount where userAccount.accountId = :id ")
                .setParameter("id", id)
                .uniqueResult();
        return userAccount;
    }
    
    @Override
    public UserAccount accountOfUserName(String userName)
        throws NegativeException
    {
        UserAccount userAccount =
            (UserAccount)this.session()
                .createQuery(" from UserAccount userAccount where userAccount.userName = :userName ")
                .setParameter("userName", userName)
                .uniqueResult();
        return userAccount;
    }
    
}
