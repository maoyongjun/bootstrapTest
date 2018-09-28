package org.foxconn.bootstrapTest.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.foxconn.bootstrapTest.entity.LabelEntity;
import org.foxconn.bootstrapTest.entity.ServerComponent;
import org.springframework.dao.DataAccessException;

@Mapper
public interface  Label2Dao {
	
	@Select("<script>SELECT 	Id,parentSkuno,skuno,qty,isPreDo,b.version,b.description ,label,others "+
			"FROM 	sfcskunolabel a LEFT JOIN mmprodmaster  b"+
 			"	ON	a.skuno= b.partno WHERE a.skuno =#{skuno}"
 			+ "<when test='parentSkuno!=null'>and b.partno=#{parentSkuno}</when></script>")
	public List<LabelEntity> findAllLabel(LabelEntity label);
	@Options(statementType=StatementType.CALLABLE)
	@Select("{call testPro"+
		     "(#{pallents,mode=IN,jdbcType=VARCHAR})}")
	public List<ServerComponent> getSendComponent(@Param("pallents")String pallents) throws DataAccessException;

}
