package Strings.EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    
    public static void main(String[] args) {
        String string = stringEncoder(List.of("lint","code","love","you"));
        System.out.println(string);
        System.out.println(stringDecoder(string));
    }

    public static String stringEncoder(List<String> stringList){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <stringList.size()-1; i++) {
            result.append(stringList.get(i));
            result.append(":;");
        }
        result.append(stringList.get(stringList.size()-1));

        return result.toString();
    }


    public static List<String> stringDecoder(String string){
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <string.length(); i++) {

            if(string.charAt(i) == ':' && string.charAt(i+1) ==';' ){
                result.add(string.substring(start, i));
                start = i+2;
            }
        }
        result.add(string.substring(start, string.length()));

        return result;
    }
} 

// output:-

// lint:;code:;love:;you
// [lint, code, love, you]