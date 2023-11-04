package cn.hanamizu.campushelpba.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MD5HashTest {
    @Test
    void md5Hash() {
        MD5Hash md5Hash = new MD5Hash();
        System.out.println(md5Hash.hash("123456"));
    }

}