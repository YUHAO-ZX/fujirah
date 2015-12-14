package web.dao;

import web.entity.StockCodes;

import java.util.List;

/**
 * Created by yuhao.zx on 15-9-14.
 */
public interface StocDao {
    List<StockCodes> selectByIndustryCode(String fcode);
}
