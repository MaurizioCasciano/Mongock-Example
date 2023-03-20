package dev.example.mongock.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public interface DatasetLoader<T> {
    default ObjectMapper objectMapper() {
        // https://stackoverflow.com/a/32202201/8737144
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        return mapper;
    }

    default List<T> loadDataset(Class<T> clazz, String resourceLocation) {
        List<T> list = new ArrayList<>();
        ObjectMapper mapper = this.objectMapper();

        CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);

        try {
            URL json = ResourceUtils.getURL(resourceLocation);
            list = mapper.readValue(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    default T loadData(Class<T> clazz, String resourceLocation) {
        T data = null;
        ObjectMapper mapper = this.objectMapper();

        try {
            URL json = ResourceUtils.getURL(resourceLocation);
            data = mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
