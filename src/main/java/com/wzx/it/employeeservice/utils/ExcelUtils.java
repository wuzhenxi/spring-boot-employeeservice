package com.wzx.it.employeeservice.utils;

import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuzhenxi
 * @date
 */
public class ExcelUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 向sheet填充数据
     *
     * @param sheet    sheet
     * @param list     数据
     * @param fieldMap 列头、字段匹配Map
     * @param <T>
     * @throws Exception
     */
    private static <T> void fillSheet(Sheet sheet, List<T> list, LinkedHashMap<String, String> fieldMap) throws Exception {
        Row row = sheet.getRow(0);
        // 定义存放英文字段名和中文字段名的数组
        String[] enFields = new String[row.getLastCellNum()];
        String[] cnFields = new String[row.getLastCellNum()];
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            cnFields[i] = row.getCell(i).getStringCellValue();
            for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                if (cnFields[i].equals(entry.getValue())) {
                    enFields[i] = entry.getKey();
                }
            }
        }
        if (list.size() > 0) {
            for (int rowNo = 1; rowNo <= list.size(); rowNo++) {
                Row contentRow = sheet.createRow(rowNo);
                T item = list.get(rowNo - 1);
                for (int i = 0; i < enFields.length; i++) {
                    Object objValue = getFieldValueByName(enFields[i], item);
                    if (objValue == null) {
                        continue;
                    }
                    String fieldValue = objValue.toString();
                    Cell contentRowCell = contentRow.createCell(i);
                    contentRowCell.setCellValue(fieldValue);
                }
            }
        }
    }

    private static Object getFieldValueByName(String fieldName, Object o) throws Exception {
        Object value = null;
        if (Strings.isEmpty(fieldName)) {
            return value;
        }
        String[] attributes = fieldName.split("\\.");
        if (attributes.length == 1) {
            value = getFieldValueForName(fieldName, o);
        } else {
            // 根据属性名获取属性对象
            Object fieldObj = getFieldValueByName(attributes[0], o);
            String subFieldNameSequence = fieldName.substring(fieldName.indexOf(".") + 1);
            value = getFieldValueByName(subFieldNameSequence, fieldObj);
        }
        return value;
    }

    private static Object getFieldValueForName(String fieldName, Object o) throws Exception {
        Object value = null;
        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            value = field.get(o);
        }
        return value;
    }

    private static Field getFieldByName(String fieldName, Class<?> clazz) {
        Field[] selfFields = clazz.getDeclaredFields();
        // 如果本类中存在该字段，则返回
        for (Field field : selfFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        // 查看父类中是否存在此字段，如果有则返回
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            return getFieldByName(fieldName, superclass);
        }
        return null;
    }
}
