import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class ec {
	

	public static void main(String []args )
	{
		int ch; String city = ""; String path="";
		System.out.println("Chose a city:\n1. Delhi\n2. Chennai\n3. Agartala\n4. Kolkata\n");
		Scanner input=new Scanner(System.in);
		ch=input.nextInt();
		URL url = null;
		switch(ch)
		{
		case 1:
			city="Delhi";
			path="http://www.mypetrolprice.com/2/Diesel-price-in-Delhi?FuelType=1&LocationId=2";
			break;
			
		case 2:
			city="Chennai";
			path="http://www.mypetrolprice.com/5/Petrol-price-in-Chennai?FuelType=0&LocationId=5";
			break;
		case 3:
			city="Agartala";
			path="http://www.mypetrolprice.com/9/Petrol-price-in-Agartala?FuelType=0&LocationId=9";
			break;
		case 4:
			city="Kolkata";
			path="http://www.mypetrolprice.com/4/Petrol-price-in-Kolkata?FuelType=0&LocationId=4";
			break;
		}
		
		try {
			url = new URL(path);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URLConnection con = null;
		try {
			con = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in = null;
		try {
			in = con.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = "";String text=""; double abc = 0.0;
		try {
			body = IOUtils.toString(in, encoding);
			int pos,index;
			
				index = body.indexOf("<span id=\"BC_lblCurrent\"><b>");
				pos=	body.indexOf("Rs/Ltr");
				text = body.substring((index+30), pos);
				text=text.replaceAll("[\\s+a-zA-Z :]", "");
				text=text.replace('=', ' ');
				abc= Double.parseDouble(text);
				

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(body);
		System.out.println(city+" : "+abc+"  "+(abc+2));
	}
}
