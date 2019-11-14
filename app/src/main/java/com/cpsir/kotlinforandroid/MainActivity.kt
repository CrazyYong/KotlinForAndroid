package com.cpsir.kotlinforandroid

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.cpsir.kotlinforandroid.LiveData.IPresenter
import com.cpsir.kotlinforandroid.LiveData.MainPresenter
import com.cpsir.kotlinforandroid.LiveDataBus.LiveDataBus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var iPresenter : IPresenter

    /*懒加载模式*/
    /**
     * 或者
     * lateinit var lazyBtn:Button
     */
    val lazyBtn by lazy {
        findViewById<Button>(R.id.btn_lazy)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LiveDataBus.get().with("key_test", Boolean::class.java)
            .observe(this, Observer {
                Log.i("LiveData","value:"+it);
            })

        findViewById<Button>(R.id.btn_send).setOnClickListener({
            LiveDataBus.get().with("key_test").value=true
        })
        iPresenter = MainPresenter()
        lifecycle.addObserver(iPresenter)

        lazyBtn?.let {
            it.text="lazyBtn"
            it.textSize=10f
            it.setOnClickListener{
                Toast.makeText(it.context, "lazy测试", Toast.LENGTH_SHORT).show()
            }
        }

        lazyBtn?.gone()
        lazyBtn?.visible()

        /**
         * 在主线程启动一个协程
         */
        GlobalScope.launch(Dispatchers.Main) {
            Log.i("KotlinTest","hghhhhh")
        }

    }

    /**
     * 扩展函数,view隐藏
     */
    fun View.gone(){
        visibility = View.GONE
    }

    /**
     * 扩展函数,view显示
     */
    fun View.visible(){
        visibility = View.VISIBLE
    }



    override fun onDestroy() {
        super.onDestroy()
    }
}
