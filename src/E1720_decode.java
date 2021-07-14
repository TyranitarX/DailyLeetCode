import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/5/6 8:47
 **/
public class E1720_decode {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int decoded[] = new int[n + 1];
        decoded[0] = first;
        for (int i = 0; i < n; i++) {
            decoded[i + 1] = decoded[i] ^ encoded[i];
        }
        return decoded;
    }
}
