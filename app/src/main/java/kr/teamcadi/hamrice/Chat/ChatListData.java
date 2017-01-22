package kr.teamcadi.hamrice.Chat;

import android.graphics.drawable.Drawable;

import java.text.Collator;
import java.util.Comparator;

/**
 * Created by gaejalsaeng-ginmingug on 2017. 1. 22..
 */

public class ChatListData
{
    /**
     * 리스트 정보를 담고 있을 객체 생성
     */
    // 아이콘
    public Drawable mIcon;

    // 방제목
    public String mTitle;

    // 방인원
    public String mHuman;

    /**
     * 알파벳 이름으로 정렬
     */
    public static final Comparator<ChatListData> ALPHA_COMPARATOR = new Comparator<ChatListData>() {
        private final Collator sCollator = Collator.getInstance();

        @Override
        public int compare(ChatListData mListDate_1, ChatListData mListDate_2) {
            return sCollator.compare(mListDate_1.mTitle, mListDate_2.mTitle);
        }
    };
}
