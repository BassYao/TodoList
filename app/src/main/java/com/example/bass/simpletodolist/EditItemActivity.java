package com.example.bass.simpletodolist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;
import android.content.*;
public class EditItemActivity extends ActionBarActivity {
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String text = getIntent().getStringExtra("text");
        pos = getIntent().getIntExtra("position",0);
        EditText etEditItem = (EditText)findViewById(R.id.etEditItem);
        etEditItem.setText("");
        etEditItem.append(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void returnTodoItem(View v) {

        EditText etEditItem = (EditText)findViewById(R.id.etEditItem);
        Intent i = new Intent();
        i.putExtra("text", etEditItem.getText().toString()); // pass arbitrary data to launched activity
        i.putExtra("position", pos);
        setResult(RESULT_OK, i);
        finish();
    }
}
