package com.business.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utils {

    public static String getIp() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

}