package br.com.livro.google.localbroadcastmanager.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.livro.google.localbroadcastmanager.MainActivity;
import br.com.livro.google.localbroadcastmanager.domain.ClasseDominio;
import br.com.livro.google.localbroadcastmanager.fragaments.FragmentThread;

/**
 * Created by Jose on 19/02/2017.
 */

public class LocalBroadcastMainActivity extends BroadcastReceiver  {

    private MainActivity mainActivity;

    public LocalBroadcastMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String mensagem = intent.getStringExtra(MainActivity.MENSAGEM_KEY);
        mainActivity.logMensagem(mensagem);
    }
}
