package utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ui.test.models.Address;
import com.ui.test.models.CreditCard;
import com.ui.test.models.CustomerInfo;
import com.ui.test.models.ExpirationDate;

public class JsonUtil {

	public static CustomerInfo parseAcctInfoJson(String path) {
		JSONParser parser = new JSONParser();
		CustomerInfo customer = new CustomerInfo();

		try {
			FileReader reader = new FileReader(path);
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			customer.setFirstName((String)jsonObject.get("firstName"));
			customer.setLastName((String)jsonObject.get("lastName"));			
			customer.setGender((String)jsonObject.get("gender"));
			customer.setEmail((String)jsonObject.get("email"));
			customer.setPassword((String)jsonObject.get("password"));
			customer.setDob((String)jsonObject.get("dob"));			
			customer.setTitle((String)jsonObject.get("title"));
			customer.setCompany((String)jsonObject.get("company"));	
			customer.setMobile((String)jsonObject.get("mobile"));
			//address
			JSONObject addressObject = (JSONObject) jsonObject.get("address");
			Address address = new Address();
			address.setStreet((String)addressObject.get("street"));
			address.setApt((String)addressObject.get("apartment"));			
			address.setCity((String)addressObject.get("city"));
			address.setZip((String)addressObject.get("zip"));
			address.setState((String)addressObject.get("state"));
			address.setCountry((String)addressObject.get("country"));
			customer.setAddress(address);
			//cc info
			JSONObject creditCard = (JSONObject) jsonObject.get("creditCard");
			CreditCard cc = new CreditCard();
			cc.setNumber((String)creditCard.get("number"));
			cc.setNameOnCard((String)creditCard.get("name"));
			JSONObject expDate = (JSONObject) creditCard.get("expiration");
			ExpirationDate dt = new ExpirationDate();
			dt.setMonth((String)expDate.get("month"));
			dt.setYear((String)expDate.get("year"));
			cc.setDate(dt);
			cc.setCvc((String)creditCard.get("cvv"));
			customer.setCreditCard(cc);
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
