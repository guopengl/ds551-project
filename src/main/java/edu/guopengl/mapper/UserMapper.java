package edu.guopengl.mapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.guopengl.entity.User;
import edu.guopengl.utils.HttpUtil;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {
    public User findByNameAndPassword(String name, String password){
        JSONObject resquestParams = new JSONObject();
        resquestParams.put("collectionName", "user");
        JSONObject query = new JSONObject();
        query.put("name", name);
        query.put("password", password);
        resquestParams.put("query", query);

        JSONArray data = HttpUtil.post("http://localhost:8080/find", resquestParams).getJSONArray("data");
        if(data.size() == 0){
            return null;
        }
        JSONObject userData = data.getJSONObject(0);
        return new User(userData.getString("name"), userData.getString("password"),
                userData.getInteger("role"), userData.getInteger("balance"));
    }

}
