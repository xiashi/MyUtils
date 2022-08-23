package along.com.library.callback;

public interface ICallback<RESULT> {

    void onResult(RESULT result);

    void onError(Throwable error);

}
