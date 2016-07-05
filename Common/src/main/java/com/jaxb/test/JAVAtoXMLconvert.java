package com.jaxb.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAVAtoXMLconvert {

	String filepath = "D:\\Mine\\GitHub\\Serentiy_Test_Project\\JAXB_XMLtoJavaExample.xml";

	public static void main(String[] args) {

		CreditToken creditToken = new CreditToken();

		// Header part starts
		Header Header = new Header();
		Header.setVersion("1.0");
		Header.setUserAgent(
				"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.8.1.3) Gecko/20070309 Firefox/2.0.0.3");
		Header.setUserAgentId(999999999);
		Header.setBusinessUnitId(7);
		Header.setDeviceId(61);

		Encryption Encryption = new Encryption();
		Encryption.setKey("8b9d00c8dbfcc7ba51c9b50cfc0a850e");
		Encryption.setType("MD5");

		List<Encryption> encryptiondto = new ArrayList<Encryption>();
		encryptiondto.add(Encryption);

		Header.setEncryption(encryptiondto);

		CreditTokenInformation CreditTokenInformation = new CreditTokenInformation();
		TokenTransaction TokenTransaction = new TokenTransaction();

		User User = new User();
		User.setEmail("tpatel@pch.com");
		User.setGlobalMemberToken("fb4cb773-bfc5-433a-973a-6b82fdd4777a");

		List<User> UserDto = new ArrayList<User>();
		UserDto.add(User);

		TokenActivity TokenActivity = new TokenActivity();
		TokenActivity.setCode("VhVl14Ds");

		TokenTransaction.setTokenActivity(TokenActivity);
		TokenTransaction.setSourceDevice("DESKTOP");
		TokenTransaction.setAmount(200);
		TokenTransaction.setText1("test1");
		TokenTransaction.setText2("test2");

		List<TokenTransaction> TokenTransactionDto = new ArrayList<TokenTransaction>();
		TokenTransactionDto.add(TokenTransaction);

		CreditTokenInformation.setUser(UserDto);
		CreditTokenInformation.setTokenTransaction(TokenTransactionDto);

		List<Header> HeaderDto = new ArrayList<Header>();
		HeaderDto.add(Header);

		List<CreditTokenInformation> CreditTokenInformationDto = new ArrayList<CreditTokenInformation>();
		CreditTokenInformationDto.add(CreditTokenInformation);

		creditToken.setHeader(HeaderDto);
		creditToken.setCreditTokenInformation(CreditTokenInformationDto);
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbc = JAXBContext.newInstance(CreditToken.class);

			Marshaller m = jaxbc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(creditToken, sw);

			System.out.println(sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
