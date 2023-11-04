package cn.hanamizu.campushelpba.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Hash {
    public String hash(String password){
        Md5Hash md5Hash = new Md5Hash(password, "campus_help", 2);
        return md5Hash.toString();
    }

}