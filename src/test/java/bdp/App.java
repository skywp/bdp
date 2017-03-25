package bdp;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.defonds.bdp.oxm.Customer;
import com.defonds.bdp.oxm.XMLConverter;
/**
 * Spring OXM test<p>
 * @author wangpeng
 *
 */
public class App {
private static final String XML_FILE_NAME = "customer.xml";
	
	public static void main(String[] args) throws IOException {
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("bdp-applicationContext.xml");  
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/app.xml");
		XMLConverter converter = (XMLConverter) context.getBean("XMLConverter");
		
		Customer customer = new Customer();
		customer.setName("dhcc");
		customer.setAge(28);
		customer.setFlag(true);
		customer.setAddress("tai'an");
		
		System.out.println("Convert Object to XML!");
		//from object to XML file
		converter.convertFromObjectToXML(customer, XML_FILE_NAME);
		System.out.println("Done \n");
		
		System.out.println("Convert XML back to Object!");
		//from XML to object
		Customer customer2 = (Customer)converter.convertFromXMLToObject(XML_FILE_NAME);
		System.out.println(customer2);
		System.out.println("Done");
		
	}
}
