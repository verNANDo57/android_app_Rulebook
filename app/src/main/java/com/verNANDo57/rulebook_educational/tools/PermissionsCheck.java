/*
  This app uses these permissions to save user needed rules as txt files:
        android.permission.WRITE_EXTERNAL_STORAGE,
        android.permission.READ_EXTERNAL_STORAGE,
        android.permission.MANAGE_EXTERNAL_STORAGE
 */

package com.verNANDo57.rulebook_educational.tools;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

import java.util.Arrays;

@RequiresApi(api = Build.VERSION_CODES.M)
public class PermissionsCheck extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;

    private static PermissionCompatDelegate sDelegate;

    //public boolean request_completed = false;
    public static final int THREAD_SLEEP_TIME_MILLISECONDS = 1000;

    public static final int STORAGE_PERMISSION_CODE = 1;

    public static final int PERMISSION_GRANTED = 0;
    public static final int PERMISSION_DENIED = -1;

    public static final String WRITE_EXTERNAL_STORAGE_REFERENCE = Manifest.permission.WRITE_EXTERNAL_STORAGE.toString();
    public static final String READ_EXTERNAL_STORAGE_REFERENCE = Manifest.permission.READ_EXTERNAL_STORAGE.toString();
    @RequiresApi(api = Build.VERSION_CODES.R) public static final String MANAGE_EXTERNAL_STORAGE_REFERENCE = Manifest.permission.MANAGE_EXTERNAL_STORAGE.toString();

    private void stopPermissionsCheck(){
        this.finish();
    }

    public interface PermissionCompatDelegate {
        /**
         * Determines whether the delegate should handle
         * {@link #requestPermissions(CustomThemeEngineAppCompatActivity, String[], int)}, and request
         * permissions if applicable. If this method returns true, it means that permission
         * request is successfully handled by the delegate, and platform should not perform any
         * further requests for permission.
         *
         * @param activity The target activity.
         * @param permissions The requested permissions. Must me non-null and not empty.
         * @param requestCode Application specific request code to match with a result reported to
         *    {@link
         *    ActivityCompat.OnRequestPermissionsResultCallback#onRequestPermissionsResult(int, String[], int[])}.
         *    Should be >= 0.
         *
         * @return Whether the delegate has handled the permission request.
         * @see #requestPermissions(CustomThemeEngineAppCompatActivity, String[], int)
         */
        boolean requestPermissions(@NonNull CustomThemeEngineAppCompatActivity activity,
                                   @NonNull String[] permissions, @IntRange(from = 0) int requestCode);

        /**
         * Determines whether the delegate should handle the permission request as part of
         * {@code FragmentActivity#onActivityResult(int, int, Intent)}. If this method returns true,
         * it means that activity result is successfully handled by the delegate, and no further
         * action is needed on this activity result.
         *
         * @param activity    The target Activity.
         * @param requestCode The integer request code originally supplied to
         *                    {@code startActivityForResult()}, allowing you to identify who this
         *                    result came from.
         * @param resultCode  The integer result code returned by the child activity
         *                    through its {@code }setResult()}.
         * @param data        An Intent, which can return result data to the caller
         *                    (various data can be attached to Intent "extras").
         *
         * @return Whether the delegate has handled the activity result.
         * @see #requestPermissions(CustomThemeEngineAppCompatActivity, String[], int)
         */
        boolean onActivityResult(@NonNull CustomThemeEngineAppCompatActivity activity,
                                 @IntRange(from = 0) int requestCode, int resultCode, @Nullable Intent data);
    }
    /**
     * Gets whether you should show UI with rationale for requesting a permission.
     * You should do this only if you do not have the permission and the context in
     * which the permission is requested does not clearly communicate to the user
     * what would be the benefit from granting this permission.
     * <p>
     * For example, if you write a camera app, requesting the camera permission
     * would be expected by the user and no rationale for why it is requested is
     * needed. If however, the app needs location for tagging photos then a non-tech
     * savvy user may wonder how location is related to taking photos. In this case
     * you may choose to show UI with rationale of requesting this permission.
     * </p>
     *
     * @param activity The target activity.
     * @param permission A permission your app wants to request.
     * @return Whether you can show permission rationale UI.
     *
     */
    public static boolean shouldShowRequestPermissionRationale(@NonNull CustomThemeEngineAppCompatActivity activity,
                                                               @NonNull String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(permission);
        }
        return false;
    }

    /**
     * Sets the permission delegate for {@code ActivityCompat}. Replaces the previously set
     * delegate.
     *
     * @param delegate The delegate to be set. {@code null} to clear the set delegate.
     */
    public static void setPermissionCompatDelegate(
            @Nullable PermissionCompatDelegate delegate) {
        sDelegate = delegate;
    }

    
    @SuppressLint("RestrictedApi")
    public static void requestPermissions(final @NonNull CustomThemeEngineAppCompatActivity activity,
                                          final @NonNull String[] permissions, final @IntRange(from = 0) int requestCode) {
        if (sDelegate != null
                && sDelegate.requestPermissions(activity, permissions, requestCode)) {
            // Delegate has handled the permission request.
            return;
        }

        if (Build.VERSION.SDK_INT >= 23) {
            ((ActivityCompat.RequestPermissionsRequestCodeValidator) activity)
                    .validateRequestPermissionsRequestCode(requestCode);
            activity.requestPermissions(permissions, requestCode);
        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    final int[] grantResults = new int[permissions.length];

                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();

                    final int permissionCount = permissions.length;
                    for (int i = 0; i < permissionCount; i++) {
                        grantResults[i] = packageManager.checkPermission(
                                permissions[i], packageName);
                    }

                    ((ActivityCompat.OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(
                            requestCode, permissions, grantResults);
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        preferences = new RulebookApplicationSharedPreferences(this);

        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {
                preferences.setAppPermissionsAreGrantedBooleanState(true);
                Log.w("rulebook_tag", Arrays.toString(permissions) + " - " + getString(R.string.app_granted));
            } else {
                preferences.setAppPermissionsAreGrantedBooleanState(false);
                Log.w("rulebook_tag", Arrays.toString(permissions) + " - " + getString(R.string.app_denied));
            }
        }
        try {
            Thread.sleep(THREAD_SLEEP_TIME_MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stopPermissionsCheck();
        }
    }

    public void createShouldShowRequestPermissionRationaleAlertDialogCompat(Context context, CustomThemeEngineAppCompatActivity activity, String permission){
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.app_warning));
        builder.setIcon(ContextCompat.getDrawable(context, R.drawable.ic_warning_outline));
        builder.setMessage(context.getString(R.string.app_reason_why_these_permissions_are_needed));
        //builder.setCancelable(false);
        builder.setPositiveButton(context.getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO: re-request needed permissions
                requestPermissions(activity, new String[] {permission} , STORAGE_PERMISSION_CODE);
            }
        });
        builder.setNegativeButton(context.getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                stopPermissionsCheck();
            }
        });
        androidx.appcompat.app.AlertDialog alert = builder.create();
        alert.setCancelable(false);
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences =  new RulebookApplicationSharedPreferences(this);


        if(Build.VERSION.SDK_INT >= 30) {
            if (ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE_REFERENCE) == PERMISSION_DENIED ) {
                preferences.setAppPermissionsAreGrantedBooleanState(false);

                if (shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE_REFERENCE)) {
                    createShouldShowRequestPermissionRationaleAlertDialogCompat(this, PermissionsCheck.this, READ_EXTERNAL_STORAGE_REFERENCE);
                } else {
                    requestPermissions(this, new String[] {READ_EXTERNAL_STORAGE_REFERENCE} , STORAGE_PERMISSION_CODE);
                }
            } else if (ActivityCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE_REFERENCE) == PERMISSION_DENIED) {
                preferences.setAppPermissionsAreGrantedBooleanState(false);

                if (shouldShowRequestPermissionRationale(this, WRITE_EXTERNAL_STORAGE_REFERENCE)) {
                        createShouldShowRequestPermissionRationaleAlertDialogCompat(this, PermissionsCheck.this, WRITE_EXTERNAL_STORAGE_REFERENCE);
                } else {
                    requestPermissions(this, new String[] {WRITE_EXTERNAL_STORAGE_REFERENCE} , STORAGE_PERMISSION_CODE);
                }
            } else if (ActivityCompat.checkSelfPermission(this, MANAGE_EXTERNAL_STORAGE_REFERENCE) == PERMISSION_DENIED) {
                preferences.setAppPermissionsAreGrantedBooleanState(false);

                if (shouldShowRequestPermissionRationale(this, MANAGE_EXTERNAL_STORAGE_REFERENCE)) {
                    createShouldShowRequestPermissionRationaleAlertDialogCompat(this, PermissionsCheck.this, MANAGE_EXTERNAL_STORAGE_REFERENCE);
                } else {
                    requestPermissions(this, new String[] {MANAGE_EXTERNAL_STORAGE_REFERENCE} , STORAGE_PERMISSION_CODE);
                }
            } else {
                preferences.setAppPermissionsAreGrantedBooleanState(true);
                stopPermissionsCheck();
            }
        } else {
            if (ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE_REFERENCE) == PERMISSION_DENIED ) {
                preferences.setAppPermissionsAreGrantedBooleanState(false);

                if (shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE_REFERENCE)) {
                    createShouldShowRequestPermissionRationaleAlertDialogCompat(this, PermissionsCheck.this, READ_EXTERNAL_STORAGE_REFERENCE);
                } else {
                    requestPermissions(this, new String[] {READ_EXTERNAL_STORAGE_REFERENCE} , STORAGE_PERMISSION_CODE);
                }
            } else if (ActivityCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE_REFERENCE) == PERMISSION_DENIED) {
                preferences.setAppPermissionsAreGrantedBooleanState(false);

                if (shouldShowRequestPermissionRationale(this, WRITE_EXTERNAL_STORAGE_REFERENCE)) {
                    createShouldShowRequestPermissionRationaleAlertDialogCompat(this, PermissionsCheck.this, WRITE_EXTERNAL_STORAGE_REFERENCE);
                } else {
                    requestPermissions(this, new String[] {WRITE_EXTERNAL_STORAGE_REFERENCE} , STORAGE_PERMISSION_CODE);
                }
            } else {
                preferences.setAppPermissionsAreGrantedBooleanState(true);
                stopPermissionsCheck();
            }
        }
        //request_completed = true;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setVisible(true);
    }
}
