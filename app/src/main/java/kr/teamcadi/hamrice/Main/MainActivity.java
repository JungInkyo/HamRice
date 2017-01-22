package kr.teamcadi.hamrice.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import kr.teamcadi.hamrice.R;
import kr.teamcadi.hamrice.login.Login;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                // 뒤로가기 했을경우 안나오도록 없애주기 >> finish!!
                finish();
            }
        }, 2000);
    }
}
