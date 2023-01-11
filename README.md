Analytics
===============

Analytics library, it's helps to store your log details from the given data.

### Permission*

### How to integrate into your app ?

Integrating the project is simple, All you need to do is follow the below steps.

Step 1. Add the JitPack repository to your build file. Add it in your **settings.gradle** at the end
of repositories:

>            allProjects {
>              repositories {
>                maven { url "https://jitpack.io" }
>              }
>            }

Step 2. Add the dependency: ( NOTE: Replace the tag with latest version )

>            dependencies {
>                implementation 'com.github.RifluxyssSDK:User-Analytics:1.0'
>            } 

### Quick Start

In order to start using Analytics, Just copy below code to your project and just pass the
required values and that's all you done!...

>        Analytics.init(getApplicationContext(),3);
>        Analytics.insertLog(new Schema("userID","hostID",2.00,"log","eventNBR","assDES","addNBR"));

### Technologies we used

* Java 8
* RetrofitAPI
* Room Database
* Exception Handling

### Description 

* This is a simple and straight forward library for get user analytics through your application usage.

### Authors
* [Rifluxyss Team](http://www.rifluxyss.com/)

### Fork & Star if it helped you.

