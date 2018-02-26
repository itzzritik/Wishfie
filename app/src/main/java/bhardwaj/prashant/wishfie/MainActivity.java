package bhardwaj.prashant.wishfie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity
{
    RecyclerView trending,top,top_tags,top_creators,top_opinions;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------------------------------------------------------------------------------------------------

        Bitmap trending_pic[]={BitmapFactory.decodeResource(getResources(),R.mipmap.ironman),
                BitmapFactory.decodeResource(getResources(),R.mipmap.batman),
                BitmapFactory.decodeResource(getResources(),R.mipmap.spiderman),
                BitmapFactory.decodeResource(getResources(),R.mipmap.flash)};
        String trending_topic[]={"Iron Man","Batman","Spiderman","flash"},
                trending_name[]={"Ritik","Prashant","Aditya","Varun"};

        trending=findViewById(R.id.trending);
        trending.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        trending.setAdapter(new Adapter(trending_topic,trending_name,trending_pic,trending_pic));

        top=findViewById(R.id.top);
        top.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        top.setAdapter(new Adapter(trending_topic,trending_name,trending_pic,trending_pic));

        //-----------------------------------------------------------------------------------------------------------

        String top_tagNames[]={"Sports","Politics","Entertainment","Hypothetical","Technology","Games","Tourism","Food"};
        top_tags=findViewById(R.id.top_tags);
        top_tags.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        top_tags.setAdapter(new TagAdapter(MainActivity.this,top_tagNames));

        //-----------------------------------------------------------------------------------------------------------

        String opinion[]={"175","145","133","101"};
        top_creators=findViewById(R.id.top_creators);
        top_creators.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        top_creators.setAdapter(new CreatorAdapter(MainActivity.this,trending_pic,trending_name,opinion));

        //-----------------------------------------------------------------------------------------------------------

        top_opinions=findViewById(R.id.top_opinions);
        top_opinions.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        top_opinions.setAdapter(new Adapter(trending_topic,trending_name,trending_pic,trending_pic));
    }
}
