package raydev.trivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class settings extends AppCompatActivity {
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_settings);

        mAuth = FirebaseAuth.getInstance();

        final Button signout = (Button) findViewById(R.id.btn_signout);
        signout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signOut();
                Intent mainIntent = new Intent(settings.this, FacebookLoginActivity.class);//after time elapses launch the main activity
                startActivity(mainIntent);
                finish();

            }
        });
//
//        final Button fb = (Button) findViewById(R.id.btn_fb);
//        fb.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//               // signOut();
//                Intent mainIntent = new Intent(settings.this, FacebookLoginActivity.class);//after time elapses launch the main activity
//                startActivity(mainIntent);
//                //finish();
//
//            }
//        });

    }


    public void signOut() {
        mAuth.signOut();
        LoginManager.getInstance().logOut();
//        Intent mainIntent = new Intent(settings.this, FacebookLoginActivity.class);//after time elapses launch the main activity
//                startActivity(mainIntent);
//        finish();
        //put dialog asking if to sign out and give name of person logged in
        Toast.makeText(settings.this, "Sign out",Toast.LENGTH_SHORT).show();


        //updateUI(null);
    }
}
