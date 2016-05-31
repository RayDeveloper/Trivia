package raydev.trivia;

/**
 * Created by Raydon on 5/30/2016.
 */
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {//used by FacebookAuthActivity

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideProgressDialog();
    }

}