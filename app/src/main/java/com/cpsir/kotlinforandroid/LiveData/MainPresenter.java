package com.cpsir.kotlinforandroid.LiveData;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;
import org.jetbrains.annotations.NotNull;

/**
 * @author Create by cpSir on 2019/11/10
 */
public class MainPresenter implements IPresenter {
    @Override
    public void onCreate(@NotNull LifecycleOwner owner) {
        Log.i("MainPresenter","onCreate");
    }

    @Override
    public void onDestroy(@NotNull LifecycleOwner owner) {
        Log.i("MainPresenter","onDestroy");
    }

    @Override
    public void onLifecycleChanged(@NotNull LifecycleOwner owner, @NotNull Lifecycle.Event event) {
        Log.i("MainPresenter","onLifecycleChanged");
    }
}
