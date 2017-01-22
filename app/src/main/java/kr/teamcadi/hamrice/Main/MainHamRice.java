package kr.teamcadi.hamrice.Main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.teamcadi.hamrice.Chat.ChatMain;
import kr.teamcadi.hamrice.R;

public class MainHamRice extends Activity {

    Button IntoChatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ham_rice);

        IntoChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
              startActivity(new Intent(MainHamRice.this, ChatMain.class));
            }
        });

    }
}
