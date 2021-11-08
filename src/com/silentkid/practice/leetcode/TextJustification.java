package com.silentkid.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    private static String SPACE = " ";

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int currentLen = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLen = word.length();

            if (currentLen + wordLen + 1 <= maxWidth) {

                if (tmp.size() == 0) {
                    currentLen += wordLen;
                } else {
                    currentLen += wordLen + 1;
                }
                tmp.add(word);
            }
            else{

                StringBuilder sb = new StringBuilder();
                //Justify those in TMP and start a new one
                if (tmp.size() == 1) {

                    sb = justifyLeft(maxWidth,tmp);

                } else {
                    int extraSpaces = maxWidth - currentLen;
                    int listSize = tmp.size();

                    int allocation = extraSpaces / (listSize - 1);
                    int k = extraSpaces % (listSize - 1);

                    for (int h = 0 ; h < tmp.size(); h++) {
                        String l = tmp.get(h);
                        if (sb.length() > 0) {
                            //get Space
                            sb.append(SPACE);

                            for (int t = 0; t < allocation; t++) {
                                sb.append(SPACE);
                            }
                            if(h <= k){
                                sb.append(SPACE);
                            }
                        }
                        sb.append(l);
                    }
                }
                tmp = new ArrayList<>();
                tmp.add(word);
                currentLen = wordLen;
                if(sb.length()>0)
                    res.add(sb.toString());

            }
        }

        //justfiy last
        StringBuilder sb = justifyLeft(maxWidth, tmp);
        res.add(sb.toString());

        return res;
    }

    private StringBuilder justifyLeft(int maxWidth, List<String> tmp) {
        StringBuilder sb = new StringBuilder();
        for(String s : tmp){
            if(sb.length() != 0){
                sb.append(SPACE);
            }
            sb.append(s);
        }
        while(sb.length() < maxWidth){
            sb.append(SPACE);
        }
        return sb;
    }
    //so   fine  That  all  the
    //so   fine   That  all the


    public static void main(String[] args) {
        String[] words = {"so","fine","That","all","the","world","will","be","in","love","with","night","And","pay","no","worship","to","the","garish","sun."};

        TextJustification tf = new TextJustification();
        List<String> res = tf.fullJustify(words,25);
        for(String s : res){
            System.out.println(s);
        }
    }

}
