package kr.teamcadi.hamrice.setting;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import kr.teamcadi.hamrice.R;

public class setting extends Activity
{
    Button gongji_btn;
    Button ver_btn;
    Button gaebo_btn;
    Button alim_btn;
    Button frndset_btn;
    Button gogack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        gongji_btn = (Button)findViewById(R.id.gongji_btn);
        gongji_btn.setBackgroundColor(Color.WHITE);
        ver_btn = (Button)findViewById(R.id.ver_btn);
        ver_btn.setBackgroundColor(Color.WHITE);
        gaebo_btn = (Button)findViewById(R.id.gaebo_btn);
        gaebo_btn.setBackgroundColor(Color.WHITE);
        alim_btn = (Button)findViewById(R.id.alim_btn);
        alim_btn.setBackgroundColor(Color.WHITE);
        frndset_btn = (Button)findViewById(R.id.frndset_btn);
        frndset_btn.setBackgroundColor(Color.WHITE);
        gogack_btn = (Button)findViewById(R.id.gogack_btn);
        gogack_btn.setBackgroundColor(Color.WHITE);
    }
}
