package tn.gov.douane.formations.api.function;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AdressIP {

    public static String IP;

    static {
        try {
            IP = IpAdress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static String IpAdress() throws UnknownHostException {

        InetAddress myIP = InetAddress.getLocalHost();

        String Ip = myIP.getHostAddress();

        Ip = myIP.getHostAddress();

        return Ip;
    }
}
