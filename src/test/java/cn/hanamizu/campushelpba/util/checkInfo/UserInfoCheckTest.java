package cn.hanamizu.campushelpba.util.checkInfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoCheckTest {
    @Test
    void userInfoCheck() {
        UserInfoCheck userInfoCheck = new UserInfoCheck();
        System.out.println(userInfoCheck.isValidRegistration("ma",1,"15603443334","123456",1));
    }
}