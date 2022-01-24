LOCAL_PATH := $(call my-dir)

APP_STL := c++_shared
APP_CPPFLAGS += -fexceptions

# For ANativeWindow support
APP_PLATFORM = android-16

# Mips architecture isn't supported.
APP_ABI :=  armeabi-v7a \
            arm64-v8a \
            x86 \
            x86_64

# Define output folder
NDK_LIBS_OUT := $(LOCAL_PATH)/out/libs
NDK_OUT := $(LOCAL_PATH)/out/obj
