package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {

	
	ApplicationContext context ;

	@Before
	public void init(){
		context = new GenericXmlApplicationContext("classpath:config/beans.xml");
	}
	
	@Test
	public void bean1(){
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
//		assertEquals("Hello Spring", hello.sayHello());		
		hello.print();
		System.out.println(hello.sayHello());
// 		System.out.println("Print bean1...");
	}

	@Test
	public void bean2(){
		Printer printer  = (Printer) context.getBean("printer");
		Printer printer2 = context.getBean("printer", Printer.class);
		assertSame(printer, printer2);
		if(printer == printer2) { System.out.println("Same Printer"); }
		// System.out.println("Print bean2...");
	}
}
