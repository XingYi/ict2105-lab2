package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.view.inputmethod.InputMethodManager;
import android.util.Log;

public class ActivityThree extends Activity {

    static final String TAG = "Activity 3 Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        final EditText textBox =
                (EditText) findViewById(R.id.editText);

        //Done button for user to click when done typing
        Button buttonDone = (Button) findViewById(R.id.btnDone);
        buttonDone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dismiss the keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(textBox.getWindowToken(), 0);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_three, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onSaveInstanceState(Bundle outState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState");

        final EditText textBox =
                (EditText) findViewById(R.id.editText);

        CharSequence userText = textBox.getText();
        outState.putCharSequence("savedText", userText);

    }

    protected void onRestoreInstanceState(Bundle savedState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedState);

        Log.i(TAG, "onRestoreInstanceState");

        final EditText textBox =
                (EditText) findViewById(R.id.editText);

        CharSequence userText =
                savedState.getCharSequence("savedText");

        textBox.setText(userText);
    }
}
