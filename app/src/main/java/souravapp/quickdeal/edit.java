package souravapp.quickdeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class edit extends AppCompatActivity {

    TextView tv;
    EditText et;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        String s1=getIntent().getStringExtra("hint");
        String s2=getIntent().getStringExtra("value");
        int pos=getIntent().getIntExtra("pos",0);

        tv =(TextView) findViewById(R.id.tv);
        et =(EditText) findViewById(R.id.et);
        ok =(Button) findViewById(R.id.ok);

        tv.setText(s2);
        et.setHint(s1);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(edit.this,Buyer.class);
                i.putExtra("value",tv.getText().toString());
                i.putExtra("pos",tv.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        ok.performClick();
    }
}
