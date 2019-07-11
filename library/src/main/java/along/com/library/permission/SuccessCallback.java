package along.com.library.permission;

/**
 * 类说明：申请权限成功的回调
 */
public abstract class SuccessCallback implements PermissionCallback{

    @Override
    public void shouldShowRational(String[] rationalPermissons, boolean before) {

    }

    @Override
    public void onPermissonReject(String[] rejectPermissons) {

    }
}
