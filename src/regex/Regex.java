package regex;

import io.Path;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private Pattern pattern;
    private Matcher matcher;
    public static final String ACCOUNT = "^[_a-z0-9]{6,}$";
    public static final String PASS = "^[_a-z0-9A-z]{6,}$";
    public static final String NUMBER = "^\\d+$";
    public static final String PHONE = "^(84|0[3|5|7|8|9])+([0-9]{8})\\b$";
    public static final String DOUBLE = "^(\\d+\\.\\d+)|\\d+";
    public static final String NAME ="^\\pL+[\\pL\\pZ\\pP]{0,}$";
    public static final String BOOLEAN="true|false$";
    public static final String DATE="^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
    public static final String EMAIL="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String STATUS="^DONE|PROCESSING$";
//    Scanner sc = new Scanner(System.in);

    public boolean validateAll(String value,String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }
    public String validate(String guide,String guideError,String regex) {
        while (true){
            System.out.println(guide);;
            String value = Path.sc().nextLine();
            if(validateAll(value,regex)){
                return value;
            }else{
                System.err.println(guideError);
            }
        }
    }
    public String validateNotNull(String guide,String guideError) {
        while (true){
            System.out.println(guide);;
            String value = Path.sc().nextLine();
            if(!value.trim().equals("")){
                return value;
            }else{
                System.err.println(guideError);
            }
        }
    }
    public String validateNotNull(String guideError) {
        while (true){
            String value = Path.sc().nextLine();
            if(!value.trim().equals("")){
                return value;
            }else{
                System.err.println(guideError);
            }
        }
    }
}
