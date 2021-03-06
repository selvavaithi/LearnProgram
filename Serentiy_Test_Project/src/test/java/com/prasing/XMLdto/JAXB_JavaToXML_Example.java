package com.prasing.XMLdto;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXB_JavaToXML_Example {

	public static void main(String[] args) {

		try {

			File file = new File(System.getProperty("user.dir") + "\\JAXB_XMLtoJavaExample.xml");

			// Header part starts
			Header header = new Header();

			header.setVersion(1.0);
			header.setUserAgent(
					"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.8.1.3) Gecko/20070309 Firefox/2.0.0.3");
			header.setUserAgentId(999999999);
			header.setBusinessUnitId(7);
			header.setDeviceId(61);

			Encryption encryption = new Encryption();
			encryption.setType("MD5");
			encryption.setKey("8b9d00c8dbfcc7ba51c9b50cfc0a850e");

			List<Encryption> encryptionDto = new ArrayList<Encryption>();
			encryptionDto.add(encryption);

			header.setEncryption(encryptionDto);
			// Header part ENDS

			CreditTokenInformation creditTokenInformation = new CreditTokenInformation();
			User user = new User();
			user.setEmail("tpatel@pch.com");
			user.setGlobalMemberToken("fb4cb773-bfc5-433a-973a-6b82fdd4777a");

			List<User> userdto = new ArrayList<User>();
			userdto.add(user);

			TokenTransaction tokenTransaction = new TokenTransaction();

			TokenActivity tokenactivity = new TokenActivity();
			tokenactivity.setCode("VhVl14Ds");

			List<TokenActivity> tokenactivityDto = new ArrayList<TokenActivity>();
			tokenactivityDto.add(tokenactivity);

			tokenTransaction.setTokenActivity(tokenactivityDto);
			tokenTransaction.setSourceDevice("DESKTOP");
			tokenTransaction.setAmount(200);
			tokenTransaction.setText1("test1");
			tokenTransaction.setText2("test2");

			List<TokenTransaction> tokenTransactionDto = new ArrayList<TokenTransaction>();
			tokenTransactionDto.add(tokenTransaction);

			creditTokenInformation.setUser(userdto);
			creditTokenInformation.setTokenTransaction(tokenTransactionDto);

			// Prasing Starts here
			CreditToken creditToken = new CreditToken();

			List<Header> headerDto = new ArrayList<Header>();
			headerDto.add(header);

			List<CreditTokenInformation> creditTokenInformationDto = new ArrayList<CreditTokenInformation>();
			creditTokenInformationDto.add(creditTokenInformation);

			creditToken.setHeader(headerDto);
			creditToken.setCreditTokenInformation(creditTokenInformationDto);

			JAXBContext jaxbContext = JAXBContext.newInstance(CreditToken.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,
			// "ISO-8859-1");

			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(creditToken, file);
			jaxbMarshaller.marshal(creditToken, sw);

			System.out.println(sw);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
