package co.webserv.android.hawa.library;

public abstract class WsSettings {

    public abstract String getAppUrl();

    public boolean getIgnoreSslErrors() {
        return false;
    }

    public boolean getLogDebug() {
        return true;
    }
}
