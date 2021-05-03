package com.example.horizontaldatecalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainActivity extends AppCompatActivity {

    public CircleMenu circleMenu;
    public ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleMenu = findViewById(R.id.circle_menu);
        constraintLayout = findViewById(R.id.my_layout);

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendar_view)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

                circleMenu.setVisibility(View.INVISIBLE);
            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                circleMenu.setVisibility(View.VISIBLE);
                return true;
            }
        });

        circleMenu.setMainMenu(Color.parseColor("#940599"),R.drawable.ic_menu,R.drawable.ic_baseline_cancel_24)
                .addSubMenu(Color.parseColor("#ff8a5c"),R.drawable.ic_task)
                .addSubMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_schedule)
                .addSubMenu(Color.parseColor("#88bef5"),R.drawable.ic_notes)
                .addSubMenu(Color.parseColor("#83e85a"),R.drawable.ic_reminder)
                .addSubMenu(Color.parseColor("#FF4832"),R.drawable.ic_event)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        switch (index){
                            case 0:
                                Toast.makeText(MainActivity.this, "task", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#ecfffb"));
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "schedule", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#96f7d2"));
                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "notes", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#fac4a2"));
                                break;
                            case 3:
                                Toast.makeText(MainActivity.this, "reminder", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#d3cde6"));
                                break;
                            case 4:
                                Toast.makeText(MainActivity.this, "event", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#fff591"));
                                break;
                        }

                    }
                });

    }
}