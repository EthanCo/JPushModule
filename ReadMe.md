# JPush Module #
集成极光推送的Module

## 使用 ##
###在极光推送官网注册该应用
保证注册的应用包名与要使用的项目包名一致

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

在onResume中添加  

	JPushInterface.onResume(context);

在onPause中添加

	JPushInterface.onPause(context);

###最后
在官网后台推送即可

> 如果通知的内容为空，则在通知栏上不会展示通知。
 但是，这个广播 Intent 还是会有。开发者可以取到通知内容外的其他信息。
