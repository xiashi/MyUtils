package along.com.library.permission;

/**
 * 类说明：权限申请失败回调
 */
public interface FailedCallBack {

    /**
     * 方法说明：申请权限失败并且用户没有勾选“禁止后不在询问”
     *
     * @param rationalPermissons 用户不同意的权限集合
     * @param before             true 权限申请前回调 false 权限申请后回调
     */
    void shouldShowRational(String[] rationalPermissons, boolean before);

    /**
     * 方法说明：权限已被禁止 或 申请权限失败并且用户勾选了“禁止后不在询问”
     *
     * @param rejectPermissons 被禁止的权限集合
     */
    void onPermissonReject(String[] rejectPermissons);
}
