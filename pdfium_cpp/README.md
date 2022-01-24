# Build native part
Install android-ndk first.
Go to `jni`, open terminal and run commands:
>
> `$ chmod a+x build.sh`
> `$ ./build.sh`
>
This step may be executed only once, every future `.aar` build will use generated libs.

Go to `out/libs` and select either all libraries, or libraries for only a particular architecture, then move them to `PROJECT_PATH/app/src/main/jniLibs`.
Now you're ready to build the app.
