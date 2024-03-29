# MyUtils
Android开发中常用的工具类集合

# gradle使用方式

Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


Step 2. Add the dependency

    dependencies {
	        implementation 'com.github.xiashi:MyUtils:1.0.4'
	}

# 常用工具类
```
使用示例:
AppUtils.getAppName(MainActivity.this,"along.com.myutils");
```

## library Module中的类：

- AppUtil.java 应用工具类
    * getAppName 获取应用名称
    * getAppIcon 获取应用图标
    * getAppFirstInstallTime 获取应用第一次安装日期
    * getAppLastUpdateTime 获取应用更新日期
    * getAppSize 获取应用大小
    * getAppApk 获取应用apk文件
    * getAppVersionName 获取应用版本名称
    * getAppVersionCode 获取应用版本号
    * getAppInstaller 获取应用的安装市场
    * getAppSign 获取应用签名
    * getAppTargetSdkVersion 获取应用兼容sdk
    * getAppUid 获取应用uid
    * getNumCores 获取Cpu内核数
    * getRootPermission 获得root权限
    * getAppPermissions 获取应用的所有权限
    * hasPermission 是否有权限
    * isInstalled 应用是否安装
    * ~~installApk 安装应用~~
    * ~~uninstallApk 卸载应用~~
    * isSystemApp 是否是系统应用
    * isServiceRunning 服务是否在运行
    * stopRunningService 停止服务
    * killProcesses 结束进程
    * runScript 运行脚本
    * runApp 启动应用
    * cleanCache 清除应用内部缓存
    * cleanDatabases 清除应用内部数据库
    * cleanSharedPreference 清除应用内部SP


- EncryptionUtil.java 密码工具类
    * md5(String input) 字符串md5
    * md5L(String input) 字符串md5,返回小写密文
    * md5(InputStream in) 输入流md5
    * base64Encode Base64加密
    * base64Decode Base64解密
    * XorEncode 异或加密
    * XorDecode 异或解密
    * sha1 字符串sha1值
    * sha1 文件hash校验

- MapUtil.java GPS坐标转换工具
    * 百度坐标（BD09）、国测局坐标（火星坐标，GCJ02）、和WGS84坐标系之间的转换的工具
    * bd09towgs84 百度坐标系(BD-09)转WGS坐标(百度坐标纬度,百度坐标经度),WGS84坐标数组
    * wgs84tobd09 WGS坐标转百度坐标系(BD-09)(WGS84坐标系的经度,WGS84坐标系的纬度),百度坐标数组
    * gcj02tobd09 火星坐标系(GCJ-02)转百度坐标系(BD-09)(火星坐标经度,火星坐标纬度),百度坐标数组
    * bd09togcj02 百度坐标系(BD-09)转火星坐标系(GCJ-02)(百度坐标纬度,百度坐标经度),火星坐标数组
    * wgs84togcj02 WGS84转GCJ02(火星坐标系)(WGS84坐标系的经度,WGS84坐标系的纬度),火星坐标数组
    * gcj02towgs84 GCJ02(火星坐标系)转GPS84(火星坐标系的经度,火星坐标系纬度),WGS84坐标数组
    * transformlat 纬度转换
    * transformlng 经度转换
    * out_of_china 判断是否在国内，不在国内不做偏移

- DateUtil.java 日期工具类
    * formatDataTime 格式化日期时间
    * formatDate 格式化日期
    * formatTime 格式化时间
    * formatDateCustom 自定义格式的格式化日期时间
    * string2Date 将时间字符串转换成Date
    * getDate 获取系统日期
    * getTime 获取系统时间
    * getDateTime 获取系统日期时间
    * subtractDate 计算两个时间差
    * getDateAfter 得到几天后的时间
    * getWeekOfMonth 获取当前时间为本月的第几周
    * getDayOfWeek 获取当前时间为本周的第几天

- DensityUtil.java 屏幕工具类
    * dip2px dp转像素
    * dip2sp dip转sp
    * px2dip 像素转dp
    * px2sp 像素转sp
    * sp2px sp转像素
    * sp2dip sp转dip
    * getScreenW 获取屏幕宽度
    * getScreenH 获取屏幕高度
    * getScreenRealSize 获取屏幕的真实高度
    * getStatusBarH 获取状态栏高度
    * getNavigationBarrH 获取导航栏高度

