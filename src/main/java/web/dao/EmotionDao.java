package web.dao;

import org.apache.ibatis.annotations.Param;
import web.entity.EmotionTO;
import web.entity.StockDayInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by yuhao.zx on 15-9-14.
 */
public interface EmotionDao {
    List<EmotionTO> selectEmotionsByday(@Param("publishTime") String publishTime, @Param("stockId") String stockId);
    List<EmotionTO> selectEmotionsBystock(@Param("stockId") String stockId);
    List<String> selectEmositonReadable();
}
