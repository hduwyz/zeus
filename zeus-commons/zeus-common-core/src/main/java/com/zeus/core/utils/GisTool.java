package com.zeus.core.utils;

/**
 * 简单空间计算，仅在距离较短的时候可用
 *
 * <p>2020/4/16</p>
 * @author lige
 */
public class GisTool {

    /**
     * 地球半径，数值从原来项目中继承，为了保持计算结果一致
     */
    public static final double EARTH_RADIUS = 6369426.75;

    /**
     * 计算两点距离
     * @return 单位米
     */
    public static double distance(double longitude0, double latitude0, double longitude1, double latitude1)
    {
        double long1D = longitude0 * Math.PI / 180;
        double long2D = longitude1 * Math.PI / 180;
        double lat1D = (90 - latitude0) * Math.PI / 180;
        double lat2D = (90 - latitude1) * Math.PI / 180;
        double temp1 = Math.sin(lat1D) * Math.sin(lat2D) * Math.cos(long1D - long2D) +
                Math.cos(lat1D) * Math.cos(lat2D);
        if (temp1 > 1) {temp1 = 1;}
        if (temp1 < -1) {temp1 = -1;}

        return EARTH_RADIUS * Math.acos(temp1);
    }

    /**
     * 计算两点方向角
     * @return 返回结果单位为角度，0~2Pi度
     */
    public static double direction(double longitude0, double latitude0, double longitude1, double latitude1) {
        if (longitude0 == longitude1) {
            if(latitude1 < latitude0){return -Math.PI/2;}
            if(latitude1 > latitude0){return Math.PI/2;}
        }
        double dir = Math.atan((longitude1 - longitude0) * Math.cos(latitude0 * Math.PI / 180.0) / (latitude1 - latitude0));
        if (latitude1 < latitude0) {
            if(longitude1 < longitude0){dir -= Math.PI;}
            if(longitude1 > longitude0){dir += Math.PI;}
        }

        if(dir<0) {dir += 2 * Math.PI;}
        return dir;
    }

    /**
     * 计算两点方向角
     * @return 返回结果单位为角度，0~360度
     */
    public static double direction360(double longitude0, double latitude0, double longitude1, double latitude1) {
        return direction(longitude0, latitude0, longitude1, latitude1) * 180.0 / Math.PI;
    }

    /**
     * 计算夹角
     * @return 返回[-Pi~Pi)
     */
    public static double angle(double angleDir0, double angleDir1)
    {
        double angle = angleDir1 - angleDir0;
        if (angle >= Math.PI)
        {
            angle = angle - 2*Math.PI;
        }

        if (angle < -Math.PI)
        {
            angle = angle + 2*Math.PI;
        }

        return angle;
    }

    /**
     * 计算夹角
     * @return 返回[-180~180)度
     */
    public static double angle360(double angleDir0, double angleDir1)
    {
        double angle = angleDir1 - angleDir0;
        if (angle >= 180)
        {
            angle = angle - 360;
        }

        if (angle < -180)
        {
            angle = angle + 360;
        }

        return angle;
    }

    /**
     * 自由空间衰减, 公式是在气温25度，1个大气压的理想情况的计算公式
     * @param distance 距离(m)
     * @param frequency 频率(Hz)
     * @return 衰减(dB)
     */
    public static double spaceLoss(double frequency, double distance) {
        return 32.5 + 20 * Math.log10(frequency) + 20 * Math.log10(distance);
    }
}
