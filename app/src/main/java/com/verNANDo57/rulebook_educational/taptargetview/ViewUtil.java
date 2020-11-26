package com.verNANDo57.rulebook_educational.taptargetview;

import android.os.Build;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewTreeObserver;

import androidx.core.view.ViewCompat;

class ViewUtil {
  ViewUtil() {
    //required empty constructor
  }

  /** Returns whether or not the view has been laid out **/
  private static boolean isLaidOut(View view) {
    return ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0;
  }

  /** Executes the given {@link java.lang.Runnable} when the view is laid out **/
  static void onLaidOut(final View view, final Runnable runnable) {
    if (isLaidOut(view)) {
      runnable.run();
      return;
    }

    final ViewTreeObserver observer = view.getViewTreeObserver();
    observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        final ViewTreeObserver trueObserver;

        if (observer.isAlive()) {
          trueObserver = observer;
        } else {
          trueObserver = view.getViewTreeObserver();
        }

        removeOnGlobalLayoutListener(trueObserver, this);

        runnable.run();
      }
    });
  }

  @SuppressWarnings("deprecation")
  static void removeOnGlobalLayoutListener(ViewTreeObserver observer,
                                           ViewTreeObserver.OnGlobalLayoutListener listener) {
    if (Build.VERSION.SDK_INT >= 16) {
      observer.removeOnGlobalLayoutListener(listener);
    } else {
      observer.removeGlobalOnLayoutListener(listener);
    }
  }

  static void removeView(ViewManager parent, View child) {
    if (parent == null || child == null) {
      return;
    }

    try {
      parent.removeView(child);
    } catch (Exception ignored) {
      // This catch exists for modified versions of Android that have a buggy ViewGroup
      // implementation. See b.android.com/77639, #121 and #49
    }
  }
}
