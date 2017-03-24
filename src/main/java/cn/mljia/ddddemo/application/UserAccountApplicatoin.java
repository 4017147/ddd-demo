package cn.mljia.ddddemo.application;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mljia.ddd.common.event.annotation.EventListener;
import cn.mljia.ddddemo.application.command.LoginCommand;
import cn.mljia.ddddemo.application.command.RegisterCommand;
import cn.mljia.ddddemo.domain.UserAccount;
import cn.mljia.ddddemo.domain.UserAccountRepository;
import cn.mljia.ddddemo.exception.NegativeCode;
import cn.mljia.ddddemo.exception.NegativeException;

@Service
@Transactional
public class UserAccountApplicatoin {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountApplicatoin.class);

	@Resource
	private UserAccountRepository userAccountRepository;

	@Transactional(rollbackFor = { Exception.class, RuntimeException.class, NegativeException.class })
	@EventListener(isListening = true)
	public void loginStatistics(String accountId) throws NegativeException {
		LOGGER.info("user login statistics >>{}", accountId);
		UserAccount account = userAccountRepository.accountOfId(accountId);
		if (account != null)
			account.statistics();
	}

	@Transactional(rollbackFor = { Exception.class, RuntimeException.class, NegativeException.class })
	@EventListener(isListening = true)
	public UserAccount login(LoginCommand command) throws NegativeException {
		LOGGER.info("user login command >>{}", command);

		UserAccount account = userAccountRepository.accountOfUserName(command.getUserName());
		if (account != null)
			return account.login(command.getPassword(), command.getUserName());
		else
			throw new NegativeException(NegativeCode.LOGIN_USER_NOT_EXIST, "登录账户不存在.");
	}

	@Transactional(rollbackFor = { Exception.class, RuntimeException.class, NegativeException.class })
	@EventListener(isListening = true)
	public UserAccount register(RegisterCommand command) throws NegativeException {
		LOGGER.info("user register command >>{}", command);
		UserAccount account = userAccountRepository.accountOfUserName(command.getUserName());
		if (account == null) {
			account = new UserAccount();
			account.register(command.getAccountId(), command.getUserName(), command.getAge(), command.getPassword(),
					command.getProvince(), command.getCity(), command.getArea());
			userAccountRepository.add(account);
		} else {
			throw new NegativeException(NegativeCode.REGISTER_USER_IS_EXIST, "注册账户已存在.");
		}
		return account;
	}
}
