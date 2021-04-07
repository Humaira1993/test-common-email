package org.apache.commons.mail;

import org.junit.Before;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Test;

public class EmailTest {
	
	private static final String[] TEST_Emails = {"ab@bc.com", "a.b@c.d", "sanjsjahsjahsjhasjha@dhjhdjad.com.bd"};
	private static final String[] Empty_Email = {};
	private static final String Emp = "", name = "ab", value="cd";
	private static Date dateTest;
	
	private EmailConcrete email;
	
	//
	
	@Before
	public void setUpEmailTest() throws Exception{
		
		email = new EmailConcrete();
	}
	
	@After
	public void teardownEmailTest() throws Exception{
		
	}
	
	@Test
	public void testaddBcc() throws Exception{
		
		email.addBcc(TEST_Emails);
		assertEquals(4, email.getBccAddresses().size());
	}
	
	@Test(expected = EmailException.class)
	public void testaddBccEmpty() throws Exception{
		
		email.addBcc(Empty_Email);
		assertEquals(1, email.getBccAddresses().size());
	}
	
	@Test
	public void testaddCc() throws Exception{
		
		email.addCc(TEST_Emails);
		assertEquals(4, email.getCcAddresses().size());
	}
	
	@Test(expected = EmailException.class)
	public void testaddCcEmpty() throws Exception{
		
		email.addCc(Empty_Email);
		assertEquals(1, email.getCcAddresses().size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaddHeaderEmptyName() throws Exception{
		
		email.addHeader(Emp, value);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaddHeaderEmptyValue() throws Exception{
		
		email.addHeader(name, Emp);
	}
	
	@Test
	public void testaddHeader() throws Exception{
		
		email.addHeader(name, value);
		assertEquals(1, email.headers.size());
	}
	@Test
	public void testaddReplyTo() throws Exception{
		
		email.addReplyTo(TEST_Emails[0], value);
		assertEquals(2, email.getReplyToAddresses().size());
	}


}
