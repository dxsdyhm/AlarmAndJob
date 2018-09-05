# AlarmAndJob [![Build Status](https://travis-ci.org/dxsdyhm/AlarmAndJob.svg?branch=master)](https://travis-ci.org/dxsdyhm/AlarmAndJob) [![](https://jitpack.io/v/dxsdyhm/AlarmAndJob.svg)](https://jitpack.io/#dxsdyhm/AlarmAndJob)
允许自启动与电量设置跳转  

> 如果发现某些机型出现问题，欢迎反馈issue
> 如果有补充已有机型的Data,可以pull，共同完善

[下载地址][dowmload]

* add some plugins in project  build.gradle like this
```gradle
    allprojects {
	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
    }
```

* in your app build.gradle
```gradle
    dependencies {
        compile 'com.github.dxsdyhm:AlarmAndJob:latestVersion'
    }
```


## 使用
```java
    try {
        AutoStartUtils.newInstance(context).toTargetActivity();
    } catch (Exception e) {
        e.printStackTrace();
        Toast.makeText(context,"无法自动跳转!!!!！",Toast.LENGTH_LONG).show();
    }
```

[dowmload]:http://fir.im/ykfu
