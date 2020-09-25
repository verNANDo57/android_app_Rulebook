package com.verNANDo57.rulebook_educational.taptargetview;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;
import java.util.Stack;

class BottomAppBarTapTarget extends ViewTapTarget {
  BottomAppBarTapTarget(BottomAppBar bottomAppBar, @IdRes int menuItemId,
                        CharSequence title, @Nullable CharSequence description) {
    super(bottomAppBar.findViewById(menuItemId), title, description);
  }

  BottomAppBarTapTarget(BottomAppBar bottomAppBar, boolean findNavView,
                        CharSequence title, @Nullable CharSequence description) {
    super(findNavView ? findNavView(bottomAppBar) : findOverflowView(bottomAppBar), title, description);
  }

  private static ToolbarProxy proxyOf(Object instance) {
    if (instance == null) {
      throw new IllegalArgumentException("Given null instance");
    }

    if (instance instanceof BottomAppBar) {
      return new SupportToolbarProxy((BottomAppBar) instance);
    } else if (instance instanceof BottomAppBar) {
      return new StandardToolbarProxy((BottomAppBar) instance);
    }

    throw new IllegalStateException("Couldn't provide proper toolbar proxy instance");
  }

  private static View findNavView(Object instance) {
    final ToolbarProxy toolbar = proxyOf(instance);

    // First we try to find the view via its content description
    final CharSequence currentDescription = toolbar.getNavigationContentDescription();
    final boolean hadContentDescription = !TextUtils.isEmpty(currentDescription);
    final CharSequence sentinel = hadContentDescription ? currentDescription : "taptarget-findme";
    toolbar.setNavigationContentDescription(sentinel);

    final ArrayList<View> possibleViews = new ArrayList<>(1);
    toolbar.findViewsWithText(possibleViews, sentinel, View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);

    if (!hadContentDescription) {
      toolbar.setNavigationContentDescription(null);
    }

    if (possibleViews.size() > 0) {
      return possibleViews.get(0);
    }

    // If that doesn't work, we try to grab it via matching its drawable
    final Drawable navigationIcon = toolbar.getNavigationIcon();
    if (navigationIcon == null) {
      throw new IllegalStateException("Toolbar does not have a navigation view set!");
    }

    final int size = toolbar.getChildCount();
    for (int i = 0; i < size; ++i) {
      final View child = toolbar.getChildAt(i);
      if (child instanceof ImageButton) {
        final Drawable childDrawable = ((ImageButton) child).getDrawable();
        if (childDrawable == navigationIcon) {
          return child;
        }
      }
    }

    throw new IllegalStateException("Could not find navigation view for Toolbar!");
  }

  private static View findOverflowView(Object instance) {
    final ToolbarProxy toolbar = proxyOf(instance);

    // First we try to find the overflow menu view via drawable matching
    final Drawable overflowDrawable = toolbar.getOverflowIcon();
    if (overflowDrawable != null) {
      final Stack<ViewGroup> parents = new Stack<>();
      parents.push((ViewGroup) toolbar.internalToolbar());
      while (!parents.empty()) {
        ViewGroup parent = parents.pop();
        final int size = parent.getChildCount();
        for (int i = 0; i < size; ++i) {
          final View child = parent.getChildAt(i);
          if (child instanceof ViewGroup) {
            parents.push((ViewGroup) child);
            continue;
          }
          if (child instanceof ImageView) {
            final Drawable childDrawable = ((ImageView) child).getDrawable();
            if (childDrawable == overflowDrawable) {
              return child;
            }
          }
        }
      }
    }

    // If that doesn't work, we fall-back to our last resort solution: Reflection
    // Toolbars contain an "ActionMenuView" which in turn contains an "ActionMenuPresenter".
    // The "ActionMenuPresenter" then holds a reference to an "OverflowMenuButton" which is the
    // desired target
    try {
      final Object actionMenuView = ReflectUtil.getPrivateField(toolbar.internalToolbar(), "mMenuView");
      final Object actionMenuPresenter = ReflectUtil.getPrivateField(actionMenuView, "mPresenter");
      return (View) ReflectUtil.getPrivateField(actionMenuPresenter, "mOverflowButton");
    } catch (NoSuchFieldException e) {
      throw new IllegalStateException("Could not find overflow view for Toolbar!", e);
    } catch (IllegalAccessException e) {
      throw new IllegalStateException("Unable to access overflow view for Toolbar!", e);
    }
  }

  private interface ToolbarProxy {
    CharSequence getNavigationContentDescription();

    void setNavigationContentDescription(CharSequence description);

    void findViewsWithText(ArrayList<View> out, CharSequence toFind, int flags);

    Drawable getNavigationIcon();

    @Nullable
    Drawable getOverflowIcon();

    int getChildCount();

    View getChildAt(int position);

    Object internalToolbar();
  }

  private static class SupportToolbarProxy implements ToolbarProxy {
    private final BottomAppBar bottomAppBar;

    SupportToolbarProxy(BottomAppBar bottomAppBar) {
      this.bottomAppBar = bottomAppBar;
    }

    @Override
    public CharSequence getNavigationContentDescription() {
      return bottomAppBar.getNavigationContentDescription();
    }

    @Override
    public void setNavigationContentDescription(CharSequence description) {
      bottomAppBar.setNavigationContentDescription(description);
    }

    @Override
    public void findViewsWithText(ArrayList<View> out, CharSequence toFind, int flags) {
      bottomAppBar.findViewsWithText(out, toFind, flags);
    }

    @Override
    public Drawable getNavigationIcon() {
      return bottomAppBar.getNavigationIcon();
    }

    @Override
    public Drawable getOverflowIcon() {
      return bottomAppBar.getOverflowIcon();
    }

    @Override
    public int getChildCount() {
      return bottomAppBar.getChildCount();
    }

    @Override
    public View getChildAt(int position) {
      return bottomAppBar.getChildAt(position);
    }

    @Override
    public Object internalToolbar() {
      return bottomAppBar;
    }
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private static class StandardToolbarProxy implements ToolbarProxy {
    private final BottomAppBar bottomAppBar;

    StandardToolbarProxy(BottomAppBar bottomAppBar) {
      this.bottomAppBar = bottomAppBar;
    }

    @Override
    public CharSequence getNavigationContentDescription() {
      return bottomAppBar.getNavigationContentDescription();
    }

    @Override
    public void setNavigationContentDescription(CharSequence description) {
      bottomAppBar.setNavigationContentDescription(description);
    }

    @Override
    public void findViewsWithText(ArrayList<View> out, CharSequence toFind, int flags) {
      bottomAppBar.findViewsWithText(out, toFind, flags);
    }

    @Override
    public Drawable getNavigationIcon() {
      return bottomAppBar.getNavigationIcon();
    }

    @Nullable
    @Override
    public Drawable getOverflowIcon() {
      if (Build.VERSION.SDK_INT >= 23) {
        return bottomAppBar.getOverflowIcon();
      }

      return null;
    }

    @Override
    public int getChildCount() {
      return bottomAppBar.getChildCount();
    }

    @Override
    public View getChildAt(int position) {
      return bottomAppBar.getChildAt(position);
    }

    @Override
    public Object internalToolbar() {
      return bottomAppBar;
    }
  }
}
