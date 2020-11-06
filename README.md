添加如下配置：

root gradle

```groovy
    maven { url 'https://jitpack.io' }
```

app.gradle

```groovy
    implementation 'com.github.raofa:PermissionX:1.00'
```

使用方法：

example

```kotlin
    PermissionX.request(this, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_COARSE_LOCATION) { allGranted, deniedList ->
            if(allGranted){
                Toast.makeText(this,"all permission granted",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"you denied $deniedList",Toast.LENGTH_SHORT).show()
            }

        }
```