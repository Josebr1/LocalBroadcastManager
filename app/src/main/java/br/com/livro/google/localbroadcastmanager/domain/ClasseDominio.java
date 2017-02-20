package br.com.livro.google.localbroadcastmanager.domain;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import br.com.livro.google.localbroadcastmanager.MainActivity;
import br.com.livro.google.localbroadcastmanager.broadcasts.LocalBroadcastClasseDominio;
import br.com.livro.google.localbroadcastmanager.broadcasts.LocalBroadcastFragment;
import br.com.livro.google.localbroadcastmanager.services.ServiceTest;

/**
 * Created by Jose on 19/02/2017.
 */

public class ClasseDominio {

    private Context context;
    public static final String FILTRO_KEY = "ClasseDominio_KEY";
    public static final String MENSAGEM_KEY = "ClasseDominio_MENSAGEM_KEY";

    private LocalBroadcastClasseDominio broadcast;

    public ClasseDominio(Context context) {
        this.context = context;

        broadcast = new LocalBroadcastClasseDominio(this);
        IntentFilter intentFilter = new IntentFilter(FILTRO_KEY);
        LocalBroadcastManager
                .getInstance(context)
                .registerReceiver(broadcast, intentFilter);
    }

    public void logMensagem(String mensagem){
        mensagem += "MainActivity: mensagem ok.<br>";

        Intent intent = new Intent();
        intent.setAction(MainActivity.FILTRO_KEY);
        intent.putExtra(MainActivity.MENSAGEM_KEY, mensagem);
        LocalBroadcastManager
                .getInstance(context)
                .sendBroadcast(intent);
    }


    public void destroy(){
        LocalBroadcastManager
                .getInstance(context)
                .unregisterReceiver(broadcast);
    }


}
