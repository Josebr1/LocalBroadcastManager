package br.com.livro.google.localbroadcastmanager.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.livro.google.localbroadcastmanager.fragaments.FragmentThread;
import br.com.livro.google.localbroadcastmanager.services.ServiceTest;

/**
 * Created by Jose on 19/02/2017.
 */

public class LocalBroadcastFragment extends BroadcastReceiver  {

    private FragmentThread fragment;

    public LocalBroadcastFragment(FragmentThread fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String mensagem = intent.getStringExtra(FragmentThread.MENSAGEM_KEY);
        fragment.logMensagem(mensagem);
    }
}
