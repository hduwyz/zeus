package com.zeus.core.utils;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.*;
import java.util.List;

/** 
* @ClassName: CSVUtils 
* @Description: csv操作工具类
*
*/
public class CSVUtils {
	/**
     * 设置私有
     */
    private CSVUtils() {
    }

    /**
     * csv文件导入
     * CsvBindByName
     * @param inputStream
     * @param type        指定转化的实体类
     * @return java.util.List<org.apache.poi.ss.formula.functions.T> 返回实体类的集合
     * @throws Exception
     * @Title: importCsvWithoutHeader
     * @Description:
     * @date 2018/9/30
     */
    public static <T> List<T> importCsvByName(InputStream inputStream, Class<? extends T> type) throws Exception {
        return new CsvToBeanBuilder(new InputStreamReader(inputStream, "GBK")).withType(type).build().parse();
    }

    /**
     * csv文件导入
     * CsvBindByPosition
     * @param inputStream
     * @param type        指定转化的实体类
     * @return java.util.List<org.apache.poi.ss.formula.functions.T> 返回实体类的集合
     * @throws Exception
     * @Title: importCsvWithoutHeader
     * @date 2018/9/30
     */
    public static <T> List<T> importCsvByPosition(InputStream inputStream, Class<? extends T> type) throws Exception {
        return new CsvToBeanBuilder(new InputStreamReader(inputStream, "GBK")).withSkipLines(1)
                .withType(type).build().parse();
    }

    /**
     * 根据bean实体配置设置表头（顺序不固定）
     *
     * @param filePath
     * @param dataList
     * @return void
     * @throws Exception
     * @Title: createCsvfile
     * @date 2018/10/16
     */
    public static <T> void createCsvfile(String filePath, List<T> dataList) throws Exception {
        Writer writer = new OutputStreamWriter(new FileOutputStream(filePath), "GBK");
        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
        beanToCsv.write(dataList);
        writer.close();
    }

    /**
     * 固定顺序，带表头
     *
     * @param filePath
     * @param dataList
     * @param header
     * @return void
     * @throws Exception
     * @Title: createCsvfile
     * @date 2018/10/16
     */
    public static <T> void createCsvfile(String filePath, List<T> dataList, String[] header) throws Exception {
        Writer writer = new OutputStreamWriter(new FileOutputStream(filePath), "GBK");
        // 写表头
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(header);

        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
        beanToCsv.write(dataList);
        csvWriter.close();
        writer.close();

    }
}
