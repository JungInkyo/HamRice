package kr.teamcadi.hamrice.Chat;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import kr.teamcadi.hamrice.Data.ChatListData;
import kr.teamcadi.hamrice.Data.ChatListData;
import kr.teamcadi.hamrice.R;

public class ChattingActivity extends Activity
{

    private ListView ChattingListView = null;
    private ChattingListViewAdapter chattingListViewAdapter = null;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_activity);

        ChattingListView = (ListView) findViewById(R.id.ChattingListView);
        chattingListViewAdapter = new ChattingListViewAdapter(this);
        ChattingListView.setAdapter(chattingListViewAdapter);

        // 전송 버튼을 클릭했을 경우.
        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭했을 때마다, EditText의 내용이 String 형태로 바뀌어 불러져 오도록 함.
                EditText EnterMsgArea = (EditText) findViewById(R.id.EnterMsgArea);

                // EnterMsgText : EditText에서 입력 받은 내용을 저장할 String 객체.
                // EditText에서 입력 받은 내용을 String형으로 변환할 때,
                // EditText 객체 명.getText().toString()을 활용함.
                String EnterMsgText = EnterMsgArea.getText().toString();

                // EditText에서 입력받아 변환된 텍스트의 길이가 0이 아니라면
                // -> EditText를 통해서 무언가를 입력받았다면,
                if (EnterMsgText.length() != 0)
                {
                    Calendar calendar = Calendar.getInstance(); // 날짜와 시간을 입력하기 위한 캘린터 객체 생성

                    chattingListViewAdapter.addItem( EnterMsgText);


                    EnterMsgArea.setText(""); // 메시지를 입력받는 창 초기화.
                    chattingListViewAdapter.dataChange(); // 데이터 동기화.

                }
            }
        });
    }

    private class ChattingViewHolder {
        public TextView SendMsgText;
    }

    private class ChattingListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<ChatListData> mListData = new ArrayList<ChatListData>();

        public ChattingListViewAdapter(Context mContext)
        {
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

        public void addItem(String SendMsgText) {
            ChatListData addInfo = null;
            addInfo = new ChatListData();
            addInfo.SendMsgText = SendMsgText;

            mListData.add(addInfo);
        }

        public void remove(int position) {
            mListData.remove(position);
            dataChange();
        }

        public void dataChange() {
            chattingListViewAdapter.notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ChattingViewHolder holder;
            if (convertView == null) {
                holder = new ChattingViewHolder();

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.chatting_list_item, null);

                holder.SendMsgText = (TextView) convertView.findViewById(R.id.SendMsgText);

                convertView.setTag(holder);
            } else {
                holder = (ChattingViewHolder) convertView.getTag();
            }

            ChatListData mData = mListData.get(position);



            holder.SendMsgText.setText(mData.SendMsgText);

            return convertView;
        }
    }
}
