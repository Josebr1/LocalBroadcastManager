package br.com.livro.google.localbroadcastmanager.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.livro.google.localbroadcastmanager.services.ServiceTest;

/**
 * Created by Jose on 19/02/2017.
 */

public class LocalBroadcastServiceTest extends BroadcastReceiver  {

    private ServiceTest service;

    public LocalBroadcastServiceTest(ServiceTest service) {
        this.service = service;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String mensagem = intent.getStringExtra(ServiceTest.MENSAGEM_KEY);
        service.logMensagem(mensagem);
    }
}
