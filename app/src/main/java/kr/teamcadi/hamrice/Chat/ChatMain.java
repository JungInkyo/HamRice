package kr.teamcadi.hamrice.Chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import kr.teamcadi.hamrice.Data.MainListData;
import kr.teamcadi.hamrice.R;
import kr.teamcadi.hamrice.login.Login;
import kr.teamcadi.hamrice.login.Main;

public class ChatMain extends Activity
{

    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;
    Button ctoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);

        mListView = (ListView) findViewById(R.id.mList);
        ctoutbtn = (Button)findViewById(R.id.ctoutbtn);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        mAdapter.addItem(getResources().getDrawable(R.drawable.ic_launcher),
                "토끼고기먹으러가실분",
                "3/4");
        mAdapter.addItem(getResources().getDrawable(R.drawable.ic_launcher),
                "돼지고기먹으러가실분",
                "1/2");
        mAdapter.addItem(getResources().getDrawable(R.drawable.ic_launcher),
                "소고기 무면 머하겠노",
                "2/3");

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long l)
            {
                MainListData mData = mAdapter.mListData.get(position);

                switch(position)
                {
                    case 0:
                        Intent MainToProfile = new Intent(ChatMain.this, ChattingActivity.class);
                        startActivity(MainToProfile);
                        finish();
                        break;
                    case 1:
                        Toast.makeText(ChatMain.this, "롹앤롤 베이비!", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(ChatMain.this, "그래두 무야지!", Toast.LENGTH_LONG).show();
                }
            }
        });

        ctoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent gologout = new Intent(ChatMain.this, Login.class);
                startActivity(gologout);
            }
        }); //로그아웃으로 가는 버튼


    }

    private class ViewHolder
    {
        public ImageView mIcon;

        public TextView mText;

        public TextView mHuman;
    }

    private class ListViewAdapter extends BaseAdapter
    {
        private Context mContext = null;
        private ArrayList<MainListData> mListData = new ArrayList<MainListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();

                    LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.list_item, null);

                    holder.mIcon = (ImageView) convertView.findViewById(R.id.mImage);
                    holder.mText = (TextView) convertView.findViewById(R.id.mText);
                    holder.mHuman = (TextView) convertView.findViewById(R.id.mHuman);

                    convertView.setTag(holder);
                }else{
                    holder = (ViewHolder) convertView.getTag();
                }

                MainListData mData = mListData.get(position);

                if (mData.mIcon != null) {
                    holder.mIcon.setVisibility(View.VISIBLE);
                    holder.mIcon.setImageDrawable(mData.mIcon);
                }else{
                    holder.mIcon.setVisibility(View.GONE);
                }

                holder.mText.setText(mData.mTitle);
                holder.mHuman.setText(mData.mHuman);

                return convertView;
            }


        public void addItem(Drawable icon, String mTitle, String mHuman)

        {
            MainListData addInfo = null;
            addInfo = new MainListData();
            addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;
            addInfo.mHuman = mHuman;

            mListData.add(addInfo);
        }

        public void remove(int position){
            mListData.remove(position);
            dataChange();
        }

        public void sort(){
            Collections.sort(mListData, MainListData.ALPHA_COMPARATOR);
            dataChange();
        }

        public void dataChange(){
            mAdapter.notifyDataSetChanged();
        }

        }
}
