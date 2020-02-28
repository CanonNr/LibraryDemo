package com.lksun.library.Service;

import com.lksun.library.entity.Reader;
import java.util.List;


public interface ReaderService {

    int createReader(Reader reader);

    List<Reader> get();


}
