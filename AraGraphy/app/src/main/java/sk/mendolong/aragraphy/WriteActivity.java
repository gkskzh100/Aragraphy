package sk.mendolong.aragraphy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by yoonmin on 2015-11-16.
 */
public class WriteActivity extends Activity{

    EditText Write;
    Button Btn_Upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(android.R.style.Theme_Holo_Light_NoActionBar_TranslucentDecor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Write = (EditText)findViewById(R.id.Write);
        Btn_Upload = (Button)findViewById(R.id.Btn_Upload);

        Btn_Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("write", String.valueOf(Write.getText()));
                startActivity(intent);
                finish();

            }
        });


    }

}
