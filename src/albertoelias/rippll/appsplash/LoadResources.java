package albertoelias.rippll.appsplash;

import java.io.InputStream;
import java.util.Properties;

import android.content.Context;

public class LoadResources {

	public static Integer ppid;
	public static String app_name;
	public static String splash_image;
	public static Context context;
		
	 public static void loadResources() {
	    	try {
	    		Properties app_properties = new Properties();
	    		InputStream stream = context.getResources().openRawResource(R.raw.appinfo);
	    		app_properties.load(stream);
				ppid = Integer.parseInt((String)app_properties.get("app_ppid"));
	    		splash_image = (String)app_properties.get("home_image");
	    		app_name = (String)app_properties.get("name");
	    		
	    	} catch (Exception e) {
	    		throw new RuntimeException("Can't load app resources", e);
	    	}
	    }
}
