package kr.teamcadi.hamrice.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kr.teamcadi.hamrice.Chat.ChatMain;
import kr.teamcadi.hamrice.R;

public class Login extends Activity
{
    Button btnLogin;
    EditText etId, etPassword;
    TextView registerLink;
    Button endbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etId = (EditText) findViewById(R.id.etId);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        registerLink = (TextView)findViewById(R.id.tRegisterLink);
        endbtn = (Button)findViewById(R.id.endbtn);

        registerLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                case R.id.tRegisterLink:
                startActivity(new Intent(Login.this, register.class));
                break;
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.btnRegister:
                        break;
                    case R.id.btnLogin:
                        startActivity(new Intent(Login.this, ChatMain.class));
                        break;
                }
            }
        });

        endbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        }); //함밥 종료 버튼
    }
}
