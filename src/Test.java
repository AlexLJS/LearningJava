import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        //System.out.println(sushu(100));
        HashMap<String,String> map = new HashMap<>();

        map.put("123","234");
        System.out.println(map.get(123));
    }
//    public static String sushu(int input){
//        ArrayList<Integer> resAry = new ArrayList<>();
//        int step = 10;
//
//        for (int index = 1; index < input - 1; index += step){
//            int i = 2;
//            for (; i < index - 1; i++){
//                if ( index%i == 0){
//                    break;
//                }
//            }
//            if (i == index - 1){
//                resAry.add(index);
//            }
//        }
//        if (resAry.size() == 0 )
//            return "-1";
//        String res = "";
//        for (int i = 0 ; i < resAry.size();i++){
//            if (i == resAry.size()-1){
//                res = res + resAry.get(i);
//            }else{
//                res = res + resAry.get(i) + " ";
//            }
//        }
//        return res;
//    }

}
