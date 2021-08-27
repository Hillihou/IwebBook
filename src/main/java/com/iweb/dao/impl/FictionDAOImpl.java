package com.iweb.dao.impl;

import com.iweb.dao.BaseDAO;
import com.iweb.dao.FictionDAO;
import com.iweb.pojo.Fiction;
import com.iweb.pojo.FictionUser;
import com.iweb.pojo.Managerinfo;
import com.iweb.util.PageModel;

import java.util.List;

public class FictionDAOImpl extends BaseDAO implements FictionDAO {

    @Override
    public List<Fiction> getFictions(String likeValue, PageModel pageModel) {
        StringBuffer sql=new StringBuffer("SELECT fictionId,fictionName,author,pages,createTime,descriptions,isMember,isputaway,putawayTime,fictionimg FROM fiction ");
        StringBuffer sqlCount=new StringBuffer("SELECT COUNT(*) FROM fiction ");
        int pageSize = pageModel.getPageSize();
        int pageNo = pageModel.getPageNo();

        if (likeValue!=null&&!"".equals(likeValue)){
            sql.append("WHERE fictionId LIKE ? or fictionName LIKE ? or author LIKE ? or descriptions LIKE ? ");
            sql.append(" order by fictionId desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            sqlCount.append("WHERE fictionId LIKE ? or fictionName LIKE ? or author LIKE ? or descriptions LIKE ? ");
            Long count = (Long) queryForSingleValue(sqlCount.toString(), "%" + likeValue + "%", "%" + likeValue + "%", "%" + likeValue + "%","%" + likeValue + "%");
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
            return queryForList(Fiction.class,sql.toString(),"%" + likeValue + "%", "%" + likeValue + "%", "%" + likeValue + "%","%" + likeValue + "%");
        }else{
            sql.append(" order by fictionId desc LIMIT "+(pageNo-1)*pageSize+","+pageSize);
            Long count = (Long) queryForSingleValue(sqlCount.toString());
            if (count==null){
                pageModel.setRecordCount(1);
            }else {
                pageModel.setRecordCount(count.intValue());
            }
            return queryForList(Fiction.class,sql.toString());
        }
    }

    @Override
    public Fiction queryById(Integer id) {
        String sql="SELECT fictionId,fictionName,author,pages,createTime,descriptions,isMember,isputaway,putawayTime,fictionimg FROM fiction where fictionId=?";
        return queryForOne(Fiction.class,sql,id);
    }

    @Override
    public int saveOne(Fiction fiction) {

        String sql="INSERT INTO fiction(fictionName,author,pages,createTime,descriptions,isMember,isputaway,putawayTime) VALUES(?,?,?,NOW(),?,?,?,?)";
        return update(sql,fiction.getFictionName(),fiction.getAuthor(),fiction.getPages(),fiction.getDescriptions(),fiction.getIsMember(),fiction.getIsputaway(),fiction.getPutawayTime());

    }

    @Override
    public int updateOne(Fiction fiction) {
        return 0;
    }

    @Override
    public int deleteOne(Integer id) {
        return 0;
    }
}
