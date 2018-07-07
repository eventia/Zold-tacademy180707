package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void bean1() {
		//2. getBean() ȣ��
		Hello hello = (Hello)context.getBean("hello");
		//3. Hello �� sayHello() ȣ��.
		assertEquals("Hello Spring", hello.sayHello());;
		//3. Hello�� printer() ȣ��
		hello.print();
		
		//StringPrinter  getBean()
		Printer printer = context.getBean("printer",Printer.class);
		assertEquals("Hello Spring",printer.toString());
	}
	
	

}
