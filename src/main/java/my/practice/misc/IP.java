package my.practice.misc;

/**
 * Created by kmishra on 8/24/2016.
 */
public class IP {

    public static int ipAsInt(String ip) {
        String[] ipStr = ip.split("\\.");
        int[] octets = new int[4];
        int i = 0;
        for (String s : ipStr) {
            octets[i++] = Integer.parseInt(s);
        }
        int ipNum = 0;
        for (i = 0; i < 4; i++) {
            ipNum |= octets[i] << (24 - (8 * i));
        }
        return ipNum;
    }

    public static void main(String[] args) {
        int ip1 = ipAsInt("192.168.0.0");
        int ip2 = ipAsInt("192.168.0.12");
        int cidr = 8;
        int mask = ~((1 << (32 - cidr)) - 1);
        System.err.println(mask);
        System.err.println((ip1 & mask) == (ip2 & mask));
        System.err.println(1 & 3);
    }
}
