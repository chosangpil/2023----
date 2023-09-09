package com.gg.compList;

import java.util.List;

public interface CompListService {
    public abstract List<CompListDTO> compList();

    public abstract int compNo(String co_id);
}
