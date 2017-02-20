package br.com.livro.google.localbroadcastmanager.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.livro.google.localbroadcastmanager.domain.ClasseDominio;

/**
 * Created by Jose on 19/02/2017.
 */

public class LocalBroadcastClasseDominio extends BroadcastReceiver  {

    private ClasseDominio classeDominio;

    public LocalBroadcastClasseDominio(ClasseDominio classeDominio) {
        this.classeDominio = classeDominio;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String mensagem = intent.getStringExtra(ClasseDominio.MENSAGEM_KEY);
        classeDominio.logMensagem(mensagem);
    }
}
