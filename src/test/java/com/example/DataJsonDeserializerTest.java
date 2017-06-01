package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(JUnit4.class)
public class DataJsonDeserializerTest {

    private ObjectMapper objectMapper;

    private DataJsonDeserializer deserializer;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        deserializer = new DataJsonDeserializer(objectMapper);
    }

    @Test
    public void should_deserializ_employee_absence() throws IOException {
        String json = "{\n" +
            "  \"type\": {\n" +
            "    \"name\": \"ABSENCE\"\n" +
            "  },\n" +
            "  \"description\": \"some description\",\n" +
            "  \"people\": [\n" +
            "    {\"id\": 1, \"numberOfDays\": 5}\n" +
            "  ]\n" +
            "}";

        BasicDataJson dataJson = deserializer.read(json);

        assertThat(dataJson.getType()).isEqualTo(DataType.ABSENCE);
        assertThat(dataJson).is(instancesOf(DataJson.class));
        assertThat(dataJson.getPeople()).are(instancesOf(EmployeeAbsence.class));
    }

    @Test
    public void should_deserializ_new_name() throws IOException {
        String json = "{\n" +
            "  \"type\": {\n" +
            "    \"name\": \"NEW_NAME\"\n" +
            "  },\n" +
            "  \"people\": [\n" +
            "    {\"id\": 1, \"name\": \"Tom\"}\n" +
            "  ]\n" +
            "}";

        BasicDataJson dataJson = deserializer.read(json);

        assertThat(dataJson.getType()).isEqualTo(DataType.NEW_NAME);
        assertThat(dataJson).is(instancesOf(BasicDataJson.class));
        assertThat(dataJson.getPeople()).are(instancesOf(EmployeeNewName.class));
    }

    private Condition instancesOf(Class clazz) {
        return new Condition(other -> other.getClass().isAssignableFrom(clazz), "instance of %s", clazz.getName());
    }
}
