-verbose

-dontobfuscate
-optimizations !code/allocation/variable
-optimizationpasses 3
-libraryjars <java.home>/lib/rt.jar
-libraryjars <java.home>/lib/jce.jar

<<<<<<< HEAD
-injars build/libs/lokalizegs-desktop-1.0.jar
-outjars out/jar/lokalizegs-desktop-1.0.jar
=======
-injars build/libs/lokalizegs-desktop.jar
-outjars out/jar/lokalizegs-desktop.jar
>>>>>>> master

-keep class lokalize.MainKt {
    public static void main(java.lang.String[]);
}

-keep class com.google.api.client.json.JsonGenerator { *; }
-keep class com.google.api.client.util.GenericData$Flags { *; }
-keep class com.google.api.client.auth.oauth2.StoredCredential { *; }
-keep class com.google.api.client.googleapis.auth.oauth2.** { *; }

-keep interface com.google.errorprone.annotations.** { *; }
-keep class org.slf4j.** { *; }
-keep class javax.crypto.Cipher { *; }

-dontwarn com.google.errorprone.annotations.**
-dontwarn org.apache.**
-dontwarn org.codehaus.**