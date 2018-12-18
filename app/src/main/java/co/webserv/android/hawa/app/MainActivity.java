package co.webserv.android.hawa.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import co.webserv.android.hawa.library.WsActivity;

public class MainActivity extends WsActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.setSettings(new Settings());
        super.onCreate(savedInstanceState);
    }
}
