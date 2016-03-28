# JPush Module #
集成极光推送的Module

## 使用 ##
###在极光推送官网注册该应用
保证注册的应用报名与要使用的项目报名一致

###在jpushlib的manifest中  

设置 JPUSH_CHANNEL和 JPUSH_APPKEY 的值 (已用TODO标记出)  

		<!-- TODO 统计数据通道-->
        <meta-data
            android:name="JPUSH_CHANNEL"
            android:value="EthanCo-JpushTest" />

        <!-- TODO 设置为开发者平台取得的AppKey-->
        <meta-data
            android:name="JPUSH_APPKEY"
            android:value="c8d5026db7667ad12341f5e4" />

###在Application中添加  

	    JPushInterface.setDebugMode(BuildConfig.DEBUG); //是否开启Debug模式
        JPushInterface.init(this); //初始化极光推送

###在所有的Activity中添加  
> 此步骤可以不添加，但在debug版本会出现以下toast提示，并且在后台数据查看中统计用户使用时间的值可能就会不准确。  
> 在release版本中，不会出现toast提示  
> [不添加此步骤会出现的问题](https://www.jpush.cn/qa/?qa=2976/jupsh%E6%8F%90%E7%A4%BA-%E7%BC%BA%E5%B0%91%E7%BB%9F%E8%AE%A1%E4%BB%A3%E7%A0%81)

在onResume中添加  

	JPushInterface.onResume();

在onPause中添加

	JPushInterface.onPause();

###最后
在官网后台推送即可