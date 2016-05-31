package raydev.trivia;

        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.Toast;
        import com.facebook.AccessToken;
        import com.facebook.AccessTokenTracker;
        import com.facebook.CallbackManager;
        import com.facebook.FacebookCallback;
        import com.facebook.FacebookException;
        import com.facebook.FacebookSdk;
        import com.facebook.login.LoginManager;
        import com.facebook.login.LoginResult;
        import com.facebook.login.widget.LoginButton;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthCredential;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FacebookAuthProvider;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity {

    private static final String TAG = "Home";
    public FirebaseAuth mAuth;
    boolean doubleBackToExitPressedOnce = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_home);

        Log.d(TAG, "User Logged in");
        mAuth = FirebaseAuth.getInstance();

        final Button play = (Button) findViewById(R.id.btn_play);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(home.this, "Almost there Raydon",Toast.LENGTH_SHORT).show();

            }
        });

        final Button difficulty = (Button) findViewById(R.id.btn_difficulty);
        difficulty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(home.this, "Almost there Raydon",Toast.LENGTH_SHORT).show();

            }
        });

        final Button settings = (Button) findViewById(R.id.btn_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(home.this, settings.class);//after time elapses launch the main activity
                startActivity(mainIntent);

            }
        });

    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {//if true go back
            super.onBackPressed();
            moveTaskToBack(true);
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(home.this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {//resets value after 2secs
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
