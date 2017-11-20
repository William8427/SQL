package com.tuner.navi.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {

    private EditText edId;
    private EditText edPs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edId = findViewById(R.id.ed_id);
        edPs = findViewById(R.id.ed_ps);
    }

    public void login(View view)
    {
        String userName = edId.getText().toString();
        String passWord = edPs.getText().toString();

        if(userName.equals("william") && passWord.equals("8888"))
        {
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }
    public void quit(View view)
    {
        finish();
    }
}