- DeviceUtils.java 设备信息工具
    * getAndroidID 获取AndroidID
    * getIMEI 获取设备IMEI码
    * getIMSI 获取设备IMSI码
    * getWifiMacAddr 获取MAC地址
    * getIP 获取网络IP地址(优先获取wifi地址)
    * getWifiIP 获取WIFI连接下的ip地址
    * getGPRSIP 获取GPRS连接下的ip地址
    * getSerial 获取设备序列号
    * getSIMSerial 获取SIM序列号
    * getMNC 获取网络运营商 46000,46002,46007 中国移动,46001 中国联通,46003 中国电信
    * getCarrier 获取网络运营商：中国电信,中国移动,中国联通
    * getModel 获取硬件型号
    * getBuildBrand 获取编译厂商
    * getBuildHost 获取编译服务器主机
    * getBuildTags 获取描述Build的标签
    * getBuildTime 获取系统编译时间
    * getBuildUser 获取系统编译作者
    * getBuildVersionRelease 获取编译系统版本(5.1)
    * getBuildVersionCodename 获取开发代号
    * getBuildVersionIncremental 获取源码控制版本号
    * getBuildVersionSDK 获取编译的SDK
    * getBuildID 获取修订版本列表(LMY47D)
    * getSupportedABIS CPU指令集
    * getManufacturer 获取硬件制造厂商
    * getBootloader 获取系统启动程序版本号
    * getScreenDisplayID
    * getDisplayVersion 获取系统版本号
    * getLanguage 获取语言
    * getCountry 获取国家
    * getOSVersion 获取系统版本:5.1.1
    * getGSFID 获取GSF序列号
    * getBluetoothMAC 获取蓝牙地址
    * getPsuedoUniqueID Android设备物理唯一标识符
    * getFingerprint 构建标识,包括brand,name,device,version.release,id,version.incremental,type,tags这些信息
    * getHardware 获取硬件信息
    * getProduct 获取产品信息
    * getDevice 获取设备信息
    * getBoard 获取主板信息
    * getRadioVersion 获取基带版本(无线电固件版本 Api14以上)
    * getUA 获取的浏览器指纹(User-Agent)
    * getDensity 获取得屏幕密度
    * getGoogleAccounts 获取google账号


- NetUtil.java 网络工具
    * getNetworkType 获取网络类型
    * getNetworkTypeName 获取网络名称
    * isConnected 检查网络状态
    * isNetworkAvailable 网络可用性
    * isWiFi 是否wifi
    * openNetSetting 打开网络设置界面
    * setWifiEnabled 设置wifi状态
    * setDataEnabled 设置数据流量状态
    * getWifiScanResults 获取wifi列表
    * getScanResultsByBSSID 过滤扫描结果
    * getWifiConnectionInfo 获取wifi连接信息

- RadixUtil 进制工具类
    * hexString2binaryString 16->2
    * binaryString2hexString 2->16
    * addBinary 二进制相加

- StringUtil.java 字符串工具
    * getChsAscii 汉字转成ASCII码
    * convert 单字解析
    * getSelling 词组解析
    * parseEmpty 将null转化为""
    * isEmpty 是否是空字符串
    * chineseLength 中文长度
    * strLength 字符串长度
    * subStringLength 获取指定长度的字符所在位置
    * isChinese 是否是中文
    * isContainChinese 是否包含中文
    * strFormat2 不足2位前面补0
    * convert2Int 类型安全转换
    * decimalFormat 指定小数输出

- SystemUtil.java 系统工具
    * sendSMS 调用系统发送短信
    * forwardToDial 跳转到拨号
    * sendMail 发邮件
    * openWeb 打开浏览器
    * openContacts 打开联系人
    * openSettings 打开系统设置
    * hideKeyBoard 隐藏系统键盘
    * isBackground 判断当前应用程序是否后台运行
    * isSleeping 判断手机是否处理睡眠
    * installApk 安装apk
    * isRooted 是否root
    * isRunningOnEmulator 当前设备是否是模拟器
    * goHome 返回Home
    * hexdigest 32位签名
    * getDeviceUsableMemory 获取设备可用空间
    * gc 清理后台进程和服务
    * getProcessName 获取进程名字
    * createDeskShortCut 创建桌面快捷方式
    * createShortcut 创建快捷方式
    * shareText 分享文本
    * shareFile 分享文件(此方法是调用FileUtils.shareFile中的方式)
    * getShareTargets 获取可接受分享的应用
    * getCurrentLanguage 获取当前系统的语言
    * getLanguage 获取当前系统的语言
    * isGpsEnabled GPS是否打开
    * showSoftInputMethod 显示软键盘
    * closeSoftInputMethod 关闭软键盘
    * showSoftInput 显示软键盘
    * closeSoftInput 关闭软键盘
    * toWeChatScan 打开微信扫描
    * toAliPayScan 打开支付宝扫描
    * toAliPayPayCode 打开支付宝支付码
    * getRandomNumber 获取随机数

- MatchUtil.java 验证工具类
    * matcherRealName 判断姓名格式
    ```
    真实姓名可以是汉字,也可以是字母,但是不能两者都有,也不能包含任何符号和数字
    1.如果是英文名,可以允许英文名字中出现空格
    2.英文名的空格可以是多个,但是不能连续出现多个
    3.汉字不能出现空格
    ```
    * matcherPhoneNum 判断手机号格式  (匹配11数字,并且13-19开头)
    * matcherAccount 判断账号格式 (4-20位字符)
    * matcherPassword 判断密码格式 (6-12位字母或数字)
    * matcherPassword2 判断密码格式 (6-12位字母或数字,必须同时包含字母和数字)
    * matcherEmail 判断邮箱格式
    * matcherIP 判断IP地址
    * matcherUrl 判断URL (http,https,ftp)
    * matcherVehicleNumber 判断中国民用车辆号牌
    * matcherIdentityCard 判断身份证号码格式
    * isNumeric 是否数值型
    * testRegex 是否匹配正则
    * checkPostcode 匹配中国邮政编码


# 这个库参考了众多网络的中的代码,在此对这些无私奉献的人致以最诚挚的感谢。

特别鸣谢 [h4de5ing](https://github.com/h4de5ing/AndroidCommon)
---
License
----

      Copyright (C)  2016 android@19code.com

      Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
      You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.


---
@author wenlong.Xia (xiawenlong20@hotmail.com)

@version version 2019-07-10

