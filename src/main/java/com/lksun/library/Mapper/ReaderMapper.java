package com.lksun.library.Mapper;


import com.lksun.library.entity.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReaderMapper {
    int createReader(Reader reader);
    List<Reader> get();
}
