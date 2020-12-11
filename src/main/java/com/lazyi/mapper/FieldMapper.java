package com.lazyi.mapper;

import com.lazyi.pojo.Field;
import com.lazyi.pojo.FieldManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FieldMapper {

    @ResultType(Integer.class)
    Integer getPrimayKey();

    @ResultType(Integer.class)
    List<Field> queryFieldById(@Param("fieldId") Integer FieldId);

    List<Field> queryFieldByFieldManagerId(@Param("fieldManagerId") Integer FieldManagerId);

    void addField(@Param("fieldId") Integer fieldId,
                  @Param("fieldName") String fieldName,
                  @Param("fieldSpace") String fieldSpace,
                  @Param("openTime") String openTime,
                  @Param("fieldManagerId") Integer fieldManagerId);

    void updateField( @Param("fieldName") String fieldName,
                      @Param("fieldSpace") String fieldSpace,
                      @Param("openTime") String openTime,
                      @Param("fieldState") Integer fieldState,
                      @Param("fieldManagerId") Integer fieldManagerId,
                      @Param("fieldId") Integer fieldId);

    void updateFieldState(@Param("fieldId") Integer fieldId,
                          @Param("fieldState") Integer fieldState);


}
