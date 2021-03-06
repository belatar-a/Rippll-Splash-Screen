package albertoelias.rippll.appsplash.Activities;

import albertoelias.rippll.appsplash.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.widget.ProgressBar;

// A simple splash screen used in all AppSplash applicatinos.
public class SplashActivity extends Activity {
		
	private ProgressBar progressBar;
	private Handler mHandler = new Handler();
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        // Declare a progressbar that appears in the middle of the splash screen.
        progressBar = (ProgressBar) findViewById(R.id.progress);
        
        
    }
    
    @Override
    public void onStart() {
    	// When the aplication starts, show the progressbar for 2 seconds. After that, execute loadHomeActivity runnable.
    	long mStartTime = 0;
		if (mStartTime == 0L) {
	            mStartTime = System.currentTimeMillis();
	            mHandler.removeCallbacks(loadHomeActivity);
	            progressBar.setVisibility(ProgressBar.VISIBLE);
		        progressBar.setProgress(0);		        
	            mHandler.postDelayed(loadHomeActivity, 2000);
	       }
    	super.onStart();
    }
    
    // A runnable executed when the progressbar finishes which starts the HomeActivity.
    private Runnable loadHomeActivity = new Runnable() {
    	   public void run() {
    		   Intent intenthome = new Intent(SplashActivity.this, HomeActivity.class);
    		   startActivity(intenthome);	
    	   }
    	
    };
    
   
}