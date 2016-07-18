package prodobro.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	Mail mail = (Mail) context.getBean("mailMail");
        mail.sendMail("Sender_name", "Test message blah blah blah");
    }
}
