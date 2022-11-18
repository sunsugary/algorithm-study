package basic.Class13;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @ClassName: Code05_LowestLexicography
 * @Author: 5753
 * @Date: 2022/10/11 11:30
 * @Description: 给定一个字符串数组，将数组进行重新排列，求最小字典序的组合字符串
 */
public class Code05_LowestLexicography {

    public static String lowestString1(String[] arr){

        return "";


    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "https://staging-business-api.quncrm.com/v1/member/douyin/bind/?app_key=9217985576068897761&param_json={\"open_id\":\"1@#C+wOZzWkfHM74Vz2tN3B2e2vVFGfYYyxYd91VWRv6Mhp/Ja3R48SHWRVh0tldGxGaQ==\",\"mobile\":\"18121040540\",\"shop_id\":296648}&sign=7b75cb418ed3242e9c090cb01331c241&sign_method=md5&sign_v2=7b75cb418ed3242e9c090cb01331c241&timestamp=2022-05-17 13:40:27";

        System.out.println(URLEncoder.encode(s, "utf-8"));
        String encode = URLEncoder.encode(s);
        System.out.println(encode);
    }
}
