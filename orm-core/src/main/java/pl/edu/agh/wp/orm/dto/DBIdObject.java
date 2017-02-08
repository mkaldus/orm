package pl.edu.agh.wp.orm.dto;

import pl.ed.agh.wp.orm.annotations.converter.types.TypeConverter;
import pl.ed.agh.wp.orm.annotations.enums.DatabaseTypes;
import pl.ed.agh.wp.orm.annotations.enums.GenerationType;
import pl.edu.agh.wp.orm.postres.CommonKey;

import java.lang.reflect.Field;

public class DBIdObject {

    private Field field;
    private String columnName;
    private Boolean isAutoGenerated;
    private GenerationType generationType;
    private String sequenceName;
    private TypeConverter converter;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isAutoGenereted() {
        return isAutoGenerated;
    }

    public void setAutoGenereted(boolean autoGenereted) {
        isAutoGenerated = autoGenereted;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public GenerationType getGenerationType() {
        return generationType;
    }

    public void setGenerationType(GenerationType generationType) {
        this.generationType = generationType;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public TypeConverter getConverter() {
        return converter;
    }

    public void setConverter(TypeConverter converter) {
        this.converter = converter;
    }


    public String getSQLStringValue(Object o){
        Object value  =getValue(o);
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
}