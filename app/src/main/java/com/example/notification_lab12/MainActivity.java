package com.example.notification_lab12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView lv;int p;
    String names[] = {"bike", "boat", "bus", "car","railway","run"};
    String titles[] = {"Time to travel:6hrs 35min","Time to travel:16hrs 45min","Time to travel:5hrs 30min","Time to travel:4hrs 20min","Time to travel:7hrs 35min","time to travel:10hrs 50min"};
    int picture[]={R.drawable.bike,R.drawable.boat,R.drawable.bus,R.drawable.car,R.drawable.train,R.drawable.run};
    //int images[]={R.drawable.bike,R.drawable.boat,R.drawable.bus,R.drawable.car,R.drawable.train,R.drawable.run};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.list);
        lv.setAdapter(new MyAdapter(this));
    }
    private class MyAdapter extends BaseAdapter { Context mycon;
        public MyAdapter(MainActivity mainActivity) {
            mycon = mainActivity;
        }
        @Override
        public int getCount() {
            return names.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override

        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        { View view = LayoutInflater.from(mycon).inflate(R.layout.activity_page2,
                parent, false);
            ImageView img=view.findViewById(R.id.img);
            img.setImageResource(picture[position]);
            TextView tv= view.findViewById(R.id.textView2);
            tv.setText(names[position]);
            img.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
                builder.setContentTitle(names[position]);
                builder.setContentText(titles[position]);
                builder.setSmallIcon(picture[position]);
                Notification notification=builder.build();

                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(position,notification);
            }
            });
            return view;
        }

    }
}
