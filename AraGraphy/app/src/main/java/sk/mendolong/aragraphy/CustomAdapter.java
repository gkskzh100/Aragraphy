package sk.mendolong.aragraphy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kim on 2015-11-03.
 */
public class CustomAdapter extends PagerAdapter {

    LayoutInflater inflater;
    private Context context;
    private ArrayList<String> fontList;
    private ArrayList<String> contentList;

    public CustomAdapter(Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
    }


    public CustomAdapter(Context context, LayoutInflater inflater, ArrayList<String> fontList) {
        this.context = context;
        this.inflater = inflater;
        this.fontList = fontList;
    }


    @Override
    public int getCount() { //텍스트 배열 데이터 길이
        return contentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.viewpager_main, null);

        TextView textView = (TextView) view.findViewById(R.id.Text_main_View);

        if (position == 0)
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), fontList.get(position)));

        container.addView(view);

        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
