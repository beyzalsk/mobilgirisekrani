package com.beyzalsk.odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Kullanici,Sifre;
    Button Kayit;
    Intent i;

    SharedPreferences SP;
    SharedPreferences.Editor ED;

    String girisadi, sifree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = new Intent(this,ikincisayfa.class);
        Kullanici = (EditText) findViewById(R.id.kullaniciadi);
        Sifre = (EditText) findViewById(R.id.sifre);
        Kayit = (Button) findViewById(R.id.kayit);

        SP = getSharedPreferences("xmlFile", MODE_PRIVATE);
        ED = SP.edit();

        SP.getString("sifree", ""); // kullanıcıdan girdiğişifreyi alıyoruz
        SP.getString("girisadi",""); // ikinci parametre boş olduğunda yapılacakları gösteirir.

        Kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisadi =  Kullanici.getText().toString(); // aldığımız şifre ve kullanıcı adını stringe çeviriyoruz
                sifree = Sifre.getText().toString();

                if(sifree.equals("sifreleme")){ // sifre kontrolü yapıyoruz şifre burda yazan kelimeyse diğer activity sayfamıza geçiş yapabiliriz.
                    ED.putString("girisadi",girisadi);
                    ED.putString("sifre",sifree);
                    i.putExtra("girisadi",girisadi);
                    i.putExtra("sifree", sifree);
                    startActivity(i); // activitymizi başlatıyoruz
                    ED.commit();
                }
            }
        });





    }
}