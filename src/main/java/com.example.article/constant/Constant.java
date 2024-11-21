package com.example.article.constant;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Late-en
 */
public class Constant {
    //维修，安装，保养清洗
    public static ArrayList<Double> serviceQuote = (ArrayList<Double>) Arrays.asList(2D, 0.5D, 0.3D);
    //大中小家电
    public static ArrayList<Double> applianceQuote = (ArrayList<Double>) Arrays.asList(300D, 200D, 100D);

    public static Double getPress(Integer serviceType,Integer applianceType){
        return serviceQuote.get(serviceType) * applianceQuote.get(applianceType);
    }
}
