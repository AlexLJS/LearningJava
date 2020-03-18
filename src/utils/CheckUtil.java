package Utils;

public interface CheckUtil {
    Object prepareData();

    boolean doCheck(Object data);//与绝对正确的算法进行比较
}
