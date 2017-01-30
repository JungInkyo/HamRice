package kr.teamcadi.hamrice.Data;

import android.graphics.drawable.Drawable;

import java.text.Collator;
import java.util.Comparator;

/**
 * Created by gaejalsaeng-ginmingug on 2017. 1. 22..
 */

public class MainListData
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
    public static final Comparator<MainListData> ALPHA_COMPARATOR = new Comparator<MainListData>() {
        private final Collator sCollator = Collator.getInstance();

        @Override
        public int compare(MainListData mListDate_1, MainListData mListDate_2) {
            return sCollator.compare(mListDate_1.mTitle, mListDate_2.mTitle);
        }
    };
}
