package com.raofa.library

import androidx.fragment.app.FragmentActivity

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/08/31 16:16
 * @description:
 */
object PermissionX {
    
    private const val TAG = "PermissionX"
    
    fun request(activity: FragmentActivity,permissions: Array<String>, callback: PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        
        val fragment = if(existedFragment != null) {
            existedFragment as PermissionXFragment
        }else {
            val permissionXFragment = PermissionXFragment()
            fragmentManager.beginTransaction().add(permissionXFragment,TAG).commitNow()
            permissionXFragment
        }
        
        fragment.requestNow(permissions, callback)
    }
}