package cn.hanamizu.campushelpba.util.checkInfo;

public class UserInfoCheck {
    public boolean isValidRegistration(String userName, Integer studentId, String phone, String password, Integer schoolId) {
        // 检查用户名是否为空
        if (userName == null || userName.trim().isEmpty()) {
            return false;
        }

        // 检查学号是否合法
        if (studentId == null || studentId < 0) {
            return false;
        }

        // 检查手机号是否合法
        if (phone == null || !isValidPhoneNumber(phone)) {
            return false;
        }

        // 检查密码是否符合要求
        if (password == null || !isValidPassword(password)) {
            return false;
        }

        // 检查学校ID是否合法
        return schoolId != null && schoolId >= 0;
        // 如果所有验证条件通过，返回 true 表示信息合法
    }

    private boolean isValidPassword(String password) {
        String regex = "^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]+$";
        return password.length() >= 6 && password.length() <= 20 && password.matches(regex);
    }

    private boolean isValidPhoneNumber(String phone) {
        String regex = "^1[3456789]\\d{9}$";
        return phone.matches(regex);
    }
}
