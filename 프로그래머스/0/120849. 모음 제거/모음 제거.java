class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String str1 = my_string.replace("a", "");
        String str2 = str1.replace("e", "");
        String str3 = str2.replace("i", "");
        String str4 = str3.replace("o", "");
        String str5= str4.replace("u", "");
        
        return str5;
    }
}