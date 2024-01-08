package service.impl;


import service.SearchService;

import java.util.List;

public class SearchServiceDataBaseImpl implements SearchService {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("数据库搜索: "+keyword);
        return null;
    }
}
