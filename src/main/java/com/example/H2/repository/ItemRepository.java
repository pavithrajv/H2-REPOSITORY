package com.example.H2.repository;

import com.example.H2.model.Items;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ItemRepository {
    @Autowired
    JdbcTemplate template;

    /*Getting all Items from table*/
    public List<Items> getAllItems() {
        List<Items> items = template.query("select id, name,category from item", (result, rowNum) -> new Items(result.getInt("id"),
                result.getString("name"), result.getString("category")));
        return items;
    }

    /*Getting a specific item by item id from table*/
    public Items getItem(int itemId) {
        String query = "SELECT * FROM PRODUCTS WHERE ID=?";
        Items item = template.queryForObject(query, new Object[]{itemId}, new BeanPropertyRowMapper<>(Items.class));

        return item;
    }

    /*Adding an item into database table*/
    public int addItem(int id, String name, String category) {
        String query = "INSERT INTO PRODUCTS VALUES(?,?,?)";
        return template.update(query, id, name, category);
    }

    /*delete an item from database*/
    public int deleteItem(int id) {
        String query = "DELETE FROM PRODUCTS WHERE ID =?";
        return template.update(query, id);
    }

}
