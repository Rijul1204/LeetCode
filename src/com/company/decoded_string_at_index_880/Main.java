package com.company.decoded_string_at_index_880;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public String decodeAtIndex(String S, int K) {

        List<Long> val = new ArrayList<>();

        long last = 0;
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {
                int value = ch - '0';
                last *= value;
            } else {
                last++;
            }
            val.add(last);
        }

        StringBuilder ret = new StringBuilder();
        long req = K;
        while (req > 0) {

            int ind = Collections.binarySearch(val, req);
            if (ind == -1) {
                return "";
            }

            if (ind < 0) {
                ind = -ind;
                ind -= 2;
            }

            if (req % val.get(ind) == 0) {
                while (ind >= 0 && Character.isDigit(S.charAt(ind))) {
                    ind--;
                }
                if (ind < 0) {
                    return "";
                } else {
                    ret.append(S.charAt(ind));
                    break;
                }
            } else {
                req %= (val.get(ind));
            }
        }

        return ret.toString();
    }
}
