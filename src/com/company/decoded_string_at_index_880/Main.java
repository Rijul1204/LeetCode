package com.company.decoded_string_at_index_880;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Character.isDigit;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.decodeAtIndex("vk6u5xhq9v", 554));
    }

    /**
     * return -1 if not found
     * @param s
     * @param lengthOfStr
     * @param searchIndex
     * @return
     */
    private int findInd(String s, List<Long> lengthOfStr, long end, long searchIndex) {

        if (end < 0) {
            return -1;
        }
        if (searchIndex == 0) {
            if(!isDigit(s.charAt((int) end))){
                return (int) end;
            }
            return findInd(s, lengthOfStr, end-1, searchIndex);
        }
        int ind = Collections.binarySearch(lengthOfStr, searchIndex);

        if (ind >=0 && !isDigit(s.charAt(ind))){
            return ind;
        }

        if (ind == -1) {
            return -1;
        }

        // If not found adjust to lower bound
        if (ind < 0) {
            ind = -ind;
            ind -= 2;
        }
        return  -1;
    }

    public String decodeAtIndex(String S, int K) {

        long req = K;
        List<Long> lengthAtInd = getLengthAtInd(S);
        StringBuilder ret = new StringBuilder();

        while (req > 0) {

            int ind = Collections.binarySearch(lengthAtInd, req);
            if (ind == -1) {
                return "";
            }

            if (ind < 0) {
                ind = -ind;
                ind -= 2;
            }

            if (req % lengthAtInd.get(ind) == 0) {
                while (ind >= 0 && isDigit(S.charAt(ind))) {
                    ind--;
                }
                if (ind < 0) {
                    return "";
                } else {
                    ret.append(S.charAt(ind));
                    break;
                }
            } else {
                req %= (lengthAtInd.get(ind));
            }
        }

        return ret.toString();
    }

    private List<Long> getLengthAtInd(String S) {
        List<Long> lengthAtInd = new ArrayList<>();
        long last = 0;
        for (char ch : S.toCharArray()) {
            if (isDigit(ch)) {
                last *= (ch - '0');
            } else {
                last++;
            }
            lengthAtInd.add(last);
        }
        return lengthAtInd;
    }
}
