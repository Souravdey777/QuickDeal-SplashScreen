package souravapp.quickdeal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Seller extends AppCompatActivity {
         ListView lv;
         Context context;

    public static int [] OPTION_IMAGES={R.drawable.profile_icon,
        android.R.drawable.sym_action_email,
        R.drawable.callicon,
        R.drawable.location_icon
        };
    public static String [] OPTIONS={"Full Name","Email Address","Phone Numer","City","Type","Category"};
    public static String [] Inputhint={"Enter Your Number","Enter Your Mail ID","Enter Your Phone Number","Location","Enter Your Type","Enter Your Category"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);


        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter1(this, OPTIONS,Inputhint,OPTION_IMAGES));

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        }
}

class CustomAdapter1 extends BaseAdapter {
    String [] VALUE_TYPED;
    String [] INPUT;
    Activity context;
    int [] IMAGE_ID;
    private static LayoutInflater inflater=null;
    public CustomAdapter1(final Seller activity, String[] Option, String[] Input_hint, int[] Images) {
        // TODO Auto-generated constructor stub
        VALUE_TYPED=Option;
        INPUT=Input_hint;
        context=activity;
        IMAGE_ID=Images;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return VALUE_TYPED.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img,img2;
        EditText editText;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub


        final Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_view, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.img2 = (ImageView) rowView.findViewById(R.id.imageView2);
        holder.editText = (EditText) rowView.findViewById(R.id.edittext1);
        holder.tv.setText(VALUE_TYPED[position]);
        holder.img.setImageResource(IMAGE_ID[position]);
        holder.img2.setImageResource(R.drawable.editicon);
        holder.editText.setText(INPUT[position]);

        holder.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, " You Clicked " + VALUE_TYPED[position], Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, edit.class);
                i.putExtra("hint", INPUT[position]);
                i.putExtra("value", VALUE_TYPED[position]);
                context.startActivity(i);
                context.finish();
            }
        });
        return rowView;
    }
}