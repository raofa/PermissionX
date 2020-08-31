package com.raofa.permissionx

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.raofa.library.PermissionX

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        PermissionX.request(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_COARSE_LOCATION)) { allGranted, deniedList ->
            if(allGranted){
                Toast.makeText(this,"all permission granted",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"you denied $deniedList",Toast.LENGTH_SHORT).show()
            }

        }
    }
}
