package cn.mljia.ddddemo.port.adapter.listener;

import org.springframework.orm.hibernate4.HibernateTransactionManager;

import cn.mljia.ddd.common.application.configuration.RabbitmqConfiguration;
import cn.mljia.ddd.common.event.ConsumedEventStore;
import cn.mljia.ddd.common.notification.NotificationReader;
import cn.mljia.ddd.common.port.adapter.messaging.rabbitmq.ExchangeListener;

public class UserRegisterListener extends ExchangeListener
{
    private RabbitmqConfiguration rabbitmqConfiguration;
    
    public UserRegisterListener(RabbitmqConfiguration rabbitmqConfiguration,
        HibernateTransactionManager hibernateTransactionManager, ConsumedEventStore consumedEventStore)
    {
        super(rabbitmqConfiguration, hibernateTransactionManager, consumedEventStore);
        // TODO Auto-generated constructor stub
        this.rabbitmqConfiguration=rabbitmqConfiguration;
    }
    
    @Override
    public String exchangeName()
    {
        // TODO Auto-generated method stub
        return "cn.mljia.ddddemo.domain.UserAccountCreatedEvent";
    }
    
    @Override
    public void filteredDispatch(String aType, String aTextMessage)
        throws Exception
    {
        // TODO Auto-generated method stub
        System.out.println("aType:" + aType + "------aTextMessage:" + aTextMessage);
        //做相关业务
        NotificationReader reader = new NotificationReader(aTextMessage);

        String accountId = reader.eventStringValue("accountId");
        String userName = reader.eventStringValue("userName");
        long notificationId = reader.notificationId();

        System.out.println("accountId:" + accountId + "------userName:" + userName+"-------notificationId:"+notificationId);
    }
    
    @Override
    public String[] listensTo()
    {
        // TODO Auto-generated method stub
        return new String[] {"cn.mljia.ddddemo.domain.UserAccountCreatedEvent"};
    }
    
    
    //事件驱动 --如SAAG
//    private MessageProducer messageProducer(String exchangeName) {
//        
//        
//        Exchange exchange = Exchange.directInstance(ConnectionSettings.instance(this.rabbitmqConfiguration.getAddress(),
//            this.rabbitmqConfiguration.getVirtualHost(),
//            this.rabbitmqConfiguration.getUsername(), this.rabbitmqConfiguration.getPassword()), this.exchangeName(), true);
//        
//        MessageProducer messageProducer = MessageProducer.instance(exchange);
//
//        return messageProducer;
//    }
//
//    private void send(Notification aNotification,String exchangeName) {
//
//        MessageParameters messageParameters =
//                MessageParameters.durableTextParameters(
//                        aNotification.typeName(),
//                        Long.toString(aNotification.notificationId()),
//                        aNotification.occurredOn());
//
//        String serializedNotification =
//                NotificationSerializer.instance().serialize(aNotification);
//
//        this.messageProducer(exchangeName).send(serializedNotification, messageParameters);
//    }
//    
    
}
