#通知栏各种玩法

##NotificationSample
网上各种玩法的demo

##知识点

###NotificationManager

###NotificationCompat

###PendingIntent
- 对intent的包装
- pendingintent可以保存创建intent时的context，即使当时的context不存在了，也能从pendingintent里的context执行intent。

###RemoteViews
- 非UI线程
- 从layout文件进行inflate：`new RemoteViews(packageName,R.layout.filename)`
- 提供修改子view的简单方法：`remoteViews.setTextViewText(R.id.view_name, "string");`