package comn.example.user.e_bank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Login extends AppCompatActivity {
    private LinearLayout connect_sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connect_sets = (LinearLayout) findViewById(R.id.connect_sets);
        connect_sets.setVisibility(View.GONE);

        /*dropdown menu for countries
        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"Cameroon","South Africa", "France"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        */
    }
     /*To execute when "connection settings" is clicked*/
    public void connection_settings(View view) {
        connect_sets.setVisibility(View.VISIBLE);
    }

    public void login(View view) {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }

    public void signup(View view) {
        Intent intent = new Intent(this,RegistrationForm.class);
        startActivity(intent);
    }
}