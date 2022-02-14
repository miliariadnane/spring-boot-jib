package dev.nano.springbootjib.mockData;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import dev.nano.springbootjib.model.Customer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static ImmutableList<Customer> getCustomers() throws IOException {
        InputStream inputStream = Resources.getResource("customers.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Customer>>() {
        }.getType();
        List<Customer> people = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(people);
    }

}
