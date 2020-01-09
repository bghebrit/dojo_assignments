public class StringManipulator{
    public String trimAndconcat(String s1, String s2){
        String result = s1.trim() + s2.trim();
        return result;

    }
    public Integer getIndexOrNull(String s2 , char c1){
        int i = s2.indexOf(c1);
            if (i == -1){
                return null;
        }
        else{
            return i;
        }
    }
    public Integer getIndexOrNull(String str1 , String str2){
        int j = str1.indexOf(str2);
        if (j == -1){
            return null;
        }
        else{
            return j;
        }
    }


}


