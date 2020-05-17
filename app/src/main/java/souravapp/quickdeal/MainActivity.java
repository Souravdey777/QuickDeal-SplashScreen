package souravapp.quickdeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
Button BUYER, SELLER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout logo = (RelativeLayout)findViewById(R.id.logo);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.moveup);
        logo.startAnimation(anim);

        RelativeLayout option = (RelativeLayout)findViewById(R.id.option);
        Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.moveup2);
        option.startAnimation(anim2);

        BUYER = (Button)findViewById(R.id.buyer);
        SELLER = (Button)findViewById(R.id.seller);

        BUYER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Buyer.class));
            }
        });
        SELLER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Seller.class));
            }
        });
    }
}
