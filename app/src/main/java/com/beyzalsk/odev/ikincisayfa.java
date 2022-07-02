package com.beyzalsk.odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ikincisayfa extends AppCompatActivity {
    TextView txt;
    String a;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikincisayfa);
        txt = (TextView) findViewById(R.id.text1);
        i = getIntent();
        Bundle b1 = new Bundle();
        b1 = getIntent().getExtras();
        a = b1.getString("girisadi"); // ilk sayfamızdaki kullanıcı adını çekiyoruz
        txt.setText("HOŞGELDİN "+ a); // çektiğimiz kullanıcı adını settxte atıp yazdırıyoruz.

    }
}