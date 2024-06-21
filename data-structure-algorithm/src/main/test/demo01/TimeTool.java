package demo01;

public class TimeTool {

    // 获取当前时间// 获取当前时间
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    // 计算时间差
    public static long getTimeDifference(long startTime, long endTime) {
        return endTime - startTime;
    }
}
