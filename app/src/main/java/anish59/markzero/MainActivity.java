package anish59.markzero;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import anish59.markzero.utilPack.AdvancedSpannableString;

public class MainActivity extends AppCompatActivity {
    private TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHello = (TextView) findViewById(R.id.txtHello);
        init();
    }

    private void init() {
        AdvancedSpannableString spannableString = new AdvancedSpannableString(txtHello.getText().toString());
        String spanTxt = "Hello";
        spannableString.setColor(Color.parseColor("#FFAF00"), spanTxt);
        spannableString.setBold(spanTxt);
        txtHello.setText(spannableString);
    }
}
