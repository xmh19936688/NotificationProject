#通知栏各种玩法

##NotificationSample
网上各种玩法的demo

##SimpleNotificationDemo
简单的通知实现

##CustomNotificationDemo
自定义通知栏demo，实现自定义view与动态更新通知内容

##知识点

###Notification

####flag
- `FLAG_AUTO_CANCEL`用户点击时消失
- `FLAG_FOREGROUND_SERVICE`表示正在运行一个服务
- `FLAG_INSISTENT`通知铃声会重复响直到通知被取消或通知窗口被打开
- `FLAG_NO_CLEAR`当用户点击清除所有时该通知不被清除
- `FLAG_ONGOING_EVENT`该通知被正在运行的事件所引用（比如正在通话）
- `FLAG_ONLY_ALERT_ONCE`该通知每次发送时都震动或播放通知铃声，即使之前发送的该通知未取消
- `FLAG_SHOW_LIGHTS`发送该通知时打开呼吸灯

####default
- `DEFAULT_SOUND`使用默认通知声音
- `DEFAULT_VIBRATE`使用默认震动效果
- `DEFAULT_LIGHTS`使用默认通知呼吸灯
- `DEFAULT_ALL`全部使用默认


###NotificationManager

###NotificationCompat.Builder
- `setAutoCancel(boolean autoCancel)`是否用户点击后消失
- `setContent(RemoteViews views)`自定义通知的view
- `setContentInfo(CharSequence info)`显示在右边的文本（时间下面）
- `setNumber(int number)`显示在右边的数字（时间下面，如果调用了setContentInfo，则此设置不生效）
- `setContentIntent(PendingIntent intent)`设置点击通知后的intent
- `setDeleteIntent(PendingIntent intent)`设置用户直接移除该通知后的intent
- `setFullScreenIntent(PendingIntent intent, boolean highPriority)`An intent to launch instead of posting the notification to the status bar
- `setLargeIcon(Bitmap icon)`显示在通知栏的icon
- `setSmallIcon (int icon, int level)`显示在通知栏的icon，尺寸较小
- `setContentTitle(CharSequence title)`通知标题，icon的右边上部
- `setContentText(CharSequence text)`通知文本，icon的右边下部
- `setLights(int argb, int onMs, int offMs)`设置呼吸灯，依次为argb色值，亮起持续毫秒数，熄灭持续毫秒数
- `setOngoing(boolean ongoing)`如果是正在进行中的通知，则不能被移除
- `setOnlyAlertOnce(boolean onlyAlertOnce)`如果该通知正在显示，则再发通知不会触发铃声，震动，ticker
- `setPriority(int pri)`优先级
- `setProgress(int max, int progress, boolean indeterminate)`进度
- `setSound (Uri sound)`通知铃声Uri，在默认音频流播放
- `setSound (Uri sound, int streamType)`通知铃声Uri，在指定音频流播放
- `setStyle (NotificationCompat.Style style)`设置通知样式
- `setSubText (CharSequence text)`设置第三行文本（与progress冲突）
- `setTicker (CharSequence tickerText, RemoteViews views)`发通知时在系统栏显示的文本和view
- `setTicker (CharSequence tickerText)`发通知时在系统栏显示的文本
- `setUsesChronometer (boolean b)`显示自动计时器
- `setVibrate (long[] pattern)`设置震动效果
- `setWhen (long when)`设置通知发送时间
- `addAction (int icon, CharSequence title, PendingIntent intent)`在底部扩展一块位置显示这个按钮,最多三个

###PendingIntent
- 对intent的包装
- pendingintent可以保存创建intent时的context，即使当时的context不存在了，也能从pendingintent里的context执行intent。

###RemoteViews
- 非UI线程
- 从layout文件进行inflate：`new RemoteViews(packageName,R.layout.filename)`
- 提供修改子view的简单方法：`remoteViews.setTextViewText(R.id.view_name, "string");`