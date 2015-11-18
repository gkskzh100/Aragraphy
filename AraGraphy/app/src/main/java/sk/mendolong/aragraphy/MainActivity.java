package sk.mendolong.aragraphy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button Btn_Write;
    ViewPager pager;
    TextView textView;
    ArrayList<String> comment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(android.R.style.Theme_Holo_Light_NoActionBar_TranslucentDecor);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.main_ViewPager);

        CustomAdapter adapter = new CustomAdapter(this, getLayoutInflater());

        pager.setAdapter(adapter);

        comment.add("그대가 있는\n곳..");
        comment.add("흔들리지 않고\n피는 꽃이 어디있으랴");
        comment.add("버스 창가에 앉아\n바라보다");
        comment.add("오늘은 여기까지.");
        comment.add("돌아가는\n회전목마 처럼...");
        comment.add("사랑은 눈으로\n보는게 아니라\n마음으로 보는 것 이다.");
        comment.add("살랑 살랑 불어오는\n봄 바람");
        comment.add("사랑을 하는 사람과\n사랑을 받는 사람은\n항상 따로 있다.");
        comment.add("사랑하면서 동시에\n현명할 수 있는 사람은\n없다.");
        comment.add("나이와 연인의 수\n마신 와인 잔 수는\n세는 게 아니다.");


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override

            public void onPageSelected(int position) {
                try {

                    Intent intent = getIntent();
                    intent.getExtras().getString("write");
                    comment.add(intent.getExtras().getString("write"));
                    textView.setText(comment.get(position));

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "듣기 위해선 당신의 이야기를 해야 합니다 :)", Toast.LENGTH_SHORT).show();
                    finish();
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Btn_Write = (Button) findViewById(R.id.Btn_Write);

        Btn_Write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    class CustomAdapter extends PagerAdapter {

        LayoutInflater inflater;
        private Context context;
        private int page = 100;

        public CustomAdapter(Context context, LayoutInflater inflater) {
            this.context = context;
            this.inflater = inflater;

        }

        @Override
        public int getCount() { //텍스트 배열 데이터 길이

            return page;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.viewpager_main, null);

            textView = (TextView) view.findViewById(R.id.Text_main_View);

            textView.setTypeface(Typeface.createFromAsset(getAssets(), "ara.ttf"));

            if (position == position) {

            }

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


        //    http://pk09.tistory.com/119

    }
}
