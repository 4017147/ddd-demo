package cn.mljia.ddddemo.port.adapter.listener;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTransactionManager;

import cn.mljia.ddd.common.application.configuration.RabbitmqConfiguration;
import cn.mljia.ddd.common.event.ConsumedEventStore;
import cn.mljia.ddd.common.notification.NotificationReader;
import cn.mljia.ddd.common.port.adapter.messaging.rabbitmq.ExchangeListener;
import cn.mljia.ddddemo.application.UserAccountApplicatoin;

public class LoginStatisticsListener extends ExchangeListener {

	@Resource
	private UserAccountApplicatoin accountApplicatoin;

	public LoginStatisticsListener(RabbitmqConfiguration rabbitmqConfiguration,
			HibernateTransactionManager hibernateTransactionManager, ConsumedEventStore consumedEventStore) {
		super(rabbitmqConfiguration, hibernateTransactionManager, consumedEventStore);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exchangeName() {
		// TODO Auto-generated method stub
		return "cn.mljia.ddddemo.domain.UserAccountLoginEvent";
	}

	@Override
	public void filteredDispatch(String aType, String aTextMessage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("aType:" + aType + "------aTextMessage:" + aTextMessage);

		NotificationReader reader = new NotificationReader(aTextMessage);

		String accountId = reader.eventStringValue("accountId");
		String userName = reader.eventStringValue("userName");
		long notificationId = reader.notificationId();

		System.out.println(
				"accountId:" + accountId + "------userName:" + userName + "-------notificationId:" + notificationId);

		// 做相关业务
		accountApplicatoin.loginStatistics(accountId);
	}

	@Override
	public String[] listensTo() {
		// TODO Auto-generated method stub
		return new String[] { "cn.mljia.ddddemo.domain.UserAccountLoginEvent" };
	}

}
