package comn.example.user.e_bank;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegistrationForm extends AppCompatActivity {

    private EditText password, confirmPassword;
    private TextView passwordHint, dateView;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        /*initialising views for the textWatcher*/
        password = (EditText) findViewById(R.id.password);
        confirmPassword =(EditText) findViewById(R.id.confirmPassword);
        passwordHint = (TextView) findViewById(R.id.passwordHint);

        /*initialising views for date picker*/
        dateView = (TextView) findViewById(R.id.dateView1);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        /*hide dateview textfield*/
        dateView.setVisibility(View.GONE);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        /* Set Text Watcher listener */
        password.addTextChangedListener(passwordWatcher);
        confirmPassword.addTextChangedListener(passwordWatcher);
    }

    public void signup(View view) {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }

    /*textWatcher - needs its 3 methods to be implemented in order to work*/
    private final TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            passwordHint.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            String Password = password.getText().toString();
            String ConfirmPassword = confirmPassword.getText().toString();

            /*check if both passwords are equal*/

            if (!Password.equals(ConfirmPassword)){
                passwordHint.setText("Passwords don't match!!!");
            }
            else if(Password.isEmpty()||ConfirmPassword.isEmpty()){
                passwordHint.setVisibility(View.GONE);
            }
            else{
                passwordHint.setVisibility(View.GONE);
            }
        }
    };

    /*Setting up the Date*/
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        if(dateView.getVisibility() != view.VISIBLE) {
            dateView.setVisibility(view.VISIBLE);

            showDialog(999);
            Toast.makeText(getApplicationContext(), "ca",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            dateView.setVisibility(view.GONE);
        }
          }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}