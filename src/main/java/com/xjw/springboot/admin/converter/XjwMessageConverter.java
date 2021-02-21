package com.xjw.springboot.admin.converter;

import com.xjw.springboot.admin.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class XjwMessageConverter implements HttpMessageConverter<Person> {

    /**
     * json、xml数据能不能转成Person
     */
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return false;
    }

    /**
     * 输出的参数是Person
     */
    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return aClass.isAssignableFrom(Person.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-xjw");
    }

    @Override
    public Person read(Class<? extends Person> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String data = person.getPname()+";"+person.getAddr();
        OutputStream body = httpOutputMessage.getBody();
        body.write(data.getBytes());
        System.out.println("----");
    }
}
