package pl.edu.agh.wp.orm.dto;

import pl.edu.agh.wp.orm.converter.Type;
import pl.edu.agh.wp.orm.postres.DatabaseTypes;

import java.lang.reflect.Field;

public class DBColumnObject {

    private Field field;
    private String columnName;
    private boolean unique;
    private boolean nullable;
    private int maxLength;
    private int scale;
    private int precision;
    private Type databaseType;

    public DBColumnObject(Field field) {
        this.field = field;
        if (!this.field.isAccessible()) this.field.setAccessible(true);

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

    public Type getDatabaseType() {
        return databaseType;
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
     *  @see pl.edu.agh.wp.orm.annotations.Type
     *  @see pl.edu.agh.wp.orm.converter.Type
     *
     * @param databaseType
     */
    public void setDatabaseType(Type databaseType) {
        this.databaseType = databaseType;
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


