package web.dao;

import org.apache.ibatis.annotations.Param;
import web.entity.StockDayInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by yuhao.zx on 15-9-14.
 */
public interface DayReportDao {
    List<StockDayInfo> selectDayreportWithTime(@Param("symbol") String symbol,@Param("startTime") Date startTime,@Param("endTime") Date endTime);
    StockDayInfo selectDayreportBySymbolAndDay(@Param("symbol") String symbol,@Param("date") Date date);
}
