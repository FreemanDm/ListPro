package com.freeman.listpro.listpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Freeman on 05.01.2017.
 */

public class PersonAdapter extends BaseAdapter{
    private ArrayList<Person> persons = new ArrayList<>();
    private Context context;

    public PersonAdapter(Context context) {
        this.context = context;
    }

    public void addPerson (Person person){
        persons.add(0, person);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        TextView nameTxt = (TextView) view.findViewById(R.id.name_txt);
        TextView phoneTxt = (TextView) view.findViewById(R.id.phone_txt);
        nameTxt.setText(getPerson(position).name);
        phoneTxt.setText(getPerson(position).phone);
        return view;
    }

    public Person getPerson(int position){
        return persons.get(position);
    }
}
