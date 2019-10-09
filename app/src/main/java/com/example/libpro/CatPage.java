package com.example.libpro;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CatPage extends AppCompatActivity {
    String catname = "" ;
    private DatabaseReference db ,key;
    ListView listViewbooks ;
    ArrayAdapter bookadapter ;
    //String key ;
    private List <String> books = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_page);
        catname = getIntent().getStringExtra("Catname");
        setTitle(catname);
        listViewbooks =  (ListView) findViewById(R.id.catbooks);
        db = FirebaseDatabase.getInstance().getReference("projLib/Books/"+catname);

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    books.add(ds.getValue().toString());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        bookadapter = new ArrayAdapter (this,android.R.layout.simple_list_item_1,books);
        listViewbooks.setAdapter(bookadapter);

    }
}
