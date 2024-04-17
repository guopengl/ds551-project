package edu.guopengl.service;

import com.alibaba.fastjson.JSONArray;
import edu.guopengl.mapper.PurchaseMapper;
import edu.guopengl.params.PurchaseDeleteParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    public JSONArray findByName(String name) throws Exception {
        return purchaseMapper.findByUserName(name);
    }

    public void delete(PurchaseDeleteParams purchaseDeleteParams) throws Exception {
        purchaseMapper.deleteByUserNameAndGameName(purchaseDeleteParams.getUserName(), purchaseDeleteParams.getGameName());
    }
}
