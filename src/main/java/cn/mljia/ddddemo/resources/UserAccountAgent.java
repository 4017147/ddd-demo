package cn.mljia.ddddemo.resources;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.mljia.common.CodeType;
import cn.mljia.common.TResult;
import cn.mljia.ddd.common.serializer.ObjectSerializer;
import cn.mljia.ddddemo.application.UserAccountApplicatoin;
import cn.mljia.ddddemo.application.command.LoginCommand;
import cn.mljia.ddddemo.application.command.RegisterCommand;
import cn.mljia.ddddemo.application.representation.UserInfoRepresentation;
import cn.mljia.ddddemo.domain.UserAccount;
import cn.mljia.ddddemo.exception.NegativeException;

/**
 * 
 * @ClassName: CollegeVideoAgent
 * @Description: TODO
 * @author: mljia.cn-Marker
 * @date: 2016年12月13日 上午10:21:24
 */
@RestController
@RequestMapping(value = "/user")
public class UserAccountAgent
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountAgent.class);
    
    @Resource
    private UserAccountApplicatoin userApplicatoin;
    
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ResponseEntity<TResult> register(@RequestParam(value = "accountId") String accountId,
        @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password,
        @RequestParam(value = "age") Integer age, @RequestParam(value = "province") String province,
        @RequestParam(value = "city") String city, 
        @RequestParam(value = "area") String area)
    {
        TResult result = new TResult(CodeType.V_1);
        RegisterCommand command = new RegisterCommand(accountId, userName, password, age, province, city, area);
        try
        {
            UserAccount userAccount = userApplicatoin.register(command);
            UserInfoRepresentation activityListRepresentation = new UserInfoRepresentation(userAccount);
            result.setContent(ObjectSerializer.instance().serialize(activityListRepresentation));
            result.setStatus(CodeType.V_200);
        }
        catch (NegativeException e)
        {
            LOGGER.error("user login Exception e:" + e.getMessage(), e);
            result = new TResult(e.getStatus(), e.getMessage());
        }
        return new ResponseEntity<TResult>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ResponseEntity<TResult> login(@RequestParam(value = "userName") String userName,
        @RequestParam(value = "password") String password)
    {
        TResult result = new TResult(CodeType.V_1);
        LoginCommand command = new LoginCommand(userName, password);
        try
        {
            UserAccount userAccount = userApplicatoin.login(command);
            UserInfoRepresentation activityListRepresentation = new UserInfoRepresentation(userAccount);
            result.setContent(ObjectSerializer.instance().serialize(activityListRepresentation));
            result.setStatus(CodeType.V_200);
        }
        catch (NegativeException e)
        {
            LOGGER.error("user login Exception e:" + e.getMessage(), e);
            result = new TResult(e.getStatus(), e.getMessage());
        }
        return new ResponseEntity<TResult>(result, HttpStatus.OK);
    }
    
}
