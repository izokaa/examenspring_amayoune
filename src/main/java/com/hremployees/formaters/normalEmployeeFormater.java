package com.hremployees.formaters;

import com.hremployees.entities.NormalEmployee;
import org.springframework.core.convert.converter.Converter;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;

public class normalEmployeeFormater implements Converter<String, NormalEmployee>, PropertyEditor {


    @Override
    public NormalEmployee convert(String s) {
        System.out.println(s);
        if(!s.equals(null)) {
            try {
                NormalEmployee normalEmployee = new NormalEmployee(Long.parseLong(String.valueOf(s)));
                return normalEmployee;
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            return null;
        }

        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public boolean isPaintable() {
        return false;
    }

    @Override
    public void paintValue(Graphics gfx, Rectangle box) {

    }

    @Override
    public String getJavaInitializationString() {
        return null;
    }

    @Override
    public String getAsText() {
        return null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

    }

    @Override
    public String[] getTags() {
        return new String[0];
    }

    @Override
    public Component getCustomEditor() {
        return null;
    }

    @Override
    public boolean supportsCustomEditor() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

}
