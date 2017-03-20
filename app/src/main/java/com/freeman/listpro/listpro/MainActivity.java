package com.freeman.listpro.listpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PersonAdapter(this);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.my_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = adapter.getPerson(position);
                Toast.makeText(MainActivity.this, "Was cllicked " + person.name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.manu_add){
            int i = (int) (Math.random()*100+1);
            Person person = new Person();
            person.name = "Petya" + i;
            person.phone = "0547378" + i;
            adapter.addPerson(person);
        }
        return super.onOptionsItemSelected(item);
    }
}
