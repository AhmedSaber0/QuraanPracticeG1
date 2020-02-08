package com.route.quraanpractice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.route.quraanpractice2.fragment.BaseActivity;

public class SurasActivity extends BaseActivity {

    public static  String []ArSuras={"الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
            ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
            ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
            ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
            ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
            ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
            ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
            ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
            ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
            "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"};
    RecyclerView surasRecyclerView;
    SurasAdapter surasAdapter;
RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras);

        surasRecyclerView = findViewById(R.id.surasRecyclerView);
        surasAdapter = new SurasAdapter(ArSuras);
        layoutManager = new GridLayoutManager(this, 3, RecyclerView.HORIZONTAL, false);

        surasAdapter.setOnItemClickListesner(new SurasAdapter.OnItemClickListesner() {
            @Override
            public void onItemClick(String title, int position) {
//                Intent intent = new Intent(SurasActivity.this, VersesActivity.class);
//                intent.putExtra("title", title);
//                intent.putExtra("position", position);
//                startActivity(intent);


        showAlertDialog("suras", "suras message",
                R.string.yes,
                R.string.no,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.w("click", "yes");
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.w("click", "no");
                    }
                });
            }
        });

        surasRecyclerView.setLayoutManager(layoutManager);
        surasRecyclerView.setAdapter(surasAdapter);
    }


}
