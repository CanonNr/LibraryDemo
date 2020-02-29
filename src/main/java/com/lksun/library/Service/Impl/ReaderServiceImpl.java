package com.lksun.library.Service.Impl;

import com.lksun.library.Mapper.ReaderMapper;
import com.lksun.library.Service.ReaderService;
import com.lksun.library.entity.Page.PageRequest;
import com.lksun.library.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public int createReader(Reader reader) {
        return readerMapper.createReader(reader);
    }

    @Override
    public List<Reader> get(PageRequest pageRequest) {
        return readerMapper.get(pageRequest);
    }

    @Override
    public Reader getById(Integer id) {
        return readerMapper.getById(id);
    }

    public Integer getCount(){
        return readerMapper.getCount();
    }
}
