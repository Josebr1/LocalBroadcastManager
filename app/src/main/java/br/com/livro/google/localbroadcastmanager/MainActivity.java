package br.com.livro.google.localbroadcastmanager;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import br.com.livro.google.localbroadcastmanager.broadcasts.LocalBroadcastMainActivity;
import br.com.livro.google.localbroadcastmanager.domain.ClasseDominio;
import br.com.livro.google.localbroadcastmanager.fragaments.FragmentThread;
import br.com.livro.google.localbroadcastmanager.services.ServiceTest;

public class MainActivity extends AppCompatActivity {

    private ClasseDominio classeDominio;
    public static final String FILTRO_KEY = "MainActivity_KEY";
    public static final String MENSAGEM_KEY = "MainActivity_MENSAGEM_KEY";

    private LocalBroadcastMainActivity broadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* SERVICE */
        Intent intent = new Intent(this, ServiceTest.class);
        startService(intent);

        /* FRAGMENT */
        if(savedInstanceState == null){
            FragmentThread fragmentThread = new FragmentThread();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(fragmentThread, FragmentThread.KEY);
            ft.commit();
        }

        /* DOMAIN */
        classeDominio = new ClasseDominio(this);

        /* INTENT FILTER */
        broadcast = new LocalBroadcastMainActivity(this);
        IntentFilter intentFilter = new IntentFilter(MainActivity.FILTRO_KEY);
        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(broadcast, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        classeDominio.destroy();

        LocalBroadcastManager
                .getInstance(this)
                .unregisterReceiver(broadcast);

        Intent intent = new Intent(this, ServiceTest.class);
        stopService(intent);


    }

    public void cicloMensagem(View view){
        Intent intent = new Intent(ServiceTest.FILTRO_KEY);
        intent.putExtra(ServiceTest.MENSAGEM_KEY, "ServiceTest: mensagem ok.<br>");
        LocalBroadcastManager
                .getInstance(this)
                .sendBroadcast(intent);
    }

    public void logMensagem(String mensagem){
        TextView view = (TextView) findViewById(R.id.tv_conteudo);
        view.setText(Html.fromHtml(mensagem));
    }
}
