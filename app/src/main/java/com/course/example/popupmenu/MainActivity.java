//create a popup menu when a widget i clicked.
//Need 2 listeners. one for click on widdget and the other for the menu item click

package com.course.example.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String urlPass;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);

        // Setting onClick behavior to the textview
        text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, text);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                //set listener for when menu item clicked
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                         @Override
                                                         public boolean onMenuItemClick(MenuItem menuItem) {

                                                             String selectItem = menuItem.getTitle().toString();
                                                             int position = 0;

                                                             //get position clicked
                                                             switch (menuItem.getItemId()) {
                                                                 case R.id.first:
                                                                     position = 0;
                                                                     break;
                                                                 case R.id.second:
                                                                     position = 1;
                                                                     break;
                                                                 case R.id.third:
                                                                     position = 2;
                                                                     break;
                                                                 case R.id.fourth:
                                                                     position = 3;
                                                                     break;
                                                                 case R.id.fifth:
                                                                     position = 4;
                                                                     break;
                                                             }

                                                             //open toast
                                                             Toast.makeText(MainActivity.this, selectItem, Toast.LENGTH_LONG).show();
                                                             //get url for item clicked
                                                             urlPass = Urls.urls[position];

                                                             //open browser
                                                             Uri uri2 = Uri.parse(urlPass);
                                                             Intent i2 = new Intent(Intent.ACTION_VIEW,uri2);
                                                             startActivity(i2);
                                                             return true;
                                                         };

                                                     });
                // Showing the popup menu
                popupMenu.show();
            }
        });
    } //onCreate
    
}