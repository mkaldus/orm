package pl.edu.agh.wp.orm.dto;

import pl.ed.agh.wp.orm.annotations.Type;
import pl.ed.agh.wp.orm.annotations.converter.types.TypeConverter;
import pl.edu.agh.wp.orm.exception.ORMException;
import pl.edu.agh.wp.orm.postres.CommonKey;

import java.lang.reflect.Field;

public class DBColumnObject{

    protected Field field;
    private String columnName;
    private boolean unique;
    private boolean nullable;
    private int maxLength;
    private int scale;
    private int precision;
    private TypeConverter converter;

    public DBColumnObject(Field field) {
        this.field = field;
        if (!this.field.isAccessible())
            this.field.setAccessible(true);
    }

    public String getColumnName() {
        return columnName;
    }

    public boolean isUnique() {
        return unique;
    }

    public boolean isNullable() {
        return nullable;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getScale() {
        return scale;
    }

    public int getPrecision() {
        return precision;
    }

    public TypeConverter getConverter() {
        return converter;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }


    /**
     *  @see Type
     *  @see TypeConverter
     *
     * @param converter
     */
    public void setConverter(TypeConverter converter) {
        this.converter = converter;
    }

    public String getSQLStringValue(Object o){
        Object value  = getValue(o);
        if(value!= null)
            return converter.getAsString(value);
        else return CommonKey.NULL;
    }
    public Object getValue(Object o) {
        try {
            return field.get(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void setValue(Object entity,Object dataBaseField){
        try {
            field.set(entity,dataBaseField);
        } catch (IllegalAccessException e) {
            throw new ORMException("Cannot set Object ",e);
        }
    }
}


