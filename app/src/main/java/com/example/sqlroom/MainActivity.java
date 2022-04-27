package com.example.sqlroom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Personne> personneList=new ArrayList<>();
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView ls= findViewById(R.id.list);
        appDatabase=AppDatabase.getInstance(this);
        List<Personne> list1= appDatabase.personneDao().getAll();
        ArrayList<String> list= convert((ArrayList<Personne>) list1);
        ArrayAdapter adapter=new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,list
        );
        ls.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void Enregistrer(View view){
        TextView nom= findViewById(R.id.editxtname);
        ListView ls= findViewById(R.id.list);
        Personne personne=new Personne();
        personne.setFirstName(nom.getText().toString());
        appDatabase.personneDao().insert(personne);
        List<Personne> arrayList= appDatabase.personneDao().getAll();
        ArrayList<String> list= convert((ArrayList<Personne>)arrayList);
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ls.setAdapter(adapter);
        nom.setText("");
    }
    public void Supprimer(){

    }
    public void Update(){

    }
    ArrayList<String> convert (ArrayList<Personne> arrayList){
        ArrayList<String> list= new ArrayList<>();
        for(int i=0; i<arrayList.size(); i++){
            list.add(arrayList.get(i).getId()+":"+arrayList.get(i).getFirstName());
        }
        return list;
    }
}