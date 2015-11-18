package sk.mendolong.aragraphy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.StringTokenizer;

/**
 * Created by yoonmin on 2015-10-30.
 */

public class Write_Activity extends Activity{

    private EditText Write_Text;
    private Button Btn_Upload;
    private String temp_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Write_Text = (EditText)findViewById(R.id.Write_Text);

        Btn_Upload = (Button)findViewById(R.id.Btn_Upload);

        Btn_Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                temp_str = String.valueOf(Write_Text.getText());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Write", temp_str);
                startActivity(intent);
                finish();

            }
        });

    }



    @Override
    public void onBackPressed() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }
}
