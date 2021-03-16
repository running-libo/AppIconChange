package com.example.appiconchange

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mPackageManager: PackageManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPackageManager = applicationContext.packageManager

        ivIconFesterval.setOnClickListener {
            var festervalIcon = ComponentName(baseContext, "com.example.appiconchange.mainActivity")
            enableComponent(festervalIcon)
            disableComponent(componentName)
        }

        ivIconNomal.setOnClickListener {
            var nomalIcon = ComponentName(baseContext, "com.example.appiconchange.MainActivity")
            enableComponent(nomalIcon)
            disableComponent(componentName)
        }
    }

    //启用组件
    private fun enableComponent(componentName: ComponentName){
        mPackageManager?.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
        )
    }

    //隐藏组件
    private fun disableComponent(componentName: ComponentName){
        mPackageManager?.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
    }
}