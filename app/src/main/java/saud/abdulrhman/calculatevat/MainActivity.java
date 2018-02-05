package saud.abdulrhman.calculatevat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    DecimalFormat formting = new DecimalFormat("###.##");
    DecimalFormat formting1 = new DecimalFormat("########.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          final EditText caulculateVAT = (EditText)findViewById(R.id.caulculateVAT);
          final TextView  Resulte = (TextView)findViewById(R.id.Resulte);
          final TextView Resulte1 = (TextView)findViewById(R.id.resualt2);
          final Button   IDcul   = (Button)findViewById(R.id.IDcul);
          final Button  clear = (Button)findViewById(R.id.button_clear);
        MobileAds.initialize(this, "ca-app-pub-5930122285460758~8935166454");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        IDcul.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String calucalte = caulculateVAT.getText().toString();

                 if(calucalte.isEmpty())
                 {
                     return;
                 }
                 double calucaltev = Double.parseDouble(calucalte) * 0.05;
                 double calucaltev1 = Double.parseDouble(calucalte);
                 Resulte.setText(String.valueOf(formting.format(calucaltev)));

                 double sum = calucaltev + calucaltev1 ;
                 Resulte1.setText(String.valueOf(formting1.format(sum)));
             }
         });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caulculateVAT.setText("");
                Resulte.setText("");
                Resulte1.setText("");
            }
        });

    }

}
