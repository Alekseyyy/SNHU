# timer

Author: Loic Shema
Location: https://play.picoctf.org/events/72/challenges/challenge/381

## Problem

> You will find the flag after analysing this apk Download here.

This problem comes with an Android .apk file called ``timer.apk`` ([download it here](./timer.apk)). It also came with two hints: the first was simply just "decompile" and the second is "mobsf or jadx."

## Solution
I briefly looked up a decompiler tool for Android .apk files, and came across ``apktool`` [1]. I decompiled the ``timer.apk`` like so:

```
Z:\sundries\ctf\2023\picoCTF\timer>apktool d timer.apk
I: Using Apktool 2.7.0 on timer.apk
I: Loading resource table...
I: Decoding AndroidManifest.xml with resources...
I: Loading resource table from file: C:\Users\Aleksey\AppData\Local\apktool\framework\1.apk
I: Regular manifest package...
I: Decoding file-resources...
I: Decoding values */* XMLs...
I: Baksmaling classes.dex...
I: Baksmaling classes3.dex...
I: Baksmaling classes2.dex...
I: Copying assets and libs...
I: Copying unknown files...
I: Copying original files...

FLARE [redacted]
Z:\sundries\ctf\2023\picoCTF\timer>
```

The results of running ``apktool`` on ``timer.apk`` resulted in a directory called ``timer`` (that I renamed to ``src``) --- which contains Android disassembly code in the form of smali code. __NOTE__ that I deleted some of the ``smali`` output because it seemed to disassemble copyrighted code, and I am trying to avoid a lawsuit. I went through the disassembly, and found the smali file with the flag. It is in the smali file located in

```
./timer/smali_classes3/com/example/timer/BuildConfig.smali
```

The following is the relevant contents of ``BuildConfig.smali``

```smali
# static fields

.field public static final APPLICATION_ID:Ljava/lang/String; = "com.example.timer"
.field public static final BUILD_TYPE:Ljava/lang/String; = "debug"
.field public static final DEBUG:Z
.field public static final VERSION_CODE:I = 0x1
.field public static final VERSION_NAME:Ljava/lang/String; = "picoCTF{t1m3r_r3v3rs3d_succ355fully_17496}"
```

The flag is clearly located in the ``VERSION_NAME`` Java string. 

## References

1. https://ibotpeaches.github.io/Apktool/documentation/
