package com.raofa.library.permission

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment


const val PERMISSION_CODE = 1
const val SETTING_CODE = 2

typealias PermissionCallback = (Boolean,List<String>) -> Unit
        
class PermissionXFragment : Fragment() {

    private var callback : PermissionCallback? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
    
    fun requestNow( callback: PermissionCallback,vararg permissions: String){
        this.callback = callback
        requestPermissions(permissions,
            PERMISSION_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_CODE){
            val deniesList = ArrayList<String>()
            
            for ((index,result) in grantResults.withIndex()){
                if (result != PackageManager.PERMISSION_GRANTED){
                    deniesList.add(permissions[index])
                }
            }
            val allGranted = deniesList.isEmpty()
            callback?.let { 
                it(allGranted,deniesList)
            }
        }
    }
}
