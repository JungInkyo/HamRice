package kr.teamcadi.hamrice.Chat;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kr.teamcadi.hamrice.R;

public class ChatMain extends Activity
{

    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);

        mListView = (ListView) findViewById(R.id.mList);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        mAdapter.addItem(getResources().getDrawable(R.drawable.ic_launcher),
                "토끼고기먹으러가실분",
                "3/4");
        mAdapter.addItem(getResources().getDrawable(R.drawable.ic_launcher),
                "돼지고기먹으러가실분",
                "1/2");
        mAdapter.addItem(getResources().getDrawable(R.drawable.ic_launcher),
                "6시에같이밥먹을분",
                "2/3");

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                ChatListData mData = mAdapter.mListData.get(position);
                Toast.makeText(ChatMain.this, mData.mTitle, Toast.LENGTH_SHORT).show();
            }
        });


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
        private ArrayList<ChatListData> mListData = new ArrayList<ChatListData>();

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

                ChatListData mData = mListData.get(position);

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
            ChatListData addInfo = null;
            addInfo = new ChatListData();
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
            Collections.sort(mListData, ChatListData.ALPHA_COMPARATOR);
            dataChange();
        }

        public void dataChange(){
            mAdapter.notifyDataSetChanged();
        }

        }





}
