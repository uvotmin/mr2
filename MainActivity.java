package com.example.marksapprecord2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.marksapprecord2.utils.MyAppUtils;
import com.example.marksapprecord2.utils.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAppUtils.onClickListenerOpcijePredmeta{

    private Integer position;
    private RecyclerView recycler;
    private RecyclerViewAdapter adapter;
    private String[] predmet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=findViewById(R.id.recycler);
        adapter=new RecyclerViewAdapter(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }

    @Override
    public void onClickOpcijePredmeta(View view) {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        position = (Integer) view.getTag();
        ArrayList<String[]> predmeti = MyAppUtils.getMockData();
        predmet = predmeti.get(position.intValue());
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.menu_card, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Bundle args = new Bundle();
                switch (menuItem.getItemId()){
                    case R.id.dodaj_ocenu:{
                        args.putString(PredmetDijalog.AKCIJA_DIJALOGA,PredmetDijalog.DODAJ_OCENU);
                        PredmetDijalog dijalog = new PredmetDijalog(MainActivity.this);
                        dijalog.setArguments(args);
                        dijalog.show(getSupportFragmentManager(),PredmetDijalog.DODAJ_OCENU);
                        return true;
                    }
                    case R.id.obrisi_ocenu:{
                        args.putString(PredmetDijalog.AKCIJA_DIJALOGA,PredmetDijalog.OBRISI_OCENU);
                        args.putString(PredmetDijalog.OBRISI_OCENU,predmet[1]);
                        PredmetDijalog dijalog = new PredmetDijalog(MainActivity.this);
                        dijalog.setArguments(args);
                        dijalog.show(getSupportFragmentManager(),PredmetDijalog.OBRISI_OCENU);
                        return true;
                    }
                    case R.id.obrisi_predmet:{
                        args.putString(PredmetDijalog.AKCIJA_DIJALOGA,PredmetDijalog.OBRISI_PREDMET);
                        args.putString(PredmetDijalog.OBRISI_PREDMET,predmet[0]);
                        PredmetDijalog dijalog = new PredmetDijalog(MainActivity.this);
                        dijalog.setArguments(args);
                        dijalog.show(getSupportFragmentManager(),PredmetDijalog.OBRISI_PREDMET);
                        return true;
                    }
                    default: return false;
                }
            }
        });
        popup.show();
    }

}