package com.apiautomation.jaxbdto;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JAXdtoExample {

	public static void main(String[] args) throws Exception {

		JAXBContext jaxbcontent = JAXBContext.newInstance(CreditTokenAPITest.class);

		Marshaller marshaller = jaxbcontent.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		EncryptionDto encryption = new EncryptionDto("MD5", "8b9d00c8dbfcc7ba51c9b50cfc0a850e");

		ArrayList<EncryptionDto> encryption_list = new ArrayList<EncryptionDto>();
		encryption_list.add(encryption);

		HeaderDto header = new HeaderDto(1.0,
				"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.8.1.3)" + "Gecko/20070309 Firefox/2.0.0.3",
				999999999, 7, 61, encryption_list);

		ArrayList<HeaderDto> headerList = new ArrayList<HeaderDto>();
		headerList.add(header);

		UserDto user = new UserDto("tpatel@pch.com", "fb4cb773-bfc5-433a-973a-6b82fdd4777a");
		ArrayList<UserDto> userlist = new ArrayList<UserDto>();
		userlist.add(user);

		TokenActivityDto tokenActivity = new TokenActivityDto("VhVl14Ds");
		ArrayList<TokenActivityDto> tokenActivityList = new ArrayList<TokenActivityDto>();
		tokenActivityList.add(tokenActivity);

		TokenTransactionDto tokenTransaction = new TokenTransactionDto(tokenActivityList, "DESKTOP", 200, "test1",
				"test2");
		ArrayList<TokenTransactionDto> tokenTransactionlist = new ArrayList<TokenTransactionDto>();
		tokenTransactionlist.add(tokenTransaction);

		CreditTokenInformationDto creditTokenInformation = new CreditTokenInformationDto(userlist,
				tokenTransactionlist);

		ArrayList<CreditTokenInformationDto> creditTokenInformationlist = new ArrayList<CreditTokenInformationDto>();
		creditTokenInformationlist.add(creditTokenInformation);

		CreditToken creditToken = new CreditToken(headerList, creditTokenInformationlist);

		CreditTokenAPITest creditTokenapitest = new CreditTokenAPITest(creditToken);

		marshaller.marshal(creditTokenapitest, new FileOutputStream("testing.xml"));
	}

}
