package com.lksun.library.Mapper;


import com.lksun.library.entity.Page.PageRequest;
import com.lksun.library.entity.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper  // 如果配置了MapperScan则不需要此注解了
public interface ReaderMapper {

    int createReader(Reader reader);

    List<Reader> get(PageRequest pageRequest);

    @Select("select * from readers where id = #{id}")
    Reader getById(@Param("id") Integer id);
}
